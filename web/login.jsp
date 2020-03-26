<%
    String v1="", v2="";
    Cookie ck[]=request.getCookies();
    if(ck!=null){
    for(Cookie c:ck){
        String s=c.getName();
        if(s.equals("email")){
            v1=c.getValue();
        }else if(s.equals("password")){
            v2=c.getValue();
        }
    }
    }
%>
<html>
    <head>
        <title>Hair_Cutter</title>
    </head>
    <body>
        <center>
            <h2>Hair Cutter Saloon</h2>
            <hr>
            <form action="LoginUser" method="post">
                <pre>
                    Email/UserID    <input type="email" name="email" value="<%=v1%>" required="" placeholder="Email"/><br>
                    Password        <input type="password" name="password" value="<%=v2%>" required="" placeholder="Password"/><br>
                        Save Password <input type="checkbox" name="savepwd" value="true"/><br>
                            <input type="submit" value="Login"/><br>
                            <a href="register.jsp" title="Sign-Up">New-Customer</a>
                </pre>
            </form>
            <hr>
            <a href="index.jsp">Home</a>
        </center>
    </body>
</html>
