<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>
<h4>Comments</h4>
		<form:form method="POST" action="/socialnetwork/profile/${authorId}/posts/${postId}" modelAttribute="comment">
		<input type="text" name="content"/>
		<button type="submit" class="btn btn-warning">Add Comment</button>
		</form:form>
	<c:forEach items="${comments}" var="comment">

      <div class="panel-body">
       <div class="container">
    <div class="nav nav-tabs contests-nav col-md-5">
    
    	
    	<div>
    		<p>
    			<c:out value="${comment.content}" />
    		</p>
    	</div>
        <div>
        	<storng>
        		<span class="glyphicon glyphicon-user"></span><c:out value="${comment.authorName}" /> : commend on :
        		<c:out value="${comment.createdOn}" />
        	</storng>
        </div>
        
    </div>
</div>
	</div>
       
   
  </c:forEach>
  
