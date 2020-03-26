<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.io.PrintWriter"%>
<%  
    
    String email=(String)session.getAttribute("email");
    String allow=(String)request.getParameter("allow");
    if(email==null){
        response.sendRedirect("login.jsp");
    }if(allow==null){
        try{
        response.sendRedirect("Authentication?email="+email+"");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "You Have Not Login yet...!!!");
        }
        
        out.println("<html><body><center><h2>Hair Cutter Saloon</h2>");
        out.println("<hr><br>");
        out.println("<h1>Booking is Closed</h1><br><hr>");
        out.println("<a href=index.jsp>Home</a>");
        out.println("</body>");
        out.println("</html>");
    }
    else if(allow.equals("yes")){
        //response.sendRedirect("Authentication?email="+email+"");
    
%>
<html>
    <head>
        <title>Hair Cutter Saloon</title>
    </head>
    <body>
    <center><h2>Booking Form</h2></center>
    <h3>Your Time:- </h3><hr> 
        <form action="Order" method="get">
            <pre>
                Hair Cut    <input type="checkbox" name="haircut" value="true"/><br>
                Beard Cut   <input type="checkbox" name="beardcut" value="true"/><br>
                Hair Color  <input type="checkbox" name="haircolor" value="true"/><br>
                    <input type="submit" value="Book"/><br>
            </pre>
        </form>
    <hr>
    <a href="index.jsp">Home</a>
    </body>
</html>
<%
    }else{
        response.sendRedirect("Authentication?email="+email+"");
    }


%>
