package inside.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String email=request.getParameter("email");
        PrintWriter out=response.getWriter();
        String sql="select permission from allowance";
        try{
            Connection con=ConEst.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            rs.next();
            String s=rs.getString(1);
            if(s.equals("permit")){
                HttpSession session=request.getSession();
                session.setAttribute("email", email);
                response.sendRedirect("booking.jsp?allow=yes");
            }else{
                out.println("<html><body>");
                out.println("<center><h2>Hair Cutter Saloon</h2>");
                out.println("<hr>");
                out.println("<br>");
                out.println("<h1>Booking is Closed</h1><br>");
                out.println("<hr><a href=index.jsp>Home</a>");
                out.println("</body></html>");
            }
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
