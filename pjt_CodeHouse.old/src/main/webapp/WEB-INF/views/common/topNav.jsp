<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
	
	<sec:authorize access="isAuthenticated()" var="isAuthenticated" />

  ${isAuthenticated}


	<sec:authorize access="!isAuthenticated()" var="isAuthenticated2" />

  ${isAuthenticated2}


  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
      <a class="navbar-brand" href="./">CodeHouse</a>
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
        <li class="nav-item active">
          <a class="nav-link" href="./">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./board">Board</a>
        </li>        
        <sec:authorize access="isAuthenticated()">
       		<li class="nav-item">
         			<a class="nav-link" href="./articleedit">Write</a>
       		</li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
       		<li class="nav-item">
         			<a class="nav-link" href="./login">Login</a>
       		</li> 
       		<li class="nav-item">
         			<a class="nav-link" href="./signup">SignUp</a>
       		</li>
		</sec:authorize>
        
        <sec:authorize access="isAuthenticated()">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	            MyMenu
	          </a>
	          <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	            <a class="dropdown-item" href="./logout.action">LogOut</a>
	            <a class="dropdown-item" href="./mypage">MyPage</a>
	          </div>
	        </li>
		</sec:authorize>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Board에서 찾습니다." aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>
