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

$start = mysqli_real_escape_string($dbc, $_GET['start']);
$end = mysqli_real_escape_string($dbc,$_GET['end']);
$busNum = mysqli_real_escape_string($dbc,$_GET['busNum']);
$phone = mysqli_real_escape_string($dbc,$_GET['phone']);
$dtime =date(mysqli_real_escape_string($dbc,$_GET['dtime']));


$query1 = "INSERT INTO bookHistory (phoneNumber, origin, destination, busNumber, dtime) VALUES ('$phone', '$start', '$end', '$busNum', '$dtime')";
$result = mysqli_query($dbc, $query1) or trigger_error("Query MySQL Error: " . mysqli_error($dbc));

$query = "UPDATE routeInfo SET seats = seats-1 where (origin, destination, busNumber)=('$start', '$end', '$busNum')";
$result = mysqli_query($dbc, $query) or trigger_error("Query MySQL Error: " . mysqli_error($dbc));

echo 'Done';
mysqli_close($dbc); 

?>
