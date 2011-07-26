<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en-AU">

<!--
 _________________________________________________________
|                                                         |
|    DESIGN + http://fullahead.org                        |
|      DATE + 2005.05.12                                  |
| COPYRIGHT + free use if this notice is kept in place    |
|_________________________________________________________|

-->

<head>

  <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
  <meta name="author" content="fullahead.org" />
  <meta name="keywords" content="reflection, fullahead, pat, OSWD, more, keywords, separated, with, commas" />
  <meta name="description" content="OSWD reflection XHTML template by fullahead.org" />

  <title><tiles:insertAttribute name="title"/></title>

  <link rel="stylesheet" type="text/css" href="<c:url value="/public/css/screen_yellow.css"/>" media="screen, tv, projection" />

</head>

<body>

<!-- Main site container -->
<div id="siteBox">

	<tiles:insertAttribute name="header"/>  

  <!-- Content begins -->
  <div id="content">
	<div id="contentLeft">
		<tiles:insertAttribute name="menu"/>
	</div>

	<!-- Right side main content -->
    <div id="contentRight">
		<tiles:insertAttribute name="content"/>
	</div>
	<!-- Footer begins -->
  	<div id="footer">
		<tiles:insertAttribute name="footer"/>
  	</div>

</div>

</body>

</html>