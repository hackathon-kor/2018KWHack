if (db === undefined) {
  console.log(db);
  var db = firebase.firestore();
  var settings = { timestampsInSnapshots: true };
  db.settings(settings);
}
