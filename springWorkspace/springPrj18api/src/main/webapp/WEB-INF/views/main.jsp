<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<h1>메인페이지</h1>
	
	<input type="number" id="cnt"> 개 
	<button onclick="mise();">미세먼지 조회</button>

	<table border="1">
		<thead>
			<tr>
				<td>이슈 밸류</td>
				<td>이슈 타임</td>
				<td>디스트릭트</td>
			</tr>	
		</thead>
		<tbody id="t">
			
		</tbody>
	</table>

	
	<script>
		function mise(){
			//미세먼지 정보 조회
			
			const cnt = document.querySelector("#cnt").value;
			$.ajax({
				url : "/app/mise" ,
				data : { "cnt" : cnt } ,
				dataType : "json" ,
				success : function(x){
					console.log("성공~~~!");
					//const obj = JSON.parse(x); //dataType 작성했으니까 파싱 필요없음
					console.log(x);

					const arr = x;

					//tbody 가져오기
					const t = document.querySelector("#t");
					
					//tbody 내용 지우기
					t.innerHTML = "";
					
					//테이블에 집어넣기
					for(let i = 0 ; i < arr.length; ++i){
						const data = arr[i];
						const tr = document.createElement("tr");
						const td1 = document.createElement("td");
						const td2 = document.createElement("td");
						const td3 = document.createElement("td");

						tr.appendChild(td1);
						tr.appendChild(td2);
						tr.appendChild(td3);

						td1.append(data.issueVal);
						td2.append(data.issueTime);
						td3.append(data.districtName);

						t.appendChild(tr);
					}

				} ,
				error : function(){
					console.log("에러...");
				} ,
			});
			
		}
	</script>

</body>
</html>













