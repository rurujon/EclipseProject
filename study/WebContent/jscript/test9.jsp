<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function checkAll(){
		var clength = document.myForm["sul"].length;
		
		
		for(var i=0; i<clength; i++){
			
			document.myForm["sul"][i].checked = true;
		}
		
	}
	
	function checkDel(){
		var clength = document.myForm["sul"].length;
		
		for(var i=0; i<clength; i++){
			
			document.myForm["sul"][i].checked = false;
		}
	}


</script>


</head>
<body>

<h3>좋아하는 술 종류</h3><br/>
<form action="" name="myForm">

<a href="javascript:checkAll();">전체선택</a>/
<a href="javascript:checkDel();">전체해제</a><br/>

<input type="checkbox" name="sul"/>위스키<br/>
<input type="checkbox" name="sul"/>보드카<br/>
<input type="checkbox" name="sul"/>생맥주<br/>
<input type="checkbox" name="sul"/>소주<br/>
<input type="checkbox" name="sul"/>막걸리<br/>
<input type="checkbox" name="sul"/>와인<br/>
<input type="checkbox" name="sul"/>칵테일<br/>
<input type="checkbox" name="sul"/>꼬냑<br/>



</form>

</body>
</html>