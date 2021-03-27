<?php
header('Access-Control-Allow-Origin: *');
  header('Content-Type: application/json');

$con= mysqli_connect("localhost","root","","project");
$response= array();
if($con){
    $sql = "select * from ultrasonic";
    $result = mysqli_query($con,$sql);
    if($result){
        $i=0;
        while($row =mysqli_fetch_assoc($result)){
            $response[$i]['Percent']=$row['Percent'];
            
            $i++;
        }
        echo json_encode($response,JSON_PRETTY_PRINT);
    }
}
else{
    echo "Database Connection";
}
?>