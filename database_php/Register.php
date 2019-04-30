<?php 

DEFINE ('DBUSER', 'id9413838_anaghav'); 
DEFINE ('DBPW', 'anagha_0306'); 
DEFINE ('DBHOST', 'localhost'); 
DEFINE ('DBNAME', 'id9413838_bmtc'); 

$dbc = mysqli_connect(DBHOST,DBUSER,DBPW);
if (!$dbc) {
    die("Database connection failed: " . mysqli_error($dbc));
    exit();
}

$dbs = mysqli_select_db($dbc, DBNAME);
if (!$dbs) {
    die("Database selection failed: " . mysqli_error($dbc));
    exit(); 
}

$phone = mysqli_real_escape_string($dbc, $_GET['phone']);
$name = mysqli_real_escape_string($dbc,$_GET['name']);
$age = mysqli_real_escape_string($dbc,$_GET['age']);
$password = mysqli_real_escape_string($dbc,$_GET['password']);

$query = "INSERT INTO user (phoneNumber, name, age, password) VALUES ('$phone', '$name', '$age', '$password')";

$result = mysqli_query($dbc, $query) or trigger_error("Query MySQL Error: " . mysqli_error($dbc));

mysqli_close($dbc); 

?>
