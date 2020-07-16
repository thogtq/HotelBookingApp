<?php
require_once "config.php";
require_once "function.php";

$request = $_GET['apicall'];
switch ($request){
    case 'login':
        include "login.php";
        break;
    case'register':
        include "register.php";
        break;
    case 'search_hotel';
        include "search_hotel.php";
        break;
    case'get_room':
        include "get_room.php";
        break;
    case 'book_hotel':
        include "book_hotel.php";
        break;
        case 'get_calendar';
        include "get_calendar.php";
        break;
    case 'cancel_booking':
        include "cancel_booking.php";
        break;
    case 'update_info':
        include "update_info.php";
        break;
    case 'update_password':
        include "update_password.php";
        break;
}