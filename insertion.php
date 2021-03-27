<?php
class Ultra{
 public $link='';
 function __construct($Percent){
  $this->connect();
  $this->storeInDB($Percent);
 }
 
 function connect(){
  $this->link = mysqli_connect('localhost','root','') or die('Cannot connect to the DB');
  mysqli_select_db($this->link,'project') or die('Cannot select the DB');
 }
 
 function storeInDB($Percent){
  $query = "insert into ultrasonic set Percent='".$Percent."'";
  $result = mysqli_query($this->link,$query) or die('Errant query:  '.$query);
 }
 
}
if($_GET['Percent'] != '' ){
 $Ultra=new Ultra($_GET['Percent']);
}
?>