<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Contact Name</th>
					<th>Phone Number</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td>${todo.cnumber}</td>
						<td><a type="button" class="btn btn-warning"
							href="/update-todo?id=${todo.id}">Change</a></td>
						<td><a type="button" class="btn btn-danger"
							href="/delete-todo?id=${todo.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a type="button" class="btn btn-info"
			   href="/add-todo">Add a Contact</a>

		</div>
	</div>
<%@ include file="common/footer.jspf" %>