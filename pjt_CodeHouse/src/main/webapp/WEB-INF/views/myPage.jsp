
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
html {
	height: 100%;
	overflow: hidden;
}

body {
	margin: 0;
	padding: 0;
	perspective: 1px;
	transform-style: preserve-3d;
	height: 100%;
	overflow-x: hidden;
	overflow-y: auto;
	font-family: "Luna";
	background: #454c55;
}

.mypage-main {
	background: white;
	padding: 30px;
	border-radius: 5px;
}

.hide {
	display: none;
}
</style>

</head>

<body>
	<jsp:include page="/common/topnav"></jsp:include>

		<c:choose>
			<c:when test="empty ${param.view}"><c:set var="view" value="article"/></c:when>
			<c:when test="${null eq param.view}"><c:set var="view" value="article"/></c:when>
			<c:otherwise><c:set var="view" value="${param.view}"/>			
			</c:otherwise>
		</c:choose>
		
		

	<div class="container" style="margin-top: 100px;">
		<div class="row">
			<div class="col-lg">
				<div class="mypage-main">
					<h3 >내정보</h3>
					<div class="form-group">
						<img id="userImage" src="${member.mem_img}" class="rounded"
							style="width: 150px;" />
					</div>
					<div class="btn btn-primary">정보 수정</div>

					<div class="form-group">
						<label for="inputId">아이디</label> <input type="text"
							class="form-control" value="${member.mem_id}" readonly />
					</div>


					<div class="form-group">
						<label for="inputNickName">닉네임</label> <input type="text"
							class="form-control" value="${member.mem_nickname}" readonly />
					</div>
					<div class="form-group">
						<label for="inputEmail">이메일</label> <input type="text"
							class="form-control" value="${model.mem_email}" readonly />
					</div>

					<input style="visibility: hidden;" type="file" accept="image/*"
						multiple="false" class="form-control" id="inputImage">

				</div>
			</div>
		</div>



		<div class="row">

			<div class="col-lg">
				<div id="viewController" class="btn-group" role="group"
					style="width: 100%; background: white;">
					<button type="button" id="btnArticle" data-launch-view="article"
						class="btn btn-outline-dark <c:if test="${view eq 'article'}">active</c:if>" style="width: 100%;">내가
						쓴글</button>
					<button type="button" id="btnComment" data-launch-view="comment"
						class="btn btn-outline-dark <c:if test="${view eq 'comment'}">active</c:if>" style="width: 100%;">내 댓글</button>
				</div>
			</div>
		</div>


		
		
		<div class="row">
			<div class="col">
				<!-- 게시글 목록  -->
				
				<div class="view <c:if test="${view ne 'article'}">hide</c:if>" id="article" >
					<table id="board"
						class="table table-hover bg-light align-middle table-bordered">
						<thead>
							<tr>
								<th class="bg-primary" scope="col" style="width: 10%;">번호</th>
								<th class="bg-primary" scope="col" style="width: 50%;">제목</th>
								<th class="bg-primary" scope="col" style="width: 30%;">작성일</th>
								<th class="bg-primary" scope="col" style="width: 10%;">작성자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${boardVO.articles}" var="article">
								<tr>
									<th scope="row">${article.art_no}</th>
									<td>${article.art_title}</td>
									<td>${article.art_create_time}</td>
									<td>${article.mem_id}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="col">
							<div class="container d-flex justify-content-center">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<c:choose>
											<c:when test="${boardVO.curPage ne 1 }">
												<li class="page-item"><a class="page-link"
													onclick="onClickBoardPaging(${boardVO.curPage-1})"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item disabled"><a class="page-link"
													aria-label="Previous" aria-disabled="true"> <span
														aria-hidden="true">&laquo;</span>
												</a></li>
											</c:otherwise>
										</c:choose>

										<c:forEach var="pageNum" begin="${boardVO.startPage}"
											end="${boardVO.endPage}">
											<c:choose>
												<c:when test="${pageNum eq  boardVO.curPage}">
													<li class="page-item active"><a class="page-link"
														onclick="onClickBoardPaging(${pageNum})">${pageNum}</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														onclick="onClickBoardPaging(${pageNum})">${pageNum}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:choose>
											<c:when
												test="${boardVO.curPage ne boardVO.pageCnt && boardVO.pageCnt > 0}">
												<li class="page-item"><a class="page-link"
													onclick="onClickBoardPaging(${boardVO.curPage+1})"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item disabled"><a class="page-link"
													aria-label="Next" aria-disabled="true"> <span
														aria-hidden="true">&raquo;</span>
												</a></li>
											</c:otherwise>
										</c:choose>

									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
				<div class="view <c:if test="${view ne 'comment'}">hide</c:if>" id="comment">
					<table id="comment"
						class="table table-hover bg-light align-middle table-bordered">
						<thead>
							<tr>
								<th class="bg-primary" scope="col" style="width: 10%;">번호</th>
								<th class="bg-primary" scope="col" style="width: 50%;">제목</th>
								<th class="bg-primary" scope="col" style="width: 30%;">작성일</th>
								<th class="bg-primary" scope="col" style="width: 10%;">작성자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${commentsVO.comments}" var="comment">
								<tr>
									<th scope="row">${comment.art_no}</th>
									<td>${comment.cmt_title}</td>
									<td>${comment.cmt_create_time}</td>
									<td>${comment.mem_id}</td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
					<div class="row">
						<div class="col">
							<div class="container d-flex justify-content-center">
								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<c:choose>
											<c:when test="${commentsVO.curPage ne 1 }">
												<li class="page-item"><a class="page-link"
													onclick="onClickCommentPaging(${commentsVO.curPage-1})"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item disabled"><a class="page-link"
													aria-label="Previous" aria-disabled="true"> <span
														aria-hidden="true">&laquo;</span>
												</a></li>
											</c:otherwise>
										</c:choose>

										<c:forEach var="pageNum" begin="${commentsVO.startPage}"
											end="${commentsVO.endPage}">
											<c:choose>
												<c:when test="${pageNum eq  commentsVO.curPage}">
													<li class="page-item active"><a class="page-link"
														onclick="onClickCommentPaging(${pageNum})">${pageNum}</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														onclick="onClickCommentPaging(${pageNum})">${pageNum}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<c:choose>
											<c:when
												test="${commentsVO.curPage ne commentsVO.pageCnt && commentsVO.pageCnt > 0}">
												<li class="page-item"><a class="page-link"
													onclick="onClickCommentPaging(${commentsVO.curPage+1})"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item disabled"><a class="page-link"
													aria-label="Next" aria-disabled="true"> <span
														aria-hidden="true">&raquo;</span>
												</a></li>
											</c:otherwise>
										</c:choose>

									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
    var params; 
        //이미지 업로드 AJAX
        // 이미지 업로드가 session["mem_id"]에 종속됨 없으면 업로드 불가
        function sendFile(file) {

            var formData = new FormData();
            formData.append('file', $('#inputImage')[0].files[0]);
            $.ajax({
                type: 'post',
                url: 'memImageUploader.ashx',
                data: formData,
                success: function(status) {
                    if (status != 'error') {
                        var my_path = status;
                        $("#userImage").attr("src", my_path);
                    }
                },
                processData: false,
                contentType: false,
                error: function() {
                    alert("Whoops something went wrong!");
                }
            });
        }

        $(document).ready(function() {
            $("#userImage").on("click", function() {
                document.getElementById('inputImage').click();
            });
        });

        $(document).ready(function(e) {
            function showView(viewName) {
                $('.view').hide();
                $('#' + viewName).show();
            }
            

            $('[data-launch-view]').click(function(e) {
                e.preventDefault();
                var viewName = $(this).attr('data-launch-view');
                changeCategoryClass(this);

                showView(viewName);
            });
            
            
                     
            
            
            


        });

        


        // 버튼 클릭에 따라 prameter의 값을 바꿈
        // class Name도 바꿈
        function changeCategoryClass(el) {
            var category = document.getElementById('viewController'),
                children = category.children,
                i;

            for (i = 0; i < children.length; i++) {
                children[i].className = 'btn btn-outline-dark';
            }

            if (el) {
                el.className = 'btn btn-outline-dark active';
                if(el.id == "btnComment"){
                    params.setView("comment");
                }else{
                    params.setView("article");
                }
            }

        }
       

		
        // get parameter 세팅을 위한 코드
        
        var getParameter = function(param) {
			var returnValue;
			var url = location.href;
			var parameters = (url.slice(url.indexOf('?') + 1,
					url.length)).split('&');
			for (var i = 0; i < parameters.length; i++) {
				var varName = parameters[i].split('=')[0];
				if (varName.toUpperCase() == param.toUpperCase()) {
					returnValue = parameters[i].split('=')[1];
					return decodeURIComponent(returnValue);
				}
			}
		};
		
	
		
		
		class Params{
            constructor(artpage, cmtpage, view) {
                this.artpage = artpage;
                this.cmtpage = cmtpage;
                this.view = view;                
            }
            setArtpage(artpage){
                this.artpage = artpage;
            }
            setCmtpage(cmtpage){
                this.cmtpage = cmtpage;
            }
            setView(view){
                this.view = view;
            }
            
        }
		var setParameters = function(){
            var url = location.href;
            
            var returnValue;
            if(url.indexOf('?') != -1){
                returnValue = (url.slice(0, url.indexOf('?')+1));
            }else{
                returnValue = url+"?";
            }
            
            
            if(params.artpage!=null){
                returnValue += "artpage="+params.artpage+"&";
            }else{
                returnValue += "artpage="+1+"&"
            }
            if(params.cmtpage!=null){
                returnValue += "cmtpage="+params.cmtpage+"&";
            }else{
                returnValue += "cmtpage="+1+"&"
            }
            if(params.view!=null){
                returnValue += "view="+params.view+"&";
            }else{
                returnValue += "view=article&"
            }

            if(returnValue[returnValue.length-1] == "&"){
                returnValue = returnValue.slice(0,returnValue.length-1)
            }
            return returnValue;
		}
        $(document).ready(function() {
            params = new Params(getParameter("artpage"),getParameter("cmtpage"),getParameter("view"));
        });
		
		
		
		$("#board tr").click(function(){     
			 
		    var str = ""
		    var tdArr = new Array();    // 배열 선언
		        
		    // 현재 클릭된 Row(<tr>)
		    var tr = $(this);
		    var td = tr.children();
			
		    var no = td.eq(0).text();
		    

			window.location.href = './article?article='+no;
        });
        $("#comment tr").click(function(){     
			 
             var str = ""
             var tdArr = new Array();    // 배열 선언
                 
             // 현재 클릭된 Row(<tr>)
             var tr = $(this);
             var td = tr.children();
             
             var no = td.eq(0).text();
             
 
             window.location.href = './article?comment='+no;
         });

         //pagination nav 처리

        var onClickBoardPaging = function(no){
            params.setArtpage(no);
            window.location.href = setParameters();
        }
        var onClickCommentPaging = function(no){
            params.setCmtpage(no);
            window.location.href = setParameters();
        }
        

	
		
		</script>

</body>

</html>