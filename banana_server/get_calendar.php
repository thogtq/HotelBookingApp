<?php
$userToken = $_POST['token'];
$Status = $_POST['status'];
$data = array(
    'status'=>0,
    'message'=>'empty_res',
    'list_hotel'=>array()
);
if(empty($userToken)){
    $data['message']="Không tìm thấy thông tin người dùng, vui lòng đăng nhập lại !";
    die(json_encode($data));
}
$userId = get_user($userToken,$conn)["MA_NGUOI_DUNG"];
$result = $conn->query("SELECT p.ma_phong,ks.ten_ks,p.ten_phong,DATE_FORMAT(dp.ngay_den,'%d/%m/%Y') as ngay_den,DATE_FORMAT(dp.ngay_di,'%d/%m/%Y') as ngay_di,dp.tong_tien,p.gia_phong
FROM dat_phong dp 
INNER JOIN phong p ON dp.ma_phong = p.ma_phong
INNER JOIN khach_san ks ON ks.ma_khach_san = p.ma_khach_san
WHERE dp.ma_nguoi_dung = $userId AND dp.tinh_trang = '$Status'
ORDER BY dp.ngay_dat DESC
");
if($conn->error){
    $data['message']=$conn->error;
    die(json_encode($data));
}else{
    $data['status']=1;
    $data['list_hotel']=$result->fetch_all(MYSQLI_ASSOC);
    $data['message']='Success';
    die(json_encode($data));
}