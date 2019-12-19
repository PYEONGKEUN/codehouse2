<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>codeshare</title>
<!--bootstrap-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<!--summernote-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>



<style>
body {
	background: #454c55;
}
</style>

</head>

<body>
	<jsp:include page="/common/topnav"></jsp:include>
	<div class="container" style="margin-top: 100px;">

		<div class="row">
			<div class="col">
				<table
					class="table table-hover bg-light align-middle table-bordered">
					<thead>
						<tr>
							<th class="bg-primary" scope="col">#</th>
							<th class="bg-primary" scope="col">First</th>
							<th class="bg-primary" scope="col">Last</th>
							<th class="bg-primary" scope="col">Handle</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${articles}" var="article">
							<tr>
								<th scope="row">article.getArt_no</th>
								<td>article.getArt_title</td>
								<td>article.getArt_create_time</td>
								<td>article.getMem_id</td>
							</tr>

						</c:forEach>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>

        <div class="row">
            <div class="col">
                <table class="table table-hover bg-light align-middle table-bordered">
                    <thead>
                        <tr>
                            <th class="bg-primary" scope="col">#</th>
                            <th class="bg-primary" scope="col">First</th>
                            <th class="bg-primary" scope="col">Last</th>
                            <th class="bg-primary" scope="col">Handle</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach items="${articles}" var="article">
	                    	<tr>
	                            <th scope="row">${article.getArt_no}</th>
	                            <td>${article.getArt_title}</td>
	                            <td>${article.getArt_create_time}</td>
	                            <td>${article.getMem_id}</td>
	                        </tr>
                    	
                    	</c:forEach>               

                       
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row" >
            <div class="col">               
                <div class="container d-flex justify-content-center">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

	</div>



</body>

</html>
