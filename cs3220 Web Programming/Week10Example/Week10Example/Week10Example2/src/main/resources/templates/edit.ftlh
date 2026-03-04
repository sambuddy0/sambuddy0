<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Comment</title>
	</head>
	<body>
		<form method="POST">
			Name: <input type="text" name="name" id="name" value="${entry.name}" /><br />
			<textarea name="message" id="message" row="5" cols="60">${entry.message}</textarea><br />
			<button>Update Comment</button>
		</form>
	</body>
</html>