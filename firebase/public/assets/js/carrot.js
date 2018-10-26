// init firebase

var config = {
  apiKey: "AIzaSyD0-eXMzdE58hC1r6BeAoDSFLBszszvrAU",
  authDomain: "kwhack-2018.firebaseapp.com",
  databaseURL: "https://kwhack-2018.firebaseio.com",
  projectId: "kwhack-2018",
  storageBucket: "kwhack-2018.appspot.com",
  messagingSenderId: "548375290136"
};
firebase.initializeApp(config);
var db = firebase.firestore();
var settings = { timestampsInSnapshots: true };
db.settings(settings);

// firestore function

/**
 * account: (accountUuid, name)
 * carrot: (accountUuid, page, index)
 * carrotType: (accountUuid, subject, imageUrl)
 * carrotCharacter: (accountUuid, page)
 */

if (db === undefined) {
  var db = firebase.firestore();
  var settings = { timestampsInSnapshots: true };
  db.settings(settings);
}

db.insert = (datatype, args) => {
  var vo = carrotModel[datatype](args);
  return db
    .collection(datatype)
    .add(vo)
    .then(docRef => {
      console.log("Document written with ID: ", docRef.id);
      return docRef;
    })
    .catch(error => {
      console.error("Error adding document: ", error);
      return null;
    });
};

db.deleteAll = datatype => {
  db.collection(datatype)
    .get()
    .then(function(querySnapshot) {
      querySnapshot.forEach(function(doc) {
        doc.ref.delete();
      });
    })
    .then(() => console.log(true));
};

db.deleteOne = (datatype, document) => {
  db.collection(datatype)
    .doc(document)
    .delete()
    .then(function() {
      console.log("Document successfully deleted!");
    })
    .catch(function(error) {
      console.error("Error removing document: ", error);
    });
};

db.selectOne = (datatype, document) => {
  var docRef = db.collection(datatype).doc(document);
  docRef.get().then(function(doc) {
    if (doc.exists) {
      return doc;
    } else {
      return null;
    }
  });
};

db.selectAll = datatype => {
  db.collection(datatype)
    .get()
    .then(function(querySnapshot) {
      var list = [];
      querySnapshot.forEach(function(doc) {
        console.log(doc.id, " => ", doc.data());
        list.push(doc.data());
      });
      return list;
    });
};

db.updateAll = (datatype, document, data) => {
  return db
    .collection(datatype)
    .doc(document)
    .update(data)
    .then(function() {
      console.log("Document successfully updated!");
    })
    .catch(function(error) {
      // The document probably doesn't exist.
      console.error("Error updating document: ", error);
    });
};
