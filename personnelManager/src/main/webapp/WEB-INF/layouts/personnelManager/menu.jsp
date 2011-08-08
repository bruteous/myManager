<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

      <p>
        <span class="header">Personnel Management</span>
      </p>

      <p>
        <a href="addPerson.htm" title="Add Person" class="menuItem">Add Person</a>
      </p>
      <p>
        <a href="searchPerson.htm" title="Search Person" class="menuItem">Search Person</a>
      </p>
      <p>
        <a href="addRole.htm" title="Add Role" class="menuItem">Add Role</a>
      </p>
      <p>
        <a href="searchRole.htm" title="Search Role" class="menuItem">Search Role</a>
      </p>

      <!-- Creates the rounded corner on the bottom of the left menu -->
      <div class="bottomCorner">
        <img src="<c:url value="/public/images/corner_sub_br.gif"/>" alt="bottom corner" class="vBottom"/>
      </div>
