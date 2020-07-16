<?php
$ho_ten = $_POST['ho_ten'];
$cmnd = $_POST['cmnd'];
$sdt = $_POST['sdt'];
$dia_chi = $_POST['dia_chi'];
$gioi_tinh = $_POST['gioi_tinh'];
$email = $_POST['email'];
$ngay_sinh = $_POST['ngay_sinh'];
$token = $_POST['token'];
$data = array(
    'status'=>0,
    'message'=>'empty_res'
);

$userId = get_user($token,$conn)["MA_NGUOI_DUNG"];
if(empty($userId)){
    $data['status']=0;
    $data['message']="Không tìm thấy ngươi dùng";
    die(json_encode($data));
}

$conn->query("UPDATE nguoi_dung set
ho_ten = '$ho_ten',
cmnd = '$cmnd',
sdt = '$sdt',
email = '$email',
ngay_sinh = '$ngay_sinh',
gioi_tinh = '$gioi_tinh',
dia_chi = '$dia_chi'
WHERE ma_nguoi_dung = $userId
");

if($conn->error){
    $data['status']=0;
    $data['message']=$conn->error;
    die(json_encode($data));
}else{
    $data['status']=1;
    $data['message']='Successful';
    die(json_encode($data));
}