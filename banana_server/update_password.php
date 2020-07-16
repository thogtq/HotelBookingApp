<?php
$username  = $_POST['username'];
$password = password_hash($_POST['password'],PASSWORD_DEFAULT);
$token = $_POST['token'];
$data = array(
    'status'=>0,
    'message'=>'empty_res'
);

$username_current = get_user($token,$conn)["USERNAME"];

if(empty($token)){
    $data['status']=0;
    $data['message']="Không tìm thấy thông tin người dùng, vui lòng đăng nhập lại !";
    die(json_encode($data));
}
if($username != $username_current){
    $data['status']=0;
    $data['message']="Username không hợp lệ !";
    die(json_encode($data));
}

$conn->query("UPDATE nguoi_dung set
password = '$password'
WHERE username = '$username'
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