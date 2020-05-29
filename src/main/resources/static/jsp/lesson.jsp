<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="../css/home.css">
<meta charset="utf-8">
<title>HOME</title>
</head>
<body>
	<div class="header">
		<div class="header_middle">
			<ul>
				<li>学术网</li>
				<li>注销</li>
				<li>搜索</li>
				<li>个人信息</li>
				<li>动态</li>
				<li>修改信息</li>
				<a href="javascript:void(0)" onclick="register()"><li>创建课程</li></a>
				<li>未读信息</li>
			</ul>
		</div>
	</div>
	<div class="back">
		<div class="middle">
		<div class="left">
			<img src="../image/timg${lesson.imageurl}.jpg" class="LessImage"><br>
			<button class="EnterAdd">进入课程/Enter</button></div>
			<div class="right">
				<h3>
					<p>${lesson.lessonName }</p>
					<p>Teacher:${lesson.teachername}</p>
					<p>Department:${lesson.department}</p>
					<p>Major:${lesson.major}</p>
				</h3>
			</div>
			<h2>LessonIntrodution:</h2>
		   <p class="intro">${lesson.lessonIntrodution}</p>
		</div>
		
	</div>

</body>
<script>
$(".EnterAdd").click(function(){
			window.location.href="/HomeWork/jsp/work.jsp";
	});
</script>
<style>
.back .middle {
	width: 800px;
	height: 880px;
	padding: 20px 40px;
	border-radius: 15px;
	position: relative;
	left: 50%;
	top: 40%;
	transform: translate(-50%, -50%);
	background-color:rgba(255,255,255,0.4);
}
.left{
float:left;
}
.LessImage {
	 height : 200px;
	width: 200px;
	background-size: cover;
	background-position: 50%;
	box-shadow: 0 0 0 5px #00a1d6;
	height: 200px;
}
.right {
	float: left;
	margin-left:80px;
	width: 480px;
	height: 400px;
	color: #999;
}
button{
height:50px;
width:160px;
background-color:#2caf6f;
color:#fff;
font-size:20px;
border: 1px solid #31c27c;
  margin-top:20px;
  margin-left:17px;
  border-radius:5px;
}
p {
	margin-top: 30px;
}

p:nth-child(1) {
	font-size: 20px;
	color: deeppink;
}
h2{
color: #999;
}
.intro{
color: #999;
text-indent:60px;
line-height:40px;
letter-spacing:7px;
font-size:20px;
}
</style>
</html>