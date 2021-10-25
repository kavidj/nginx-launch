<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INVALID CREDENTIALS!</title>
<style>
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}


.imagecenter {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
</head>
<body>

<div class="alert">
  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  <strong>INVALID CREDENTIALS!</strong> 
</div>

<img src="image/pistol.jpg"
     alt="test2.png"  Class="imagecenter"/>

</body>
</html>
