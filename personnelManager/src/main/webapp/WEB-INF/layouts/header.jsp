<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Main site header : holds the img, title and top tabbed menu -->
  <div id="header">

    <!-- top rounded corner -->
    <img src='<c:url value="/public/images/corner_tl.gif"/>' alt="corner" style="float:left;" />


    <!-- Site title and subTitle -->
    <span class="title">
      <span class="white">D</span>HRMS
      <span class="subTitle">
    	Dynamic Human Resource System
      </span>
    </span>

    <!-- Menu is displayed in reverse order from how you define it (caused by float: right) -->
    <a href="index.html" title="User Administration" class="lastMenuItem">User Admin</a>
    <a href="index.html" title="Personnel Management">Personnel Management</a>
    <a href="index.html" title="Time And Leave">Time and Leave</a>
    <a href="index.html" title="home" class="active">home</a>

  </div>