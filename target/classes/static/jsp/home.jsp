<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="jquery-3.3.1.min.js"></script>
<script src="../js/index.js"></script>
<link rel="stylesheet" href="../css/home.css">
<meta charset="utf-8">
<title>HOME</title>
</head>
<body>
<div class="header">
<div class="header_middle">
<ul>
<input class="searchbox" placeholder="请输入关键字"/><i class="searchicon">GO</i>
<li>学术网</li>
<li><a href=" logout">注销</a></li>
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
<div class="introdution">
<img alt="teacher"  src="../image/header.jpg">
</div>
<div class="lesson">
<ul class="lesson_list">

</ul>
</div>
</div>
</div>
<div class="Tanform">
<h2>创建课程</h2>
<div style="border-bottom:2px dotted grey;margin-top:15px;"></div>
<form action="createLesson" method="post">
<h3>&nbsp;&nbsp;&nbsp;LessonName:</h3>
&nbsp;&nbsp;<input type="text" class="lessonname"  name="lessonName"><br>
<h3>&nbsp;&nbsp;&nbsp;Department:</h3>
&nbsp;&nbsp;<select class="department" name="department">
</select>
<h3>&nbsp;&nbsp;&nbsp;Major:</h3>
&nbsp;&nbsp;<select class="Major" name="major">
</select>
<h3>&nbsp;&nbsp;&nbsp;LessonIntrodution:</h3>
&nbsp;&nbsp;<input type="text" class="lessonIntrodution" name="lessonIntrodution"><br><br>
<input type="submit" value="create" class="btn1" diabled />
<input type="reset" value="reset" class="btn2">
<span class="bb"></span>
 </form>
</div>
<div id="overDiv" style="display:none;"></div>
<div class="searchPage" style="display:none"></div>
</body>
<script>
$(".btn2").click(function(){
	$(".Tanform").css("display","none");
	$("#overDiv").css("display","none");
});
function register(){
document.getElementById("overDiv").style.display = "block" ;
document.getElementsByClassName("Tanform")[0].style.display = "block" ;}

var data={"department":["农学院","软件工程学院","外国语学院","管理学院"],
		  "Major":{
			   "软件工程学院":["软件工程","高等数学","编译原理","数据库原理"],
			   "农学院":["养殖","农业技术","植物保护","农业发展"],
			   "外国语学院":["专业英语","高等数学","体育","大学物理"],
			   "管理学院":["财务管理","财务金融"]
		  }		
		};
		var opt="<option>请选择</option>";
		   for(var i in data["department"]){
			   opt+= "<option>"+data["department"][i]+"</option>";
		   }
	     $(".department").append(opt);
	     $(".department").change(function(){
	    	 $(".Major").empty();
	         var city2=$(".department").children("option:selected").text();
	          var cityopt="";
	          for(var j in data["Major"][city2]){
	        	  cityopt+="<option>"+data["Major"][city2][j]+"</option>";
	          }
	          $(".Major").append(cityopt);  
	         
	     })
	$(".btn1").mouseenter(function(){
	var  a=$(".lessonname").val().length;
	var b=$(".lessonIntrodution").val().length;
	var c=$(".department option:selected").val();
	if(a==0||b==0||c=="请选择"){
	  $(".btn1").prop("disabled",true);
	}else{
		  $(".btn1").prop("disabled",false);	
	}
	});

</script>
</html>