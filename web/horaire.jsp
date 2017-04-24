<%@ page import="beans.HoraireEntity" %>

<%--
  Created by IntelliJ IDEA.
  User: Sylvain
  Date: 24/04/2017
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Horaires</title>
</head>
<body>

<p>Ceci est une page générée depuis une JSP.</p>

<%
    Object obj = request.getAttribute("listeHor");
    Object jour = request.getAttribute("jour");
    if(obj != null){
        if (jour != null){
            %> Recherche des horaires du <% out.println((String)jour);
%>
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Heure debut</th>
                    <th>Heure fin</th>
                </tr>
                <%
                    List<HoraireEntity> lu = (List<HoraireEntity>)obj;
                    for(HoraireEntity u : lu){
                %>
                <tr>
                    <td><%=u.getIdHoraire()%></td>
                    <td><%=u.getHeureDebut()%></td>
                    <td><%=u.getHeureFin()%></td>
                </tr>
                <%
                    }
                %>
            </table>

<%

        }else{
%>

            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Heure debut</th>
                    <th>Heure fin</th>
                    <th>Jour de la semaine</th>
                </tr>
                <%
                    List<HoraireEntity> lu = (List<HoraireEntity>)obj;
                    for(HoraireEntity u : lu){
                %>
                <tr>
                    <td><%=u.getIdHoraire()%></td>
                    <td><%=u.getHeureDebut()%></td>
                    <td><%=u.getHeureFin()%></td>
                    <td><%=u.getJourSemaine()%></td>
                </tr>
                <%
                    }
                %>
            </table>
<%
        }
    }
%>

</body>
</html>
