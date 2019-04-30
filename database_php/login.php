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

$query = "SELECT password from user where phoneNumber='$phone'";

$result = mysqli_query($dbc, $query) or trigger_error("Query MySQL Error: " . mysqli_error($dbc));
$row = $result->fetch_row();
echo $row[0];

mysqli_close($dbc); 

?>
