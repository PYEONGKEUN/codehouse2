<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>codehouse</title>
    <!--bootstrap-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
    <!--summernote-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
    
    <style>
html{
    height: 100%;
    overflow: hidden;
}


body{
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
article{
    box-sizing: border-box;
    min-height: 100vh;
    padding: 30vw 0 5vw;
    position: relative;
    transform-style: inherit;
    width: 100vw;
    color: white;


}
article h1{
    margin-top: -100px;
    font-size: 60px;
}
article, article:before{
    background: 50% 50% /cvoer;
}

article::before{
    bottom 0;
    content: "";
    left: 0;
    position: absolute;
    right: 0;
    top: 0;
    display: block;
    background-image: url(./resources/imgs/3394.jpg);
    background-size: cover;
    transform-origin: center center 0;
    transform: translateZ(-1px) scale(2);
    z-index: -1;
    min-height: 100vh;

}
article *{

    font-weight: normal;
    letter-spacing: center;
    text-align: center;
    margin: 0;
    padding: 1em 0;
}
p{
font-size: 30px;
}

    </style>

</head>
<body>
<jsp:include page="/common/topnav"></jsp:include>

 <div class="container" style="text-align: center; display: inline-block;">

	
	<article style="text-align: center; ">
    	<h1>소스코드를 공유하세요</h1>
    	<p> 다른 사람의 코드와 당신의 코드를 비교하세요.</p>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	
    </article>
    

 

</div>



</body>
</html>
