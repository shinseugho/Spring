<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width: 600px;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center">글쓰기</h1>
		<div class="row">
		<!-- enctype="multipart/form-data"이게 없으면 500page로 이동한다. 또한, 업로드가 없는 페이지에 사용하면 안된다. -->
		<form method="post" action="insert_ok.do">
			<table class="table table-hover">
				<tr>
					<th width="20%" class="text-right success">이름</th>
					<td width="80%">
						<input type="text" name="name" size="15" required>
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right success">제목</th>
					<td width="80%">
						<input type="text" name="subject" size="50" required>
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right success">내용</th>
					<td width="80%">
						<textarea rows="8" cols="55" name="content" required></textarea>
					</td>
				</tr>
				<tr>
					<th width="20%" class="text-right success">비밀번호</th>
					<td width="80%">
						<input type="password" name="pwd" size="10" required>
					</td>
				</tr>
				<tr>
					<td class="text-center" colspan="2">
						<input type="submit" value="글쓰기" class="btn btn-sm btn-primary">
						<input type="button" value="취소" class="btn btn-sm btn-danger"
							onclick="javascript:history.back()"
						>
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>	
</body>
</html>