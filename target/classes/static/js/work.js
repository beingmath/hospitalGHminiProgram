$(function() {
	$(".postwork").click(function() {
		document.getElementById("overDiv").style.display = "block";
		document.getElementsByClassName("Workform")[0].style.display = "block";
	});
	$(".btn2").click(function() {
		$(".Workform").css("display", "none");
		$("#overDiv").css("display", "none");
	});
	$(".btn1").mouseenter(function() {
		var a = $(".workname").val().length;
		var b = $(".inputarea").val().length;
		var c = $(".time").val();
		if (a == 0 || b == 0 || c == 0) {
			$(".btn1").prop("disabled", true);
		} else {
			$(".btn1").prop("disabled", false);
		}
	});
	$(".close").click(function(){
		document.getElementById("overDiv").style.display ="none";
		$(".postpercent").css("display","none");
		$(".committt").css("display", "block");
	});
	var $primaryid=0;
	//点击评分按扭。
	 var $clickWorkli;
	$("body").delegate(".rank","click",function(){
		document.getElementById("overDiv").style.display = "block";
		$clickWorkli=$(this);
		$primaryid=$(this).parents(".bbbb").get(0).id;
		//得到点击id,设置display;
		$(".postpercent").css("display","block");
		$(".postpercent").css("z-index","5");
	});
	$(".postPercentTo").click(function(){
		document.getElementById("overDiv").style.display ="none";
		var $workid=$(".bbbb").get(0).workid;
	var postid=	$(this).parents(".postpercent").workid;
		var $percent=$(".active").text();
		$clickWorkli.text("评分:"+$percent);
				$.ajax({
				url : "postPercent",
				data:{
					primaryid:$primaryid,
					percent:$percent
				},
				success : function(data) {
					$(".postpercent").css("display","none");
				}
			}
			);
		});
	//点击作业详情调到作业详情页面，设置committt,work,作业id,可以得到作业id
	//通过作业id获取已提交了作业的人
	$("body").delegate(".commit","click",function(){
		var $id= $(this).parents("li").get(0).id;
		 $(".committt").css("display", "block");
		 $(".work").css("display", "none");
		 //发送ajax请求获取提交了作业的人列表，拼接到前台
		 $.ajax({
				url : "getCommitStudentList",
				data : {
					workid : $id
				},success:function(data){
					for (var i = 0;i <data.length; i++) {
						var index=i+1;
						var $commitlist=CommitStudentList(index,data[i]);
						$commitlist.get(0).id=data[i].primary_id;
						$(".postpercent").get(0).workid=data[i].id;
						$commitlist.get(0).workid=data[i].id;
						$commitlist.appendTo($(".big2"));
						}
				}
			});
	});
	function CommitStudentList(index,work){
		var $commitlist=$("<li class=\"bbbb\"><ul class=\"small2\">\n" +
					"	<li>"+index+"</li>\n" +
					"	<li>"+work.studentname+"</li>\n" +
					"	<li title=\""+work.committime+"\">"+work.committime.substring(0, 10)+"</li>\n" +
					"	<li class=\"mmmm\"><a href=\"fileDownLoad?filename="+work.filename+"\">下载</a>|<a class=\"rank\">评分"+work.percent+"</a>\n" +
				"	</ul></li>");
		return $commitlist;
	}
	//
	function createStudentWork(work){
		var $studentWork=$("<li><ul class=\"small3\"><li title=\""+work.workname+"\"1 >"+work.workname.substring(0, 8)+"</li><li>"+work.endtime.substring(0, 10)+"</li>\n" +
				"<li>"+work.committime.substring(0, 10)+"</li>\n" +
				"<li>"+work.status+"</li>\n" +
				"<li class=\"percent\">"+((work.status!="未提交")?"评分:"+work.percent:"<form action=\"fileUpLoad\" method=\"post\"  enctype=\"multipart/form-data\">\n" +
                "<input class=\"file\" type=\"file\"  name=\"file\"/><input type=\"hidden\" value="+work.id+" name=\"workid\"/><input type=\"submit\" value=\"提交\"/>" +
           "</form>") +
           "</li>\n" +
				"</ul></li>");
		return $studentWork;
	}
 function createWork(work){
	 var $work=$("<li><ul class=\"small\"><li title=\""+work.workname+"\">"+work.workname.substring(0, 8)+"</li>\n" +
	 		"<li title=\""+work.begintime+"\">"+work.begintime.substring(0, 10)+"</li>\n" +
		"<li title=\""+work.endtime+"\">"+work.endtime.substring(0, 10)+"</li>\n" +
		"<li class=\"commit\"><a>提交详情</a></li>\n" +
		"</ul></li>");
   return $work;
 }
 //提交作业的页面点返回按钮
 $(".returnBtn").click(function(){
	 $(".bbbb").remove();
	 $(".committt").css("display", "none");
	 $(".work").css("display", "block");
 });
 //可以后端传一个值过来来判断是teacher还是student
 //，然后根据数据来判断拼接什么数据到前端
 $.ajax({
		url : "selectWork",
		success : function(data) {
			if(data[0].isStudent==3){
				$(".work").css("display","none");
				$(".studentwork").css("display","block");
			}
			else if(data[0].isStudent==0){
				$(".work").css("display","block");
				$(".studentwork").css("display","none");
			for (var i = 0; i <data.length; i++) {
			var $work=createWork(data[i]);
			$work.get(0).id=data[i].id;
			$work.appendTo($(".big"));
			}
			}else{
				$(".work").css("display","none");
				$(".studentwork").css("display","block");
				for (var i = 0; i <data.length; i++) {
					var $work=createStudentWork(data[i]);
					$work.get(0).id=data[i].id;
					$work.appendTo($(".big3"));
					}
			}
		}
	});
});