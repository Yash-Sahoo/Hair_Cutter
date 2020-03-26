package inside.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
        PrintWriter out=response.getWriter();
        Connection con=(Connection)ConEst.connect();
        String sql="select * from users where email=? and password=?";
        String save=request.getParameter("savepwd");
        try{
            
            if(email.equals("admin@gmail.com") && password.equals("admin")){
                HttpSession session=request.getSession();
                session.setAttribute("email", email);
                    response.sendRedirect("adminHome.jsp");
            }
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                
                if(save!=null){
                    Cookie c1=new Cookie("email",email);
                    Cookie c2=new Cookie("password",password);
                    c1.setMaxAge(1000);
                    c2.setMaxAge(1000);
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                rs.beforeFirst();;
                rs.next();
                HttpSession session=request.getSession();
                session.setAttribute("name", rs.getString("name"));
                response.sendRedirect("Authentication?email="+email+"");
            }else{
                out.println("<html><body>");
                out.println("<h2>Invalid Credentials Entered...!!!</h2>");
                out.println("<hr><br>");
                out.println("<a href=index.jsp>Home</a></body></html>");
            }
            ps.close();
            con.close();
        }catch(Exception e){
            out.println(e);
        }
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
