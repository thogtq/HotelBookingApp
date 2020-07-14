<?php
$room_id=$_POST['room_id'];
$data = array(
    'status'=>0,
    'room_data'=>'',
    'message'=>'empty'
);
if(empty($room_id)) die(json_encode($data));

$result = $conn->query("SELECT * FROM phong p INNER JOIN khach_san ks ON p.ma_khach_san = ks.ma_khach_san WHERE p.ma_phong ='$room_id'");
if(!$result->num_rows){
    $data['message']="Không tìm thấy phòng!";
    die(json_encode($data));
}else{
    $data['room_data']=$result->fetch_all(MYSQLI_ASSOC);
    $data['message']=$result->num_rows;
    $data['status']=1;
    die(json_encode($data));
}