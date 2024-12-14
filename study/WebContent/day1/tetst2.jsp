<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function sendIt(){
		
		var f=document.myForm;
		if(!f.id.value){
			alert("아이디를 입력하세요!");
			f.id.focus();
			return;
		}
		
		if(!f.pwd.value){
			alert("비밀번호를 입력하세요!");
			f.pwd.focus();
			return;
		}

		/* if(!f.agree.checked){
			alert("약관에 동의하세요");
			return;
		} */
		
		f.submit();
	}

</script>
</head>
<body>

<form action="test2_ok.jsp" name="myForm" method="post">


아이디 : <input type="text" name="id"/><br/>
패스워드 : <input type="password" name="pwd"/><br/>
이름 : <input type="text" name="name"/><br/>
성별 : <input type="radio" name="gender" checked="checked" value="M">남자
<input type="radio" name="gender" value="F">여자<br/>
전화
<select name="tel1">
	<option value="">선택</option>
	<option value="010">010</option>
	<option value="011">011</option>
	<option value="016">016</option>
	<option value="017">017</option>
</select>
<input type="text" name="tel2"/>-
<input type="text" name="tel3"><br/>

전공
<select name="major" multiple="multiple">
	<option value="전자계산학과">전자계산학과</option>
	<option value="수학과">수학과</option>
	<option value="물리학과">물리학과</option>
	<option value="영문학과">영문학과</option>
</select><br/>

동의합니까? <input type="checkbox" name="agree" value="Y"><br/>
메모 :
<textarea rows="5" cols="20" name="memo"></textarea><br/>
<br/>
<input type="button" value="회원가입" onclick="sendIt()"/>
<input type="reset" value="다시입력" onclick="document.myFrom.id.focus();"/>

</form>

</body>
</html>