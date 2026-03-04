<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dependency Injection</title>
	</head>
	<body>
		<h2>Dependency Injection Guest Book Example</h2>
		<h3>Data Component</h3>
		<#list dataComponent>
			<table border="1">
				<thead>
					<tr><th>Name</th><th>Message</th><th>Date</th><th>Long Date</th><th>M/d/yyyy</th></tr>
				</thead>
				<tbody>
					<#items as entry>
						<tr>
							<td>${entry.name}</td>
							<td>${entry.message}</td>
							<td>${entry.date}</td>
							<td>${entry.date.format("LONG_DATE")}</td>
							<td>${entry.date.format("M/d/yyyy")}</td>
						</tr>
					</#items>
				</tbody>
			</table>
		<#else>
			<p>No Entry</p>
		</#list>
		
		<h3>Data Configuration</h3>
		<#list dataConfiguration>
			<table border="1">
				<thead>
					<tr><th>Name</th><th>Message</th><th>Date</th><th>Long Date</th><th>M/d/yyyy</th></tr>
				</thead>
				<tbody>
					<#items as entry>
						<tr>
							<td>${entry.name}</td>
							<td>${entry.message}</td>
							<td>${entry.date}</td>
							<td>${entry.date.format("LONG_DATE")}</td>
							<td>${entry.date.format("M/d/yyyy")}</td>
						</tr>
					</#items>
				</tbody>
			</table>
		<#else>
			<p>No Entry</p>
		</#list>
		<h3>Constructor Injection</h3>
		<#list constructorInjection>
			<table border="1">
				<thead>
					<tr><th>Name</th><th>Message</th><th>Date</th><th>Long Date</th><th>M/d/yyyy</th></tr>
				</thead>
				<tbody>
					<#items as entry>
						<tr>
							<td>${entry.name}</td>
							<td>${entry.message}</td>
							<td>${entry.date}</td>
							<td>${entry.date.format("LONG_DATE")}</td>
							<td>${entry.date.format("M/d/yyyy")}</td>
						</tr>
					</#items>
				</tbody>
			</table>
		<#else>
			<p>No Entry</p>
		</#list>
	</body>
</html>