<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SysLog</h1>
	<div id="text">
		<table width="100%" border="1">
			<thead>
				<tr>
					<th>method</th>
					<th>ip</th>
					<th>createdTime</th>
					<th>id</th>
					<th>time</th>
					<th>params</th>
					<th>operation</th>
					<th>username</th>
				</tr>
			</thead>
			<tbody id="tbodyId">
				<tr>
					<td colspan="8">
					<button type="button" onclick="doGetObjects()">获取日志</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		function doGetObjects(){
			var xhr = new XMLHttpRequest();
			
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					doHandleResponseResult(xhr.responseText);
				}
			}
			xhr.open("GET","http://localhost:8080/CGB-DB-SYS-V2.01/sysLog/findLogs.do",true);
			xhr.send(null);
		}
		function doHandleResponseResult(text) {
			var result=JSON.parse(text);
			console.log(result);
			doSetTableBodyRows(result);
		}
		function doSetTableBodyRows(result){
			var tBody=document.getElementById("tbodyId");
			tBody.innerHTML="";
			for(var i=0;i<result.length;i++){
				var tr=document.createElement("tr");
				doCreateTds(i,tr,result[i]);
				tBody.appendChild(tr);
			}
		}
		function doCreateTds(i,tr,row){
			var td=document.createElement("td");
			td.innerText=row.method;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.ip;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.createdTime;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.id;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.time;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.params;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.operation;
			tr.appendChild(td);
			
			td=document.createElement("td");
			td.innerText=row.username;
			tr.appendChild(td);
		
		}
	</script>
</body>
</html>