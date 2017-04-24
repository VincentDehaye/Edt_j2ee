<%@ page import="beans.ParticipationEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: vincent
  Date: 24/04/17
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Participation</title>
</head>
<body>

<p>Ceci est une page générée depuis une JSP.</p>

<table border="1">
    <tr>
        <th>Etu</th>
        <th>Cren</th>
    </tr>
    <%
        Object obj = request.getAttribute("listePart");
        if(obj!=null){
            List<ParticipationEntity> lp = (List<ParticipationEntity>)obj;
            for(ParticipationEntity p : lp){
    %>
    <tr>
        <td><%=p.getEtu()%></td>
        <td><%=p.getCren()%></td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>

