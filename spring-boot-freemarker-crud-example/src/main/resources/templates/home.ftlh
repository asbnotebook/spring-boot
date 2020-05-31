<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Student CRUD operation with Freemarker Template</h1>
		<a href="/create">Create New Student</a>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Grade</th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<#list students as student>
				<tr>
					<th scope="row">${student.id}</th>
					<td>${student.name}</td>
					<td>${student.grade}</td>
					<td><a href="/update/${student.id}">Update</a></td>
					<td><a href="/delete/${student.id}">Delete</a></td>
				</tr>
				</#list>
			</tbody>
		</table>
	</div>
</body>
</html>