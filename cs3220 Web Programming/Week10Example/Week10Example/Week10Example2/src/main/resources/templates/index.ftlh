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
					<tr><th>Name</th><th>Message</th><th>Date</th><th>LONG DATE</th><th>M/d/yyyy</th><th>Edit</th><th>Edit 2</th><th>Edit 3</th></tr>
				</thead>
				<tbody>
					<#items as entry>
						<tr>
							<td>${entry.name}</td>
							<td>${entry.message}</td>
							<td>${entry.date}</td>
							<td>${entry.date.format("LONG_DATE")}</td>
							<td>${entry.date.format("M/d/yyyy")}</td>
							<td><a href="edit?id=${entry.id}">Edit</a></td>
							<td><a href="edit2/${entry.id}">Edit 2</a></td>
							<td><a href="edit3/${entry.id}">Edit 3</a></td>
						</tr>
					</#items>
				</tbody>
			</table>
		<#else>
			<p>No Entry</p>
		</#list>
		<p><a href="add">Add Comment</a></p>
		<p><a href="add2">Add Comment 2</a></p>
	</body>
</html>