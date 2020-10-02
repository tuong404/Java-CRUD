 <%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/Register.css">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body style=" background-image: url(<%=request.getContextPath()%>/image/hinh-anh-nen-may-tinh-dep_102457270.png);">
<div class="app">
        <div class="login">
        
            <img src="<c:url value='/image/images.png'/>" alt="user img">
			<h3 class="login__title">Register</h3>
			<form action="Register" method="post">
				<label for="input-firstname">First Name</label>
                <input id="input-firstname" class="input-user" type="text" placeholder="Enter FirstName" name="firstname">
                <label for="input-lastname">Last Name </label>
                <input id="input-lastname" class="input-user" type="text" placeholder="Enter LastName" name="lastname">
                <label for="input-username">Username</label>
                <input id="input-username" class="input-pass" type="text" placeholder="Enter Username" name="username">
                <label for="input-pass">Password</label>
                <input id="input-pass" class="input-pass" type="password" placeholder="Enter Password" name="password">
                <label for="input-email">Email</label>
                <input id="input-email" class="input-pass" type="text" placeholder="Enter Email" name="email">
                
				<div class="login__submit">
                    <input type="submit" class="input-submit input-submit--register" value="Save">
                    
                    <button class="input-submit" >
                        <a class="login-link" href="Login.jsp"> Return </a>
                    </button>
                </div>  
            </form>
            
        </div>
    </div>

</body>
</html>