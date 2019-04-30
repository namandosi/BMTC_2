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

$query = "SELECT * from bookHistory where phoneNumber='$phone'";

$result = mysqli_query($dbc, $query) or trigger_error("Query MySQL Error: " . mysqli_error($dbc));
//$row = $result->fetch_row();
while($row=$result->fetch_assoc())
{
echo $row['id'],",",$row['origin'],",",$row['destination'],",",$row['busNumber'],",",$row['dtime'],"\n";
}

mysqli_close($dbc); 

?>
