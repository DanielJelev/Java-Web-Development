<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	#header {
	margin-bottom: 100px;
	}
</style>
	<ct:Libs>
</ct:Libs>

		<title>Login</title>
	</head>
<div id="header" >
    <jsp:include page="header-menu.jsp"/>
</div>
<body>

<div class="container col-md-4">
<h3>Sign Up</h3>
	<div class="">
	
	<form:form method="POST" action="/socialnetwork/register" modelAttibute="user">
					<div class="row">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <label class="control-label" for="user-name">Username</label>
                        <!-- Add username field to the login form -->
                        <input id="user-name" name="username" type="text" class="form-control"/>
                    </div>
                </div>
 
                <div class="row">
                    <div id="form-group-password" class="form-group col-lg-4">
                        <label class="control-label" for="user-password">Password</label>
                        <input id="user-password" name="password" type="password" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div id="form-group-email" class="form-group col-lg-4">
                        <label class="control-label" for="email">Email</label>
                             <input id="email" name="email" type="email" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div id="form-group-full-name" class="form-group col-lg-4">
                        <label class="control-label" for="full-name">Full Name</label>
                             <input id="full-name" name="fullName" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <!-- Add submit button -->
                        <button type="submit" class="btn btn-success">Register</button>
                    </div>
                </div>
		
		</form:form>
	</div>
</div>
</body>
</html>