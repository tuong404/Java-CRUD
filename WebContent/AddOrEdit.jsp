 <%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddOrEdit</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/AddOrEdit.css">
</head>
<body>
<div style=" background-image: url(<%=request.getContextPath()%>/image/hinh-anh-nen-may-tinh-dep_102457270.png);" class="information">
        <div class="head">
            <div class="logo">
                <a href="#">
                    <svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="envelope" class="svg-inline--fa fa-envelope fa-w-16" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M502.3 190.8c3.9-3.1 9.7-.2 9.7 4.7V400c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V195.6c0-5 5.7-7.8 9.7-4.7 22.4 17.4 52.1 39.5 154.1 113.6 21.1 15.4 56.7 47.8 92.2 47.6 35.7.3 72-32.8 92.3-47.6 102-74.1 131.6-96.3 154-113.7zM256 320c23.2.4 56.6-29.2 73.4-41.4 132.7-96.3 142.8-104.7 173.4-128.7 5.8-4.5 9.2-11.5 9.2-18.9v-19c0-26.5-21.5-48-48-48H48C21.5 64 0 85.5 0 112v19c0 7.4 3.4 14.3 9.2 18.9 30.6 23.9 40.7 32.4 173.4 128.7 16.8 12.2 50.2 41.8 73.4 41.4z"></path></svg>
                </a>   
            </div>
            <div class="info">
                <form action="Logout" method="post" >
                	<input class="btn-logout" type="submit" value="Log out">
                </form>
            </div>
        </div>
        
        <div class="main">
            <c:if test="${user != null}">
                   <form action="update" method="post">
            </c:if>
            <c:if test="${user == null}">
                   <form action="insert" method="post">
            </c:if>
            <caption>
                <h2 class="title">
                    <c:if test="${user != null}">
                        Edit User
                    </c:if>
                    <c:if test="${user == null}">
                        Add User
                    </c:if>
                </h2>
            </caption>
			
				<input type="hidden" name="id" value="<c:out value='${user.id}' />" />


			<div class="form">
				<label for="info1">FirstName: </label> <input type="text" id="info1"
					value="<c:out value='${user.firstName}' />" name="firstname">
			</div>
			<div class="form">
				<label for="info2">LastName: </label> <input type="text" id="info2"
					value="<c:out value='${user.lastName}' />" name="lastname">
			</div>
			<div class="form edit">
				<label for="info3">Email: </label> <input type="text" id="info3"
					value="<c:out value='${user.email}' />" name="email">
			</div>

			<div class="btn">
				<input type="submit" class="btn-click btn-click--save" value="Save">
				
				<input type="reset" class="btn-click btn-click--reset" value="Reset">

			</div>
			</form>
        </div>
    </div>
</body>
</html>