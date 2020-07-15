<?php
$user_data =array(
    'ho_ten'=>$_POST['ho_ten'],
    'username'=>$_POST['username'],
    'password'=>password_hash($_POST['password'],PASSWORD_DEFAULT),
    'email'=>$_POST['email'],
    'sdt'=>$_POST['sdt']
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
$stmt = $conn->prepare('insert into nguoi_dung(username,password,ho_ten,email,sdt) values(?,?,?,?,?)');
$stmt->bind_param('sssss',$user_data['username'],$user_data['password'],$user_data['ho_ten'],$user_data['email'],$user_data['sdt']);

if($stmt->execute()){
    $data['status']=true;
    $data['message']='Successful';
    die(json_encode($data));
}else{
    $data['status']=false;
    $data['message']=$stmt->error;
    die(json_encode($data));
}
