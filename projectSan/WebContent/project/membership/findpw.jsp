<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>

<link rel="stylesheet" href="<%=cp%>/project/css/project.css" type="text/css">

<script type="text/javascript">

	function findpw() {
		
		var f = document.myForm;
		
	    var idError = document.getElementById('idError');
 	    var nameError = document.getElementById('nameError');
	    var emailError = document.getElementById('emailError');
	    
	    idError.textContent = '';
	    nameError.textContent = '';
	    emailError.textContent = '';
		
		if(!f.id.value){
            idError.textContent = '아이디를 입력하세요.';
            idError.style.display = 'block';	
			f.id.focus();
			return;
		}
		
		if(!f.name.value){
            nameError.textContent = '이름을 입력하세요.';
            nameError.style.display = 'block';			
			f.name.focus();
			return;
		}
		
		if(!f.email.value){
            emailError.textContent = 'E-Mail 주소를 입력하세요.';
            emailError.style.display = 'block';			
			f.email.focus();
			return;
		}

		f.action = "<%=cp%>/pj/findpw_ok.do";
		f.submit();

	}
</script>

</head>
<body>

<jsp:include page="../header.jsp" />

<div id="container"> 
<div id="contents_sub" style="width: 20%;">      

<div class="path">
    <span>현재 위치</span>
    <ol><li><a href="<%=cp%>/view/main.do">홈</a></li>
        <li title="현재 위치"><strong>비밀번호 찾기</strong></li>
    </ol></div><br/>


<div class="titleArea">
    <h2>비밀번호 찾기</h2>
</div>

<form name="myForm" action="" method="get" enctype="multipart/form-data">
<div class="xans-element- xans-member xans-member-findpasswd ec-base-box typeThin ">

<div class="findPw">
        <fieldset>
            <ul class="ec-base-desc">
<li>
<strong class="term">회원유형</strong><span class="desc">
<select id="searchType" name="searchType" >
<option value="indi" selected="selected">개인회원&nbsp;</option></select><span class="check gBlank5"></span>
</li>
<li class="gBlank20">
<strong class="term">아이디</strong><span class="desc"><input name="id" class="lostInput" type="text"><span id="idError" class="error-message"></span></span>
</li>
<li id="gBlank20" class="name" >
<strong class="term" id="name_lable">이름</strong><span class="desc">
<input name="name" class="lostInput ec-member-name" type="text"><span id="nameError" class="error-message"></span></span>
</li>
<li id="gBlank20" class="email">
<strong class="term">이메일</strong><span class="desc">
<input name="email" class="lostInput" type="text"><span id="emailError" class="error-message"></span></span>
</li>
<br/>
</ul>
<div class="ec-base-button gColumn">
                <a href="#" class="btnSubmit sizeM" onclick="findpw();">확인</a>
            </div>
            
            <tr height="30">
	<td colspan="2" align="center">
		<font color="red"><b>${message }</b></font>
	</td>
</tr>
        </fieldset>
</div>
</div>

<div class="ec-base-button gBlank20">
            <a href="<%=cp%>/pj/login.do" class="btnSubmitFix sizeM ">로그인</a></div>

</form> 
<div style="margin:80px 0px 0px 0px;"></div>    
</div>          
            
        <hr class="layout"></div>
        
        	<jsp:include page="../footer.jsp" />

</body>
</html>