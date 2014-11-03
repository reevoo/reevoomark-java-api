<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="reevoo" uri="http://reevoo.com/java-taglib/v1" %>

<html>
<head>
  <title>Test New Tags Page</title>
  <reevoo:cssAssets/>
</head>

<body>

<h2>Conversations</h2>
<reevoo:conversations sku="167823"/>

<h2>Conversations Spanish locale</h2>
<reevoo:conversations sku="167823" locale="es-ES"/>


<reevoo:javascriptAssets trkref="REV,CYS,EBU,PIU,HYU"/>
</body>
</html>