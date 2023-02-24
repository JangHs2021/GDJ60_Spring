<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
</head>
<body>
	<script type="text/javascript">
		let message = '${result}';
		if(message != '') {
			alert(message);
		}
		location.href = "${url}"
	</script>
</body>
</html>