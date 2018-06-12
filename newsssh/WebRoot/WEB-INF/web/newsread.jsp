<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>newsread.html</title>
<meta name="content-type" content="text/html; charset=UTF-8">
<script src="<%=basePath%>include/js/jquery.min.js"></script>
<script src="<%=basePath%>include/js/jquery.easyui.min.js"></script>
<script src="<%=basePath%>include/js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="<%=basePath%>include/css/themes/default/easyui.css">
<link rel="stylesheet" href="<%=basePath%>include/css/themes/icon.css">
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

</head>
<style> 
	div{text-align:center} 
</style>
<body>
		<div
			style="float:right;line‐height:50px;margin‐right:10 px;font‐size: 9pt;">
			<span> 【 </span><a style="color:blue;"
				href="javascript:window.opener=null;window.open('',
'_self');window.close();"><span>
					关闭窗口 </span></a><span>】</span>
		</div>
	</div>
	<div class="ndetail">
		<div class="ntitle">${news.title}</div>
		<div class="nauthor">
			<div>
				来源: &nbsp;<strong>${news.cruser}</strong> &nbsp;&nbsp; 发布时间:&nbsp; <strong>  ${news.tjdate } </str
ong>&nbsp;&nbsp;
					访问量:&nbsp; <strong>[<span>${news.hitnum}</span>]
				</strong>
			</div>
		</div>
		<div class="nbody">
			<div id="vsb_content">${news.content}</div>
		</div>
	</div>
</body>
</html>

