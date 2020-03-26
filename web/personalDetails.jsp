<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="inside.in.ConEst"%>
<%
    String name=(String)session.getAttribute("name");
    String email=(String)session.getAttribute("email");
    
    try{
        String sql="select * from users where email=?";
        Connection con=ConEst.connect();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String phno=rs.getString("phno");
        
    
%>
<html>
    <head>
        <title>Hair-Cutter-Saloon</title>
    </head>
    <body>
    <center>
        <h2>Hair Cutter Saloon</h2>
        <hr>
        <h3>Welcome <%=name%></h3>
        <h5><strong><u>Your Details</u></strong></h5>
        <h4>Name of Customer  :- <%=name%></h4>
        <h4>Email of Customer :- <%=email%></h4>
        <h4>Mobile Number     :- <%=phno%></h4>
        <h4>Booking ID        :- <%=rs.getString("bk_id")%></h4>
        <hr>
        <table border="2">
            <tr>
                <th>Hair Cut</th>
                <th>Beard Cut</th>
                <th>Hair Color</th>
                <th>Price</th>
            </tr>
            <tr>
                <td><%=rs.getString("haircut")%></td>
                <td><%=rs.getString("beardcut")%></td>
                <td><%=rs.getString("haircolor")%></td>
                <td><%=rs.getString("rate")%></td>
            </tr>
        </table>
            <br><hr>
            <table border="2">
                <tr>
                    <th>Entry Date-Time</th>
                    <th>Exit Date-Time</th>
                </tr>
                <tr>
                    <td><%=rs.getString("entry")%></td>
                    <td><%=rs.getString("outof")%></td>
                </tr>
            </table>
                <br><hr>
                <a href="index.jsp">Home</a><br>
                <a href="KillSession">Logout</a>
    </center>
    </body>
</html>
<%
    }catch(Exception e){
        out.println(e);
    }
%>
