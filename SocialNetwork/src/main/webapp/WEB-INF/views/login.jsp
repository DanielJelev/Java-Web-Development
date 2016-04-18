<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<ct:Libs>
</ct:Libs>
<style>
	#header {
	margin-bottom: 100px;
	}
</style>
		<title>Login</title>
	</head>
<div id="header" >
    <jsp:include page="header-menu.jsp"/>
</div>
	<body>
		<div class="container col-md-4">
		<div class="panel-body">
     
<h3>Login</h3>
	
	
	<form:form method="POST" action="/socialnetwork/login" modelAttibute="user">
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
                    <div class="form-group col-lg-4">
                        <!-- Add submit button -->
                        <button type="submit" class="btn btn-success">Login</button>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </div>
                </div>
		
	</form:form>
	</div>
</div>
	</body>
	
</html>