package inside.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlockUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      PrintWriter out=response.getWriter();
      Connection con=ConEst.connect();
      try{
          
          String sql="select * from users";
          Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery(sql);
          out.println("<html><body><center><h1>Hair Cutter Saloon</h1><hr>");
          out.println("<table border=2>");
          out.println("<tr>");
          out.println("<th>Name</th>");
          out.println("<th>Password</th>");
          out.println("<th>Mobile No.</th>");
          out.println("<th>Haircut</th>");
          out.println("<th>Beardcut</th>");
          out.println("<th>Haircolor</th>");
          out.println("<th>Entry</th>");
          out.println("<th>Exit</th>");
          out.println("<th>Rate</th>");
          out.println("<th>Booking_ID</th>");
          out.println("<th>Email</th>");
          out.println("</tr>");
          
          while(rs.next()){
            out.println("<tr>");
            out.println("<td>"+rs.getString(1)+"</td>");
            out.println("<td>"+rs.getString(2)+"</td>");
            out.println("<td>"+rs.getString(3)+"</td>");
            out.println("<td>"+rs.getString(4)+"</td>");
            out.println("<td>"+rs.getString(5)+"</td>");
            out.println("<td>"+rs.getString(6)+"</td>");
            out.println("<td>"+rs.getString(7)+"</td>");
            out.println("<td>"+rs.getString(8)+"</td>");
            out.println("<td>"+rs.getString(9)+"</td>");
            out.println("<td>"+rs.getString(10)+"</td>");
            out.println("<td>"+rs.getString(11)+"</td>");
            out.println("<td><a href=BlockUserDelete?email="+rs.getString("email")+">Block</a></td>");
            out.println("</tr>");
          }
          out.println("</table>");
          out.println("<br><hr><a href=adminHome.jsp>Home</a>");
          out.println("</center></body></html>");
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
