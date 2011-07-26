<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1><fmt:message key="person.form.title.search"/></h1>

<c:if test="${not empty statusMessageKey}">
    <p><fmt:message key="${statusMessageKey}"/></p>
</c:if>

<form:form var="searchPerson.htm" commandName="person">
    <fieldset>
        <div class="form-row">
            <label for="login"><fmt:message key="person.form.login"/>:</label>
            <span class="input"><form:input path="login" /></span>
        </div>
        <%--<div class="form-row">--%>
            <%--<label for="firstName"><fmt:message key="person.form.firstName"/>:</label>--%>
            <%--<span class="input"><form:input path="firstName" /></span>--%>
        <%--</div>--%>
        <%--<div class="form-row">--%>
            <%--<label for="lastName"><fmt:message key="person.form.lastName"/>:</label>--%>
            <%--<span class="input"><form:input path="lastName" /></span>--%>
        <%--</div>--%>
        <%--<div class="form-row">--%>
            <%--<label for="dob"><fmt:message key="person.form.dob"/>:</label>--%>
            <%--<span class="input"><form:input path="dob" /></span>--%>
        <%--</div>--%>
        <div class="form-buttons">
            <div class="button"><input name="submit" type="submit" value="<fmt:message key="button.search"/>" /></div>
        </div>
    </fieldset>
</form:form>
