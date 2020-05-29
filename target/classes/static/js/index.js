$(function(){
$("body").delegate(".enterClass","click",function(){
	var id=$(this).parents("li").get(0).id;
	$.ajax({
		url : "Handlehref",
		data : {
			id : id
		},success:function(data){
			window.location.href="/HomeWork/jsp/lesson.jsp";
		}
	});
});
$("body").delegate(".addClass","click",function(){
	var id=$(this).parents("li").get(0).id;
	console.log(id);
	$.ajax({
		url : "addLesson",
		data:{
			lessonid:id
		},
		success : function(data) {
			window.location.href="/HomeWork/jsp/home.jsp";
		}
	}
	);
});
$(".searchicon").click(function(){
	if($(".searchbox").width()==0){
		$(".searchbox").css("width","300px");
	}else if($(".searchbox").val().length==0){
		$(".searchbox").css("width","0px");
	}else{
		var $searchMsg=$(".searchbox").val()
		$.ajax({
			url : "searchLesson",
			data : {
				searchMsg : $searchMsg
			},
			success : function(data) {
				$(".searchPage").css("display","block");
				$("#overDiv").css("display","block");
				for (var i = 0; i <data.length; i++) {
				var $Lesson=addLesson(data[i]);
				$Lesson.get(0).id=data[i].id;
				$(".searchPage").empty();
				$Lesson.appendTo($(".searchPage"));
				}
			}
		}
		);
	}
	$(".searchbox").val("");
	
});
function  createLesson(lesson){
		var $Lesson=$(" <li><div class=\"oneLesson\">\n" +
			"<img alt=\"text\" src=\"../image/timg"+lesson.imageurl+".jpg\"><p>" + lesson.lessonName + "</p><button class=\"enterClass\">进入课程</button></div>\n"+
			" </li>");
		return $Lesson;
	}
function  addLesson(lesson){
	var $Lesson=$(" <li><div class=\"oneLesson\">\n" +
		"<img alt=\"text\" src=\"../image/timg"+lesson.imageurl+".jpg\"><p>" + lesson.lessonName + "</p><button class=\"addClass\">添加课程</button></div>\n"+
		" </li>");
	return $Lesson;
}
$.ajax({
	url : "selectLesson",
	success : function(data) {
		for (var i = 0; i <data.length; i++) {
		var $Lesson=createLesson(data[i]);
		$Lesson.get(0).id=data[i].id;
		$Lesson.appendTo($(".lesson_list"));
		}
	}
}
);
});

