<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>codeshare</title>
    <!--bootstrap-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <!--summernote-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>

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
				<table id="board" class="table table-hover bg-light align-middle table-bordered">
					<thead>
						<tr>
							<th class="bg-primary" scope="col" style="width:10%;">번호</th>
							<th class="bg-primary" scope="col" style="width:50%;">제목</th>
							<th class="bg-primary" scope="col" style="width:30%;">작성일</th>
							<th class="bg-primary" scope="col" style="width:10%;">작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardVO.articles}" var="article">
							<tr >
								<th scope="row">${article.art_no}</th>
								<td>${article.art_title}</td>
								<td>${article.art_create_time}</td>
								<td>${article.mem_id}</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="container d-flex justify-content-center">
					<nav aria-label="Page navigation">
						<ul class="pagination">

							<c:choose>
								<c:when test="${boardVO.curPage ne 1 }">
									<li class="page-item">
										<a class="page-link" href="./board?page=${boardVO.curPage-1}"	aria-label="Previous">
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item disabled" >
										<a class="page-link" aria-label="Previous" aria-disabled="true"> 
											<span aria-hidden="true">&laquo;</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>

							<c:forEach var="pageNum" begin="${boardVO.startPage}" end="${boardVO.endPage}">
								<c:choose>
									<c:when test="${pageNum eq  boardVO.curPage}">
										<li class="page-item active">
											<a class="page-link" href="./board?page=${pageNum}">${pageNum}</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="./board?page=${pageNum}">${pageNum}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:choose>
								<c:when	test="${boardVO.curPage ne boardVO.pageCnt && boardVO.pageCnt > 0}">
									<li class="page-item">
										<a class="page-link" href="./board?page=${boardVO.curPage+1}" aria-label="Next">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item disabled">
										<a class="page-link" aria-label="Next" aria-disabled="true">
											<span aria-hidden="true">&raquo;</span>
										</a>
									</li>
								</c:otherwise>
							</c:choose>
							
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
//테이블의 행을 클릭하면 article로 연결
$("#board tr").click(function(){     
	 
    var str = ""
    var tdArr = new Array();    // 배열 선언
        
    // 현재 클릭된 Row(<tr>)
    var tr = $(this);
    var td = tr.children();
	
    var no = td.eq(0).text();
    

	window.location.href = './article?article='+no;
});
</script>

</html>
