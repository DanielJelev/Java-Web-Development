<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" uri="http://bg.softuni.socialnetwork/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
	<head>
	<style>
	#header {
	margin-bottom: 100px;
	}
</style>
	<ct:Libs>
</ct:Libs>
		<title>Wall</title>
	</head>
<div id="header" >
    <jsp:include page="header-main-menu.jsp"/>
</div>
	<body>
	<h1>Profile</h1>

			
			<div class="panel-body">
			
       <div class="container">
    <div class="nav nav-tabs contests-nav row">	
        <div>
        <div class="container">
   		 <img alt="" src="${user.picture}" width='150px'>
		  </div>
        	<storng>
        	<h4>Full Name: <span class="label label-success"> ${user.fullName}</span> </h4>
        	<h4>Username: <span class="label label-warning"> ${user.username}</span> </h4>
        	<h4>Email: <span class="label label-info"> ${user.email}</span> </h4>
        	</storng>
        </div>
    </div>
        </div>
</div>
	<h3>Start new Post</h3>
	
<div class="panel-body">
       <div class="container">
   		 <div class="nav nav-tabs contests-nav row">
		<form:form method="POST" action="/socialnetwork/profile/${user.id}" modelAttibute="post">

			<textarea rows="3" cols="70" name="content"></textarea>
		
			<input type=submit id="btn1" class="btn btn-success btn pull-top" name="Submit"/>
		</form:form>
		  </div>
  </div>
  </div>
  
	<div id="show-posts">
	</div>

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close clear-on-close" data-dismiss="modal"></button>
                <h4 class="modal-title">Are you sure you want to delete this post?</h4>
            </div>
          
            <div class="modal-footer">
                <button type="button" class="btn btn-default clear-on-close" data-dismiss="modal">Close</button>
                <button type="button" id="delete-button" data-dismiss="modal" class="btn btn-md btn-danger">Delete
                </button>
            </div>
        </div>
    </div>
</div>
<script>
(function(){
	$("#delete-button").on("click",function(){
		var id =$("#delete-post-btn").val();
		$.ajax({
			url : "/socialnetwork/profile/"+id+"/",
			methor : "post",
			data : {}
		})
	});
	
	$.ajax({
		url :"${userId}/posts/",
		method:"get",
		success : function(success){
			$("#show-posts").html(success);
		}
		
	}).then(function(){
		$(".btn-info").each(function(button){
			$(this).on("click",function(){
				var id = $(this).val();
				console.log($("#get-comments-"+id))
				$.ajax({
					url : "${user.id}/posts/"+id,
					method :"get",
					success :function(success){
						$("#comments-container-"+id).html(success)
					}
					
				})
				 $(this).hide()
			})
		})
	})
}())
</script>
		
	</body>
</html>