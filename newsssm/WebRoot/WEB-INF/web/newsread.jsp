<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>新闻阅读</title>
<link rel="shortcut icon" href="<%=basePath%>include/img/title.png" />
<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<script>var base = "<%=basePath%>";</script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/themes/icon.css">
<script type="text/javascript"
	src="<%=basePath%>include/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>include/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>include/js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/default.min.css" />
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>include/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>include/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=basePath%>include/ueditor/lang/zh-cn/zh-cn.js"></script>

</head>

<body>
	<div
		style="background:#B3DFDA;padding:0 10px 0 10px;vertical‐align: middle;">
		<img src="<%=basePath%>include/img/title.png" width="126" height="50" />
		<div
			style="float:right;line‐height:50px;margin‐right:10px;font‐size: 9pt;">
			   <span> </span><a style="color:#ff0080;"
				href="javascript:window.close();"><span> 关闭窗口 </span></a><span></span>
		</div>
	</div>

	<div id="contentDiv">
		<div id="content">
			<div class="rotLeft rotTop pageBack"></div>
			<div class="rotRight rotTop pageBack"></div>
			<div class="container page">
				<h2 class="subtitle">
					作者：&nbsp;<strong>${news.cruser}</strong> &nbsp;&nbsp;
				</h2>
				<div class="pageTitle center">${news.title}</div>
				<p>
					<span style="color:orange;font-weight:bold;"> 发布时间:&nbsp;  
						<strong><fmt:formatDate value="${news.tjdate}"
								pattern="yyyy-MM-dd" /></strong>&nbsp;&nbsp; 访问量 :&nbsp; <strong>[<span>${news.hitnum}</span>]
					</strong>
					</span>
				</p>
				<div class="nbody">
					<div id="vsb_content">
						<p>${news.content}</p>
					</div>
					<div class="nlist">
						<table id="newstable" width="100%">
							<tbody>
								<tr id="trpp">
									<td colspan="3" align="left"></td>
								</tr>
							</tbody>
						</table>
						<div id="pp" style="background:#efefef;"></div>
						<div class="easyui-panel" title="新闻添加" style="width:90%">
							<div style="padding:10px 60px 20px 60px;width:90%">
								<table cellpadding="5" style="width:90%">
									<tr>
										<td style="vertical‐align: top;">新闻内容：</td>
										
									</tr>
									<tr><script id="content" type="text/plain"
												style="width:90%;height:400px;"></script></tr>
								</table>
								<div>
									<div style="text-align:center;padding:5px">
										<a id="savenews" href="javascript:void(0)"
											class="easyui-linkbutton" style="width:120px">保存</a>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

			<div class="rotLeft rotBottom pageBack"></div>
			<div class="rotRight rotBottom pageBack"></div>
		</div>
	</div>
	<div id="footerDiv">
		<div id="footerImg"></div>
		<div id="footerCnt">
			<div id="footer"></div>
		</div>
	</div>
</body>
<script>
var bver,role="5";
var base="./"; 
var pageN=1,pageTotal=100;
var ue; 
$(function(){
ue = UE.getEditor('content');    
$.ajax({
	url:"<%=basePath%>comment/getCount",
	data:{"id":${news.id}},
	type:"post",
	success: function(res){
	pageTotal=res.newscount;
	listNews(1,10);loadPager();
	},
	error:function(res){
	$.messager.alert("系统提示","系统错误","error");
	}
	});
	$("#savenews").click(function(){   
      var a=$('#cruser').val();
      var b=ue.getContent();
      if(a==""){alert("请输入昵称");return;      }
      //var re=/^\d{4}$|^\d{8}$/;
      //if(!re.test(a)){alert("学号格式错误");return;     }
      if(b==""||b==undefined){alert("请输入内容");return;}
      $.ajax({
            url : "<%=basePath%>comment/addComment",
      //只封装和传输指定的数据
            data :{"id":${news.id},"cruser":a,"content":b},
            type:"POST",
            success : function (res) {
                  if (res.ok) {
                       parent.$.messager.alert("系统提示", "评论成功,请刷新本页面", "info");
                  }else {alert(res.msg);             }
                  return false;
            },
            error : function(res) {alert("系统错误！");      }
      });
});

});
	function listNews(pageNumber,pageSize){
	$.ajax({
	url:"<%=basePath%>comment/listComment",
	data:{"id":${news.id},"page":pageNumber,"rows":pageSize},
					type : "post",
					success : function(res) {
						$(".inews").remove();
						//res=JSON.parse(res);
						if (res.total <= 0) {
							var tr = "<tr class='inews' height=\"25\"><td >";
							tr += "<div class='t'>暂无相关评论</div>";
							tr += "</td><td width='1%' nowrap=''><span >&nbsp;</span></td></tr>";
							$("#trpp").before(tr);
						} else {
							pageN=pageNumber;
							pageTotal = res.total;
							var rows = res.rows;
							for (var i = 0; i < rows.length;) {
							if (i % 1 == 0) {
									tr = "<tr class='inews' height='1'><td colspan='2' align='center'>";
									tr += "<hr style='border-style:dashed;border-color:#999999;width:99%;height:1px;border-width:1px 0px 0px0px;visibility:inherit'></td></tr>";
									$("#trpp").before(tr);
								}
								var row = rows[i];
								var tr = "<tr class='inews' height=\"25\"><td >";
								tr += "</td><td width='1%' nowrap=''><span >"
										+ row.tjdate
										+ "&nbsp;</span></td></tr>";
								tr += "</td><td width='1%' nowrap='' class='inews'><span >"
										+ row.content
										+ "&nbsp;</span></td></tr>";
								$("#trpp").before(tr);
								i++;
								
							}
						}
					},
					error : function(res) {
						parent.dlg_ok(300, 140, "系统提示", "系统错误", null, "error");
					}
				})
	}
	
	function loadPager(){
	$('#pp').pagination({
	 total:pageTotal,
	 pageSize:10,
	 pageNumber:pageN,
	 displayMsg:'{from}/{to} 共{total}条',
	 onSelectPage:function(pageNumber, pageSize){
	 listNews(pageNumber,pageSize);
	 }
	});
	}

</script>
</html>
