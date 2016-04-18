<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>
<%@ page session="false" %>
<html>
<head>
</head>
<ct:Libs>
</ct:Libs>
	<title>Friends</title>
</head>
<body>
<div id="header">
    <jsp:include page="header-main-menu.jsp"/>
</div>

		<c:forEach items="${friends}" var="friend">
  
      			<div class="panel-body">
       <div class="container">
    <div class="nav nav-tabs contests-nav row">	
        <div>
   		 <img alt="" src="${friend.picture}" width='150px'>
        	<storng>
        	<h4>Full Name: <span class="label label-success"> ${friend.fullName}</span> </h4>
        	<h4>Username: <span class="label label-warning"> ${friend.username}</span> </h4>
        	<h4>Email: <span class="label label-info"> ${friend.email}</span> </h4>
        	<button class="btn btn-success"type="button" name="id" onclick="location='/socialnetwork/profile/${friend.id}'">View Profile</button>
        	<a href=></a>
        	</storng>
        </div>
    </div>
        </div>
</div>
      </c:forEach>
</body>
</html>
