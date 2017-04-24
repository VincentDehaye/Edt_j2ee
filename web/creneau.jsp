<%@ page import="beans.CreneauEntity" %>
<%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 24/04/2017
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creneau</title>
</head>
<body>


<p>Ceci est une page générée depuis une JSP.</p>

    <table border="1">
        <tr>
            <th>Uv</th>
            <th>Horaire</th>
            <th>Salle</th>
            <th>Type</th>
            <th>Groupe</th>
            <th>Alternance</th>
        </tr>
        <%
            Object obj = request.getAttribute("listeCren");
            if(obj!=null){
                List<CreneauEntity> lu = (List<CreneauEntity>)obj;
                for(CreneauEntity u : lu){
        %>
        <tr>
            <td><%=u.getUv()%></td>
            <td><%=u.getHoraire()%></td>
            <td><%=u.getSalle()%></td>
            <td><%=u.getType()%></td>
            <td><%=u.getGroupe()%></td>
            <td><%=u.getAlternance()%></td>
        </tr>
        <%
                }
            }
        %>
    </table>


</body>
</html>
