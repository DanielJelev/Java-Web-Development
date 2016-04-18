<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>

			<h3>Posts</h3>
		<c:forEach items="${posts}" var="post">

      <div class="panel-body">
       <div class="container">
    <div class="nav nav-tabs contests-nav col-md-5">
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

               
	<div id="comments-container-${post.id}">
	</div>
        <div>
                		<button class="btn btn-info" id="get-comments" value="${post.id}"> Comments</button>
        		<button class="btn btn-danger" id="delete-post-btn" value="${post.id}" data-toggle="modal"
        data-target="#myModal"> Delete
</button>
        </div>
    </div>
</div>
	</div>
       
   
  </c:forEach>
  
	