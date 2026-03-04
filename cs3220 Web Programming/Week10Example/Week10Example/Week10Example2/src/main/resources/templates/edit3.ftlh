<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Comment</title>
	</head>
	<body>
		<form method="POST">
			Name: <@spring.formInput "entry.name" /><br />
			<@spring.formTextarea "entry.message" "rows='5' cols='60'" /><br />
			<button>Update Comment</button>
		</form>
	</body>
</html>