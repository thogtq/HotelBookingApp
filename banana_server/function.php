<?php
function update_token($token,$username,$conn){
    $stmt = $conn->prepare('update nguoi_dung set token=? where username=?');
    $stmt->bind_param('ss',$token,$username);
    $stmt->execute();
}
function get_user($token,$conn){
    if(empty($token)) return false;
    $stmt = $conn->prepare('select * from nguoi_dung where token = ?');
    $stmt->bind_param('s',$token);
    $stmt->execute();
    $result = $stmt->get_result();
    if($result->num_rows === 0) return false;
    return $result->fetch_assoc();
}
function is_username_exist($username,mysqli $conn){
    $stmt = $conn->prepare('select ma_nguoi_dung from nguoi_dung where username = ?');
    $stmt->bind_param('s',$username);
    $stmt->execute();
    $result =$stmt->get_result();
    if($result->num_rows === 0) return false;
    else{
        return true;
    }
}