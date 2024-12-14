<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function bestpoll(){
		
		var clength = document.myForm.sul.length;
		
		for(var i=0; i<clength; i++){
			
			if(document.myForm.sul[i].checked==true){
				alert(document.myForm.sul[i].value + "를 좋아하는구나")
				return;
			}
			
		}
		window.alert("술 싫어하는구나");
		
	}

</script>

</head>
<body>

<h3>가장 좋아하는 술 종류</h3><br/>
<form action="" name="myForm">


<input type="radio" name="sul" value="위스키"/>위스키<br/>
<input type="radio" name="sul" value="보드카"/>보드카<br/>
<input type="radio" name="sul" value="생맥주"/>생맥주<br/>
<input type="radio" name="sul" value="소주"/>소주<br/>
<input type="radio" name="sul" value="막걸리"/>막걸리<br/>
<input type="radio" name="sul" value="와인"/>와인<br/>
<input type="radio" name="sul" value="칵테일"/>칵테일<br/>
<input type="radio" name="sul" value="꼬냑"/>꼬냑<br/>

<a href="javascript:bestpoll();">
<img src="../html/image/btn_poll01.gif"/>
</a>

</form>

</body>
</html>