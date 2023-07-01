
<%@include file="common/header.jspf"%>
<%@include file="common/navbar.jspf"%>

<div class="container">

        <h2>LIST TODOS PAGE</h2>

        <table class="table">
            <thead>
                <tr>
                    <th>id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="add-todo" class="btn btn-success">Add New</a>
    </div>
    
    <%@include file="common/footer.jspf"%>