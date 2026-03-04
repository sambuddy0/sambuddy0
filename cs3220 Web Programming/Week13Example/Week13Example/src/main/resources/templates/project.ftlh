<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Project</title>
	</head>
	<body>
		<h2>${project.name}</h2>
		<ul>
			<#list project.members as member>
				<li>${member.firstName} ${member.lastName}</li>
			</#list>
		</ul>
	</body>
</html>