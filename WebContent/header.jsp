<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link href="${contextPath}/css/shopping.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/member/member.js"></script>
<script type="text/javascript" src="${contextPath}/mypage/mypage.js"></script>
</head>

<body>
	<div id="wrap">
		<!--헤더파일 들어가는 곳 시작 -->
		<header>
			<!--로고 들어가는 곳 시작--->
			<div id="logo">
				<a href="NonageServlet?command=index"> <img
					src="${contextPath}/images/logo.gif" width="180" height="100" alt="nonageshop">
				</a>
			</div>
			<!--로고 들어가는 곳 끝-->
			<nav id="catagory_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.loginUser}">
							<li><a href="NonageServlet?command=login_form"
								style="width: 110px;">LOGIN(CUSTOMER</a> <a
								href="NonageServlet?command=admin_login_form"
								style="width: 100px;">| ADMIN)</a></li>
							<li>/</li>
							<li><a href="NonageServlet?command=contract">JOIN</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: orange">
								${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</li>
							<li><a href="NonageServlet?command=logout">LOGOUT</a></li>
						</c:otherwise>
					</c:choose>
					<li>/</li>
					<li><a href="NonageServlet?command=cart_list">CART</a></li>
					<li>/</li>
					<li><a href="NonageServlet?command=mypage">MY PAGE</a></li>
					<li>/</li>
					<li><a href="${contextPath}/qnas/list">Q&amp;A(1:1)</a>
					</li>
				</ul>
			</nav>

			<nav id="top_menu">
				<ul>
					<li><a href="items?kind=1">Heels</a>
					</li>
					<li><a href="items?kind=2">Boots</a>
					</li>
					<li><a href="items?kind=3">Sandals</a>
					</li>
					<li><a href="items?kind=4">Sneakers</a>
					</li>
					<li><a href="items?kind=5">On
							Sale</a></li>
				</ul>
			</nav>
			<div class="clear"></div>
			<hr>
		</header>
		<!--헤더파일 들어가는 곳 끝 -->