    <%@include file="common/header.jspf" %>
    <%@include file="common/navigation.jspf" %>

    <div class="container">

        <div>
            <h2>Welcome to in28minutes</h2>
            <p>${name}</p>
        </div>

        <hr />

        <h2>Todo Details</h2>

        <form:form method="post" modelAttribute="todo">

           <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
           </fieldset>
           <fieldset class="mb-3">
                <form:label path="targetDate">Target Date</form:label>
                <form:input type="text" path="targetDate" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
           </fieldset>

            <form:input type="hidden" path="id" />

            <form:input type="hidden" path="done" />

            <input type="submit" class="btn btn-success" value="submit" />

        </form:form>

    </div>

    <%@include file="common/footer.jspf" %>

    <script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
    </script>



