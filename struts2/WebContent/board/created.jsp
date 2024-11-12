<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>


<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/style.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp%>/board/css/created.css"/>

<script type="text/javascript" src="<%=cp%>/board/js/util.js"></script>
<script type="text/javascript">

	function sendIt(){
		
		f = document.myForm;
		
		str = f.subject.value;
		str = str.trim();
		if(!str){
			alert("\n제목을 입력하세요.");
			f.subject.focus();
			return;
		}
		f.subject.value = str;
		
		str = f.name.value;
		str = str.trim();
		if(!str){
			alert("\n이름을 입력하세요.");
			f.name.focus();
			return;
		}
		/*
		if(!isValidKorean(str)){
			alert("\n이름을 정확히 입력하세요.");
			f.name.focus();
			return;
		}
		*/
		f.name.value = str;
		
		if(f.email.value){
			if(!isValidEmail(f.email.value)){
				alert("\n정상적인 E-Mail을 입력하세요.");
				f.email.focus();
				return;
			}			
		}
		
		str = f.content.value;
		str = str.trim();
		if(!str){
			alert("\n내용을 입력하세요.");
			f.content.focus();
			return;
		}
		f.content.value = str;
				
		str = f.pwd.value;
		str = str.trim();
		if(!str){
			alert("\n패스워드를 입력하세요.");
			f.pwd.focus();
			return;
		}
		f.pwd.value = str;
		
		if(f.mode.value=="create"){
			
			f.action = "<%=cp%>/bbs/created.action";
		}else if(f.mode.value=="update"){
			
			f.action = "<%=cp%>/bbs/updated.action";
		}else if(f.mode.value=="reply"){
			
			f.action = "<%=cp%>/bbs/reply.action";
		}
		
		
		f.submit();		
		
	}

</script>



<div id="bbs">

	<div id="bbs_title">
	게 시 판
	</div>
	
	<form action="" method="post" name="myForm">
	<div id="bbsCreated">
	
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				<dd>
				<input type="text" name="subject" size="60" 
				maxlength="100" class="boxTF" value="${dto.subject }"/>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>작 성 자</dt>
				<dd>
				<input type="text" name="name" size="35" 
				maxlength="20" class="boxTF" value="${dto.name }"/>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>E-Mail</dt>
				<dd>
				<input type="text" name="email" size="35" 
				maxlength="50" class="boxTF" value="${dto.email }"/>
				</dd>
			</dl>		
		</div>
		
		<div id="bbsCreated_content">
			<dl>
				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
				<dd>
				<textarea rows="12" cols="63" class="boxTA" name="content" 
				style="resize: none; background-color: #ffffff;">${dto.content }</textarea>
				</dd>
			</dl>		
		</div>
		
		<div class="bbsCreated_noLine">
			<dl>
				<dt>패스워드</dt>
				<dd>
				<input type="password" name="pwd" size="35" 
				maxlength="7" class="boxTF" value="${dto.pwd }"/>&nbsp;
				(게시물 수정및 삭제시 필요!!)
				</dd>
			</dl>		
		</div>		
		
	</div>
	
	<div id="bbsCreated_footer">
	
		
	<!-- 수정할 때 필요한 데이터 -->
	<input type="hidden" name="num" value="${dto.num }"/>
	<input type="hidden" name="pageNum" value="${pageNum }"/>
	
	<!-- 댓글 -->
	<input type="hidden" name="groupNum" value="${dto.groupNum }"/>
	<input type="hidden" name="orderNo" value="${dto.orderNo }"/>
	<input type="hidden" name="depth" value="${dto.depth }"/>
	<input type="hidden" name="parent" value="${dto.num }"/>
	
	<input type="hidden" name="mode" value="${mode }"/>
	
	<c:if test="${mode=='create' }">
	
		<input type="button" value=" 등록하기 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value=" 다시입력 " class="btn2" 
		onclick="document.myForm.subject.focus();"/>
		<input type="button" value=" 작성취소 " class="btn2"
		onclick="location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
	
	</c:if>
	
	<c:if test="${mode=='update' }">
	
		<input type="button" value=" 수정하기 " class="btn2" onclick="sendIt();"/>
		<input type="button" value=" 수정취소 " class="btn2"
		onclick="location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
	
	</c:if>
		
	<c:if test="${mode=='reply' }">
	
		<input type="button" value=" 답변등록 " class="btn2" onclick="sendIt();"/>
		<input type="reset" value=" 다시입력 " class="btn2" 
		onclick="document.myForm.subject.focus();"/>
		<input type="button" value=" 작성취소 " class="btn2"
		onclick="location.href='<%=cp%>/bbs/list.action?pageNum=${pageNum }';"/>
	
	</c:if>
	</div>	 
	
	</form>
</div>




