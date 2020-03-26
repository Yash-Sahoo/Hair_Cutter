<%
    String email=(String)session.getAttribute("email");
    
%>
<html>
    <head>
        <title>Hair_Cutter</title>
    </head>
    <body>
        <center>
            <h2>Hair Cutter Saloon</h2>
            <hr>
<%
    if(email!=null){
%>
            <a href="KillSession">Logout</a><br><br>
<%
    }else if(email==null){
%>
            <a href="login.jsp">Login</a><br><br>
<%
    }
%>
            <a href="register.jsp">Sign-Up</a><br><br>
            <a href="booking.jsp">Place Order</a>
            
            <hr>
        </center>
    </body>
</html>
