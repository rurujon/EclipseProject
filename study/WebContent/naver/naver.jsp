<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8"); 
	String cp=request.getContextPath();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function check() {
		
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
		
		if(!f.email.value){
			alert("이메일을 입력하세요!");
			f.email.focus();
			return;
		}
		if(!f.name.value){
			alert("이름을 입력하세요!");
			f.name.focus();
			return;
		}
		if(!f.birth.value){
			alert("생일을 입력하세요!");
			f.bir.focus();
			return;
		}
		if(f.telecom.value==""){
			alert("통신사를 선택하세요!");
			f.con.focus();
			return;
		}
		if(!f.tel.value){
			alert("전화번호를 입력하세요!");
			f.tel.focus();
			return;
		}
		
		f.action = "<%=cp%>/naver/naver_ok.jsp";
		f.submit();
	}



</script>
</head>
<body>

<form action="" name="myForm" method="post">
	<table border="0" width="400" align="center">
	
		<tr align="left">
	 		<td><img src="<%=cp%>/html/image/naver.gif">
	 		</td>
	 	</tr>
	
		<tr>
			<td colspan="2" class="full-width" align="right">
                <input type="checkbox"> 실명 인증된 아이디로 가입.
            </td>
        </tr>
	
	</table>

	<table border="2" width="400" align="center">
	 	
        <tr align="center">
            <td><img src="<%=cp%>/html/image/id.gif"><input type="text" name="id" placeholder="@naver.com"></td>
        </tr>
        <tr align="center">
            <td><img src="<%=cp%>/html/image/id.gif"><input type="password" name="pwd" placeholder="비밀번호"></td>
        </tr>
        <tr align="center">
            <td><img src="<%=cp%>/html/image/id.gif"><input type="email" name="email" placeholder="이메일주소 (비밀번호 찾기 등 본인 확인용)"></td>
        </tr>
    </table>
    <br/>
    
    <table border="1" cellpadding="10" cellspacing="0" width="400" align="center">
        <tr>
            <td align="center" colspan="4"><img src="<%=cp%>/html/image/id.gif"><input type="text" name="name" placeholder="이름"></td>
        </tr>
        <tr>
            <td align="center" colspan="4"><img src="<%=cp%>/html/image/id.gif"><input type="text" name="birth" placeholder="생년월일 8자리"></td>
        </tr>
        <tr>
        	<td align="center" colspan="4">
        		<select name="telecom">
        			<option value="">통신사 선택</option>
        			<option value="skt">skt</option>
        			<option value="kt">kt</option>
        			<option value="lg">lg</option>
        			<option value="알뜰폰">알뜰폰</option>
        		</select>
        	</td>
        <tr align="center">
        	<td>
        	<input type="radio" name="gender" value="남성" checked="checked">남자
        	<input type="radio" name="gender" value="여성">여자
        	</td>
        	<td>
        	<input type="radio" name="nation" value="내국인" checked="checked">내국인
        	<input type="radio" name="nation" value="외국인">외국인
        	</td>
        </tr>
        	
        <tr>
            <td align="center" colspan="4"><img src="<%=cp%>/html/image/id.gif"><input type="tel" name="tel" placeholder="휴대전화번호"></td>
        </tr>
     </table>   
     <br/>
     
     <table border="2" width="400" align="center">
        <tr align="center">
            <td colspan="2" class="full-width">
                <input type="checkbox"> <font size "7" color ="green"> [필수]</font> <font size "10"> 인증 약관 전체동의</font>
            </td>
        </tr>
    </table>
    <br/><br/><br/>
    
    <table border="0" cellpadding="10" cellspacing="0" width="600" align="center">
    	<tr align="center">
    		<td align="center">
    			<a href="javascript:void(0);" onclick="check();">
    			<img src="<%=cp%>/html/image/accredit.gif" width="400" height="50" name="img1"/><br/>
    			</a>
    		</td>
    	</tr>
    </table>
    
</form>

</body>
</html>