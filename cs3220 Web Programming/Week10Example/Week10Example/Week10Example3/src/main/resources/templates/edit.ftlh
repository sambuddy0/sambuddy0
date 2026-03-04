<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Comment</title>
	</head>
	<body>
		<form method="POST">
			Name: <@spring.formInput "entry.name" /><@spring.showErrors "<br />" "color: red" /><br />
			<@spring.formTextarea "entry.message" "rows='5' cols='60'" /><@spring.showErrors "<br />" "color: red" /><br />
			<button>Update Comment</button>
		</form>
	</body>
</html>