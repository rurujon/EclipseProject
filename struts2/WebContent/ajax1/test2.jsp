<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#sendBtn").click(function(){
			
			var params = "subject=" + $("#subject").val() + 
						"&content" + $("#content").val();
			
			$.ajax({
				
				type:"POST",
				url:"test2_ok.jsp",
				data:params,
				dataType:"xml",//돌아올떄의 데이터 타입_ok의 데이터 타입
				success:function(args){// _ok의 xml이 args로 들어옴 (파싱을 해야함)
				
					 //xml에서 데이터 파싱 
					 $(args).find("status").each(function(){//each 반복문. status가 여러개 있을경우를 대비해 여러번 찾아봄.
						 alert($(this).text());
					 });

					var str = "";

					$(args).find("record").each(function(){
						
						var id = $(this).attr("id");
						var subject = $(this).find("subject").text();
						var content = $(this).find("content").text();
						
						str += "id=" + id + 
							",subject=" + subject +
							",content=" + content + "<br/>";
						
					});
					
					$("#resultDiv").html(str);
				
				
					
				},
				beforeSend:showRequest,//실행전 showRequest메소드 실행. 메소드내에서 트루가 반환되어야지만 실행됨.
				error:function(e){//에러 발생시
					alert(e.response.Text);//응답된 에러메세지를 뿌려라.
				}
				
			});
			
			
		});
		
		
		
	});
	
	function showRequest(){
		
		var flag = true;
		
		if(!$("#subject").val()){//입력된 값이 없으면
			alert("제목을 입력하세요.");
			$("#subject").focus();
			return false;
		}
		
		if(!$("#content").val()){//입력된 값이 없으면
			alert("내용을 입력하세요.");
			$("#content").focus();
			return false;
		}
		
		return flag;//반드시 트루를 돌려줘야함. 리턴값이 트루가 되어야만 위에서 이 메소드를 호출해을때의 반환값으로 실행이 가능함.
	}



</script>






</head>
<body>

제목: <input type="text" id="subject"/><br/>
내용: <input type="text" id="content"/><br/>
<input type="button" id="sendBtn" value="보내기"/><br/>

<div id="resultDiv"></div>

</body>
</html>