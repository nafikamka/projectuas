<?php
$server = "localhost";
$username = "id13881388_root";
$password = ">[<A/9k?~HU-ZreP";
$dbname = "id13881388_jsoncarmudi";

//koneksi
$conn = new mysqli($server,$username,$password,$dbname);

//check koneksi
if($conn->connect_error){
	die("koneksi gagal/failed".$conn->connect_error);
}
$sql="select * from t_menu";
$result=$conn->query($sql);
$data=array();

if($result->num_rows>0){
	while($row=$result->fetch_assoc()){
		$data[]=$row;
	}
	}else{
		echo"data kosong";
	}
	echo json_encode($data);
	$conn->close();
	?>