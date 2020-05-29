<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="comon.jsp"%>
<script src="jquery-3.3.1.min.js"></script>
<script src="../js/work.js"></script>
<link rel="stylesheet" href="../css/work.css">
</head>
<body>
	<div class="work" style="display:none">
		<br>
		<h2 style="margin-left: 85px; font-weight: normal">课程作业</h2>
		<div
			style="border-bottom: 2px dotted grey; width: 95%; margin: 0 auto"></div>
		<div class="workList">
			<ul class="big">
				<li>
					<ul class="small">
						<li>作业标题</li>
						<li>开始时间</li>
						<li>截止时间</li>
						<li>操作</li>
					</ul>
				</li>
			</ul>
			<button class="postwork">发布作业</button>
		</div>
	</div>

	<div class="studentwork" style="display: none">
		<br>
		<h2 style="margin-left: 85px; font-weight: normal">课程作业</h2>
		<div
			style="border-bottom: 2px dotted grey; width: 95%; margin: 0 auto"></div>
		<div class="studentworkList">
			<ul class="big3">
				<li>
					<ul class="small3">
						<li>作业标题</li>
						<li>截止时间</li>
						<li>提交时间</li>
						<li>状态</li>
						<li>操作</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>

	<div class="committt" style="display: none">
		<br>
		<h2 style="margin-left: 85px; font-weight: normal">作业详情</h2>
		<div
			style="border-bottom: 2px dotted grey; width: 95%; margin: 0 auto"></div>
		<div class="commitlist">
		<ul class="big2">
				<li>
					<ul class="small2">
						<li>序号</li>
						<li>姓名</li>
						<li>提交时间</li>
						<li>操作</li>
					</ul>
				</li>
				
			</ul>
			<button class="returnBtn">返回</button>
		</div>
	</div>
	<div class="postpercent" style="display:none">
	<h2 style="margin:10px 0 0 10px;">请打分</h2>
		<div style="border-bottom: 2px dotted grey; margin-top: 15px;"></div>
	<ul>
	<li style="background-color:#3498db">A</li>
	<li style="background-color:#2ecc71">B</li>
	<li style="background-color:#8e44ad">C</li>
	<li style="background-color:#c0392b">D</li>
	<li style="background-color:#f1c40f">E</li>
	</ul>
		<div style="border-bottom: 2px dotted grey; margin-top: 15px;"></div>
	<button class="close">关闭</button>
	<button class="postPercentTo">提交</button>
	</div>
	<div class="Workform">
		<h2>发布作业</h2>
		<div style="border-bottom: 2px dotted grey; margin-top: 15px;"></div>
		<form action="addWork" method="post">
			<h3>&nbsp;&nbsp;&nbsp;作业名称:</h3>
			&nbsp;&nbsp;<input type="text" class="workname" name="workname"><br>
			<h3>&nbsp;&nbsp;&nbsp;内容:</h3>
			&nbsp;&nbsp;
			<textarea class="inputarea" name="content">
</textarea>
			<h3>&nbsp;&nbsp;&nbsp;有效天数:</h3>
			&nbsp;&nbsp;<input class="time" name="time"
				onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
				onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}">
			<div style="border-bottom: 2px dotted grey; margin-top: 20px"></div>
			<input type="reset" value="close" class="btn2"
				style="margin-top: 20px" /> <input type="submit" value="发布"
				class="btn1" diabled style="margin-top: 20px" />
		</form>
	</div>
	<div id="overDiv"></div>
</body>
<script>
$(".postpercent>ul>li").click(function(){
   $(this).siblings().removeClass("active");		
	$(this).addClass("active");
	var $percent=$(this).text();
	console.log($percent);
});
</script>
<style>
.percent{
}
.commit {
	cursor: pointer;
	color: #00a1d6;
}
.percent,.rank{
cursor:pointer;
}
.big, .big2, .big3 {
	text-align: center;
}

.big>li, ,.big2>li, .big3>li {
	height: 40px;
	width: 90%;
}

.small>li, .small2>li, .small3>li {
	float: left;
	font-size: 17px;
	width: 25%;
	border-bottom: 2px dotted grey;
}
.small3>li {
	float: left;
	font-size: 17px;
	width: 20%;
	height:46px;
	border-bottom: 2px dotted grey;
}

* {
	list-style: none;
}

.work, .committt {
	height: 400px;
	width: 700px;
	background-color: white;
	position: absolute;
	left: 50%;
	top: 50%;
	border-radius: 6px;
	transform: translate(-50%, -50%);
}
.postpercent{
   height: 200px;
	width: 600px;
	background-color: white;
	position: absolute;
	left: 50%;
	top: 50%;
	border-radius: 6px;
	transform: translate(-50%, -50%);
}
.postpercent>ul{
width:60%;
height:30%;
margin:0 auto;
}
.postpercent>ul>li{
text-align:center;
line-height:45px;
float:left;
width:45px;
height:45px;
margin:10px;
border-radius: 5px;
color:#fff;
}
.postpercent>ul .active{
border:3px solid #eb3b5a;
}

.studentwork {
	height: 400px;
	width: 800px;
	background-color: white;
	position: absolute;
	left: 50%;
	top: 50%;
	border-radius: 6px;
	transform: translate(-50%, -50%);
}

.workList, .commitlist, .studentworkList {
	height: 74%;
	width: 88%;
	margin: 0 auto;
}

.postwork, .returnBtn {
	height: 40px;
	width: 80px;
	background-color: #00a1d6;
	border: 2px solid #00a1d6;
	border-radius: 10px;
	font-size: 16px;
	color: #fff;
	float: right;
	margin-right: 40px;
	margin-top: 10px;
}
.close{
height: 40px;
	width: 60px;
	background-color: #00a1d6;
	border: 2px solid #00a1d6;
	border-radius: 10px;
	font-size: 16px;
	color: #fff;
	float: right;
	margin-right: 10px;
	margin-top: 10px;
}
.postPercentTo{
	height: 40px;
	width: 60px;
	background-color: #00a1d6;
	border: 2px solid #00a1d6;
	border-radius: 10px;
	font-size: 16px;
	color: #fff;
	float: right;
	margin-right: 10px;
	margin-top: 10px;
}

</style>
</html>
