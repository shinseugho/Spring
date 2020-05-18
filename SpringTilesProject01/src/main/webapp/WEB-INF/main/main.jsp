<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<div class="row">
		<table class="table" style="height: 700px; width: 900px;">
			<tr>
			<!-- <tiles:insertAttribute name="header" />에서 name은 마음대로 작성해도 되자만 붙여지는 내용과 같은 이름을 주는 것이 구분하기에 편하다. -->
				<td colspan="2" height="100px" class="success text-center">
					<tiles:insertAttribute name="header" />
				</td>
			</tr>
			<tr>
				<td width="200px" height="500px" class="danger">
					<tiles:insertAttribute name="menu" />
				</td>
				<td width="700px" height="500px" class="warning">
					<tiles:insertAttribute name="content" />
				</td>
			</tr>
			<tr>
				<td colspan="2" height="100px" class="info text-center">
					<tiles:insertAttribute name="footer" />
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>