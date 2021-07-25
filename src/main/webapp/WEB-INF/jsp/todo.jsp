<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="todo">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="desc">Contact Name</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="cnumber">Phone Number</form:label>
			<form:input path="cnumber" type="text" class="form-control"
				required="required" />
			<form:errors path="cnumber" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Save</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>