<?php
$token = $_POST['token'];
$ma_dat_phong = $_POST['maDp'];

$data = array(
    'status'=>0,
    'message'=>'empty_res'
);
if(empty($token)){
    $data['message']="Không tìm thấy thông tin người dùng, vui lòng đăng nhập lại !";
    die(json_encode($data));
}
$userId = get_user($token,$conn)["MA_NGUOI_DUNG"];
$userDpId = $conn->query("SELECT ma_nguoi_dung from dat_phong where ma_dat_phong = '$ma_dat_phong'")->fetch_assoc()["ma_nguoi_dung"];

if($userId != $userDpId){
    $data['message']="Người dùng không hợp lệ !\n";
    die(json_encode($data));
}

$conn->query("update dat_phong set tinh_trang ='canceled' where ma_dat_phong ='$ma_dat_phong'");
if($conn->error){
    $data['status']=0;
    $data['message']=$conn->error;
    die(json_encode($data));
}else{
    $data['status']=1;
    $data['message']='Successful';
    die(json_encode($data));
}
