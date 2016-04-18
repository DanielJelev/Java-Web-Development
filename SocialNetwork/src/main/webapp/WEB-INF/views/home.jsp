<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
	<ct:Libs>
</ct:Libs>

		<title>Wall</title>
	</head>
<div id="header" >
    <jsp:include page="header-main-menu.jsp"/>
</div>
	<body>
	<h1>News Feed</h1>

				<c:forEach items="${posts}" var="post">
  
      <div class="panel-body">
       <div class="container">
    <div class="nav nav-tabs contests-nav row">
    	<div>
    		<p>
    			<c:out value="${post.content}" />
    		</p>
    	</div>
    	
        <div>
        	<storng>
        		<span class="glyphicon glyphicon-user"></span><c:out value="${post.authorName}" /> : posted on :
        		<c:out value="${post.createdOn}" />
        	</storng>
        </div>
    </div></div>
</div>
			
		  </c:forEach>


	</body>
</html>