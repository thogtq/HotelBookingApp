<?php
$user_data =array(
    'ho_ten'=>$_POST['ho_ten'],
    'username'=>$_POST['username'],
    'password'=>password_hash($_POST['password'],PASSWORD_DEFAULT)
);
$data = array(
  'status',
  'message'
);
if(is_username_exist($user_data['username'],$conn)){
    $data['status']=false;
    $data['message']='Error';
    die(json_encode($data));
}
$stmt = $conn->prepare('insert into nguoi_dung(username,password,ho_ten) values(?,?,?)');
$stmt->bind_param('sss',$user_data['username'],$user_data['password'],$user_data['ho_ten']);
if($stmt->execute()){
    $data['status']=true;
    $data['message']='Successful';
    die(json_encode($data));
}else{
    $data['status']=false;
    $data['message']=$stmt->error;
    die(json_encode($data));
}
