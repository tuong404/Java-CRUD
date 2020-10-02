<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/LoginForm.css">
</head>
<body style=" background-image: url(./image/hinh-anh-nen-may-tinh-dep_102457270.png);">
	<div class="app">
        <div class="login">
            <img src="<c:url value='./image/images.png'/>" alt="user img">
            <h3 class="login__title">
                Login
            </h3>
            <form action="Login" method="post">
                <label for="input-username">Username</label>
                <input id="input-username" class="input-user" type="text" placeholder="Enter Username" name ="userName"> <br>
                <label for="input-pass">Password</label>
                <input id="input-pass" class="input-pass" type="password" placeholder="Enter Password" name ="passWord"> <br>
               <div>
                <%
			    if(request.getParameter("err") != null){
				out.print("<div style='text-align:center';>"
							+ "<p style='color: red'> "
							+ "Please typing agian! </p> </div>");
			    }
		
		        %>
		        </div>
				
                <div class="login__submit">
                    <input class="input-submit" type="submit" value="Sign in" >
                    <button class="input-submit input-submit--signup">
                    	<a href="Register.jsp"> Sign up</a>
                    </button>
        
                </div>  
            </form> 
        </div>
    </div>
	

</body>
</html>