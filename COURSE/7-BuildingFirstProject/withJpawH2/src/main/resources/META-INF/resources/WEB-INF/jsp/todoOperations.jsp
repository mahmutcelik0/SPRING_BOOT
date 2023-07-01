
        <%@include file="common/header.jspf"%>
        <%@include file="common/navbar.jspf"%>

        <div class="container">
            <h2>ENTER TODO DETAILS</h2>

            <%--@elvariable id="todo" type="com.mahmutcelik.demo.todo.Todo"--%>
            <form:form method="post" modelAttribute="todo">

                <%--We can group --%>
                <fieldset>
                    <form:label path="description">Description:</form:label>
                    <form:input type="text" path="description"  required="required"/>
                    <form:errors path="description" cssClass="text-warning"/>
                </fieldset>

                <br><br>

                <fieldset>
                    <form:label path="targetDate">Target Date:</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
                <br><br>
                <input type="submit" class="btn btn-success" value="SUBMIT">
            </form:form>
        </div>

        <script type="text/javascript">
            $('#targetDate').datepicker({
                format:'yyyy-MM-dd',
                startDate: '-3d'
            });
        </script>

        <%@include file="common/footer.jspf"%>



