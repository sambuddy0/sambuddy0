<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dependency Injection</title>
	</head>
	<body>
		<h2>Dependency Injection Guest Book Example</h2>
		<h3>Entries from Data Component</h3>
		<#list dataComponent>
			<table border="1">
				<thead>
					<tr><th>Name</th><th>Message</th><th>Date</th><th>LONG DATE</th><th>M/d/yyyy</th><th>Edit</th></tr>
				</thead>
				<tbody>
					<#items as entry>
						<tr>
							<td>${entry.name}</td>
							<td>${entry.message}</td>
							<td>${entry.date}</td>
							<td>${entry.date.format("LONG_DATE")}</td>
							<td>${entry.date.format("M/d/yyyy")}</td>
							<td><a href="edit/${entry.id}">Edit</a></td>
						</tr>
					</#items>
				</tbody>
			</table>
		<#else>
			<p>No Entry</p>
		</#list>
		<p><a href="add">Add Comment</a></p>
	</body>
</html>