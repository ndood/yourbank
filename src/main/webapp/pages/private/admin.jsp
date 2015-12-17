<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<c:if test="${pageContext.request.userPrincipal.username != null}">
    <h2>Welcome : ${pageContext.request.userPrincipal.username}</h2>
</c:if>


<form action="<c:url value="/logout"/>" method="post" id="logoutForm">
<input type="hidden"
       username="${_csrf.parameterName}"
       value="${_csrf.token}" />
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<c:if test="${pageContext.request.userPrincipal.username != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.username} |
        <a href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>
</body>
</html>