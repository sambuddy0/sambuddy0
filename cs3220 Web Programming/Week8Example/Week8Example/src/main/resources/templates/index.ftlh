<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>This is FTLH Example</h2>
	<h2>Hello ${firstName} ${lastName}</h2>
	<h2>${entries[0].name} says ${entries[0].message} on ${entries[0].date}</h2>
	<h2>${entries[0].all}</h2>
	<h2>${entries[0].me}</h2>
	
	<#list entries>
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
		<h2>No Entry</h2>
	</#list>
	<ul>
		<#list users as user>
			<li>${user}</li>
		</#list>
	</ul>
	<#list users as user>
		${user}<#sep>,</#sep>
	</#list>
	<h2>${123.123}</h2>
	<h2>${123.123?string.currency}</h2>
	<h2>${123.123?string.percent}</h2>
	<h2>${123.123?string["0"]}</h2>
	<h2>${123.123?string["0.##"]}</h2>
</body>
</html>