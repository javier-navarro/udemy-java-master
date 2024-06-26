<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:include page="layout/header.jsp" />
    <h3>${title}</h3>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="row my-2">
            <label class="form-label" for="username">USERNAME</label>
            <div>
                <input type="text" name="username" id="username" class="form-control">
            </div>
        </div>
        <div class="row my-2">
            <label class="form-label" for="password"> PASSWORD</label>
            <div>
                <input type="password" name="password" id="password" class="form-control">
            </div>
        </div>
        <div class="row my-2">
            <input  type="submit" value="login" class="btn btn-primary">
        </div>
    </form>
<jsp:include page="layout/footer.jsp" />