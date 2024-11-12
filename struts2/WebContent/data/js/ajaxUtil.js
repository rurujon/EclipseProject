
var xmlHttp;

function getXmlHttpRequest(){
	
	if(window.ActiveXObject){ //IE
			
		try {//IE5.0이후
				return new ActiveXObject("Msxml2.XMLHTTP");
				
		} catch (e) {//IE5.0이전
				return new ActiveXObject("Microsoft.XMLHTTP");
		}			
			
	}else{//Non-IE
			return new XMLHttpRequest();
	}	
	
}


function sendRequest(url,params,callback,method){
	
	xmlHttp = getXmlHttpRequest();
	
	//method처리
	var httpMethod = method ? method : "GET";
	
	if(httpMethod!="GET"&&httpMethod!="POST"){
		httpMethod = "GET";
	}
	
	//params처리
	var httpParams = (params==null || params=="") ? null : params;
	
	//url처리
	var httpUrl = url;
	
	if(httpMethod=="GET" && httpParams!=null){
		httpUrl = httpUrl + "?" + params;
	}
	
	xmlHttp.open(httpMethod,httpUrl,true);
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange = callback;
	xmlHttp.send(httpMethod=="POST" ? httpParams : null);	
	
}













