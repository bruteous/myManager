<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Search Result</h1>
<table border="1">
    <tr>
        <td>Login</td>
        <td>First Name</td>
        <td>Last Name</td>
    </tr>
<c:forEach items="${searchResult}" var="person">
    <tr>
        <td><a href="editPerson.htm?id=<c:out value="${person.personId}"/>"><c:out value="${person.login}"/></a></td>
        <td><c:out value="${person.firstName}"/></td>
        <td><c:out value="${person.lastName}"/></td>
    </tr>
</c:forEach>
</table>
