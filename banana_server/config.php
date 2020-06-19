<?php
//Cau hinh va ket noi den db
define('DBDRIVER', 'mysqli');
define('DBHOST','localhost');
define('DBNAME','bananabooking_db');
define('DBUSER','root');
define('DBPASSWORD','');
date_default_timezone_set("Asia/Singapore");
$conn = new mysqli(DBHOST, DBUSER, DBPASSWORD, DBNAME);
if ($conn->connect_error) {
    die("Connection failed");
}