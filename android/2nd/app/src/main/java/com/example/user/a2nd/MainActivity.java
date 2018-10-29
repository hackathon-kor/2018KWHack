package com.example.user.a2nd;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    CarouselView customCarouselView;
    int NUMBER_OF_PAGES = 8;
    private ImageButton[] buttons = new ImageButton[7];
    private EditText edittext;
    private StorageReference mStorageRef;
    String name;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext = new EditText(this);
        buttons[0] = (ImageButton) findViewById(R.id.btn0);
        buttons[1] = (ImageButton) findViewById(R.id.btn1);
        buttons[2] = (ImageButton) findViewById(R.id.btn2);
        buttons[3] = (ImageButton) findViewById(R.id.btn3);
        buttons[4] = (ImageButton) findViewById(R.id.btn4);
        buttons[5] = (ImageButton) findViewById(R.id.btn5);
        buttons[6] = (ImageButton) findViewById(R.id.btn6);

        mStorageRef = FirebaseStorage.getInstance().getReference();

        //show();
        createCarrot();


        customCarouselView = (CarouselView) findViewById(R.id.customCarouselView);
        customCarouselView.setPageCount(NUMBER_OF_PAGES);
        // set ViewListener for custom view
        customCarouselView.setViewListener(viewListener);
    }

    ViewListener viewListener = new ViewListener() {

        @Override
        public View setViewForPosition(int position) {
            View customView = getLayoutInflater().inflate(R.layout.weekly, null);
            //set view attributes here

            return customView;
        }
    };

    void createCarrot() {
        WriteBatch batch = db.batch();
        Map<String, Object> carrot;
        for(int page=0; page<8; page++){
            for(int index=0;index<7;index++){
                carrot = new HashMap<>();
                carrot.put("name",name );
                carrot.put("page",page );
                carrot.put("index",index );
                carrot.put("status",0 );
                carrot.put("commentType",0 );
                carrot.put("comment",0);
                carrot.put("date",Timestamp.now() );
                DocumentReference carrotDoc = db.collection("carrot").document(name+"_"+page+"_"+index);
                batch.set(carrotDoc, carrot);
            }
        }

        batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                System.out.println("완료");
            }
        });
    }

    private void pushAccount(String name) {

        Map<String, Object> account = new HashMap<>();
        account.put("name", name);
        account.put("token", "");
        account.put("currentPage", 0);
        db.collection("account").document(name)
                .set(account, SetOptions.merge());
    }

    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog Title");
        builder.setMessage("AlertDialog Content");
        builder.setView(edittext);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        name = edittext.getText().toString();
                        pushAccount(name);
                    }
                });
        builder.show();
    }

    private View.OnClickListener btnListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            for(int i = 0; i < 5; i++){
            }
        }
    };
/*
    private void

    db.collection("users")
            .get()
        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
        @Override
        public void onComplete(@NonNull Task<QuerySnapshot> task) {
            if (task.isSuccessful()) {
                for (DocumentSnapshot document : task.getResult()) {
                    Log.d(TAG, document.getId() + " => " + document.getData());
                }
            } else {
                Log.w(TAG, "Error getting documents.", task.getException());
            }
        }
    });*/
}