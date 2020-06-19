<?php

$username = $_POST['username'];
$password = $_POST['password'];

$data = array(
    'status'=>false,
    'token'=>'',
    'user_data'=>'',
    'message'=>'Error'
);

if(empty($username) || empty($password)) die(json_encode($data));
$stmt = $conn->prepare('select password from nguoi_dung where username = ?');
$stmt->bind_param('s',$username);
$stmt->execute();
$result = $stmt->get_result();
if($result->num_rows === 0) die(json_encode($data));
$result = $result->fetch_assoc();
if (password_verify($password,$result['password'])){
    $token =  md5(uniqid($username, true));
    update_token($token,$username,$conn);
    $user_data = get_user($token,$conn);
    $data['status']=true;
    $data['token']=$token;
    $data['user_data']=$user_data;
    $data['message']='Successful';
    die(json_encode($data));
}else{die(json_encode($data));}






