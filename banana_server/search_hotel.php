<?php
//$conn = new mysqli();
$loc=$_POST['loc'];
$start_date=$_POST['start_date'];
$end_date=$_POST['end_date'];
$adult_num=empty($_POST['adult_num'])? $_POST['adult_num'] :0;
$child_num=empty($_POST['child_num'])? $_POST['child_num']:0;
$total_guest=(int)$adult_num+(int)$child_num;
$data = array(
    'status'=>0,
    'list_data'=>'',
    'message'=>'empty'
);
//Location preprocessing
$loc = trim(ucwords($loc));
switch ($loc){
    case "Vung Tau":
        $loc = "Vũng Tàu";
        break;
    case "Da Lat":
        $loc = "Đà Lạt";
        break;
    case "Da Nang":
        $loc = "Đà Nẵng";
        break;
    case "Ha Noi":
        $loc = "Hà Nội";
        break;
    case "Ho Chi Minh":
        $loc = "Hồ Chí Minh";
        break;
}
if(empty($_POST['start_date']) || empty($_POST['end_date'])) die(json_encode($data));
// STR_TO_DATE(,'%d/%m/%Y')
//Query
$result = $conn->query(
    "
    SELECT p.ma_phong, ten_phong, loai_giuong, dien_tich, suc_chua, ten_ks, ten,gia_phong
    FROM phong p
    INNER JOIN khach_san ks on p.ma_khach_san = ks.ma_khach_san
    INNER JOIN thanh_pho tp on ks.ma_thanh_pho = tp.ma_thanh_pho
    WHERE suc_chua >= $total_guest AND ten = '$loc' AND NOT EXISTS (
        SELECT * FROM dat_phong dp
        WHERE dp.ma_phong = p.ma_phong AND dp.tinh_trang = 'pending' AND( 
            (STR_TO_DATE('$start_date','%d/%m/%Y') >= ngay_den AND STR_TO_DATE('$start_date','%d/%m/%Y') < ngay_di)
        OR (STR_TO_DATE('$end_date','%d/%m/%Y') > ngay_den AND STR_TO_DATE('$end_date','%d/%m/%Y') <= ngay_di) 
        OR (STR_TO_DATE('$start_date','%d/%m/%Y') < ngay_den AND STR_TO_DATE('$end_date','%d/%m/%Y') > ngay_di) 
            )
    )
    "
);

if ($result->num_rows){
    $data['list_data']=$result->fetch_all(MYSQLI_ASSOC);
    $data['status']=1;
    $data['message']=$result->num_rows;
    die(json_encode($data));
}else{
    $data['message']='Chúng tôi không thể tìm thấy kết quả theo yêu cầu của bạn, vui lòng thử lại.';
    die(json_encode($data));
}
