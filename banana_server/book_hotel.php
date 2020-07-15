<?php
//$conn = new mysqli();
$userToken = $_POST['token'];
$startDate = $_POST['start_date'];
$endDate = $_POST['end_date'];
$totalPrice = $_POST['total_price'];
$roomId = $_POST['room_id'];
$bookDate = date("d/m/Y");
$data = array(
    'status'=>0,
    'message'=>'empty_res'
);
if(empty($userToken)){
    $data['message']="Không tìm thấy thông tin người dùng, vui lòng đăng nhập lại !";
    die(json_encode($data));
}
$now = time(); // or your date as well
$datediff =  DateTime::createFromFormat('!d/m/Y', $endDate)->getTimestamp()- DateTime::createFromFormat('!d/m/Y', $startDate)->getTimestamp();
$datediff =round($datediff / (60 * 60 * 24));
$roomPrice = $conn->query("SELECT gia_phong from phong where phong.ma_phong = '$roomId'")->fetch_assoc()["gia_phong"];
$roomPrice *= (int)$datediff;
if($roomPrice != $totalPrice){
    $data['message']="Tổng tiền không hợp lệ !\n".$roomPrice." vs ".$totalPrice;
    die(json_encode($data));
}

$userId = get_user($userToken,$conn)["MA_NGUOI_DUNG"];
//var_dump($userId["MA_NGUOI_DUNG"]);die();
// STR_TO_DATE(?,"%d/%m/%Y")
$stmt = $conn->prepare('insert into dat_phong(ma_nguoi_dung,ma_phong,tong_tien,ngay_den,ngay_di,ngay_dat) values(?,?,?,STR_TO_DATE(?,"%d/%m/%Y"),STR_TO_DATE(?,"%d/%m/%Y"),STR_TO_DATE(?,"%d/%m/%Y"))');
$stmt->bind_param('ssisss',$userId,$roomId,$totalPrice,$startDate,$endDate,$bookDate);
if($stmt->execute()){
    $id = $conn->insert_id;
    $ma_dat_phong = "DP".(int)$id;
    $conn->query("update dat_phong set ma_dat_phong = '$ma_dat_phong',tinh_trang ='pending',is_review = 0 where id =$id");
    $data['status']=1;
    $data['message']='Successful';
    die(json_encode($data));
}else{
    $data['status']=0;
    $data['message']=$stmt->error;
    die(json_encode($data));
}