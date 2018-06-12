<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html class="no-js">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<!-- jQuery -->
	<script src="./include/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="./include/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="./include/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="./include/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="./include/js/main.js"></script>
	

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>
<script src="./include/js/login.js"></script>
<link rel="stylesheet" href="./include/css/bootstrap.min.css">
<link rel="stylesheet" href="./include/css/animate.css">
<link rel="stylesheet" href="./include/css/style.css">
<link rel="shortcut icon" href="./include/img/AcFun.png">

<!-- Modernizr JS -->
<script src="./include/js/modernizr-2.6.2.min.js"></script>

</head>
<body class="style-2">

	<div style="top:0;float:right;">
		  <a href="#" style="margin‐right:15px;">登录</a>    
		  <a href="news.jsp">新闻</a> 
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<ul class="menu">
					<li>&nbsp;</li>
					<li class="active">&nbsp;</li>
					<li>&nbsp;</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<form id="login-form" class="fh5co-form animate-box"
					data-animate-effect="fadeInLeft" onsubmit="return false">
					<h2>登录</h2>
					<div class="form-group">
						<label for="username" class="sr-only">Username</label> <input
							type="text" class="form-control" id="uid" placeholder="用户名"
							autocomplete="off" name="uid">
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">Password</label> <input
							type="password" class="form-control" id="pwd"
							placeholder="密码" autocomplete="off" name="pwd">
					</div>
					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember">
							记住我</label>
					</div>
					<div class="form-group">
						<p>
							没有注册? <a href="#">注册</a> | <a href="#">忘记密码?</a>
						</p>
					</div>
					<div class="form-group">

						<input type="submit" id="login-submit" value="&nbsp;登&nbsp;&nbsp;录&nbsp;"
							class="btn btn-primary">
					</div>
				</form>

			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;"></div>
	</div>



</body>
</html>


