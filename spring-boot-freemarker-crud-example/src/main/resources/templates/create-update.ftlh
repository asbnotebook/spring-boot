<!doctype html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>
			<#if !isUpdate>Create</#if>
			<#if isUpdate>Update</#if>
			Student
		</h1>
		<div>
			<form action="<#if isUpdate>/update/${student.id}</#if><#if !isUpdate>/create</#if>" name="student" method="post">
				<table class="table">
					<tbody>
					<thead>
						<tr>
							<th>Field</th>
							<th>Value</th>
						</tr>
					</thead>
					<tbody>
						<#if isUpdate>
						<tr>
							<th>ID</th>
							<td><div name="id">${student.id}</div></td>
						</tr>
						</#if>
						<tr>
							<th>Name</th>
							<td><input type="text" name="name" value="<#if student.name??>${student.name}</#if>" /></td>
						</tr>
						<tr>
							<th>Grade</th>
							<td><input type="text" name="grade" value="<#if student.grade??>${student.grade}</#if>" /></td>
						</tr>
					</tbody>
				</table>
				<button type="submit" class="btn btn-primary">Save</button>
			</form>
		</div>
	</div>
</body>
</html>