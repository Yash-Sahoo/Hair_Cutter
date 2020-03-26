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

public class Order extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

            
        PrintWriter out=response.getWriter();
        HttpSession session=request.getSession();
        String email=(String)session.getAttribute("email");
        if(email==null){
            response.sendRedirect("index.jsp");
        }
        try{
            Connection con=ConEst.connect();
            String qrc="select booked from users where email=?";
            PreparedStatement ps11=con.prepareStatement(qrc);
            ps11.setString(1, email);
            ResultSet rs=ps11.executeQuery();
            rs.next();
            int cno=rs.getInt("booked");
            if(cno==0){
                
            
                try{
                    String qr="update users set booked=1 where email=?";
                    con=ConEst.connect();
                    PreparedStatement ps10=con.prepareStatement(qr);
                    ps10.setString(1, email);
                    ps10.executeUpdate();
                }catch(Exception e){
                    out.println(e);
                }
        
                String haircut=request.getParameter("haircut");
                String beardcut=request.getParameter("beardcut");
                String haircolor=request.getParameter("haircolor");
        
                if(haircut==null){
                    haircut="false";
                }
                if(beardcut==null){
                    beardcut="false";
                }
                if(haircolor==null){
                    haircolor="false";
                }
        
        
        
        int price=0;
        
        if(haircut.equals("true") && beardcut.equals("true") && haircolor.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'5000')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='true', beardcut='true', haircolor='true' where email=?";
             price=100;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(haircut.equals("true") && beardcut.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'3500')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='true', beardcut='true', haircolor='false' where email=?";
             price=70;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(beardcut.equals("true") && haircolor.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'3000')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='false', beardcut='true', haircolor='true' where email=?";
             price=60;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(haircut.equals("true") && haircolor.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'3500')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='true', beardcut='false', haircolor='true' where email=?";
             price=70;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(haircut.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'2000')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='true', beardcut='false', haircolor='false' where email=?";
             price=40;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(beardcut.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'1500')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='false', beardcut='true', haircolor='false' where email=?";
             price=30;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }else if(haircolor.equals("true")){
             String sql1="update users set entry=(select timing from dat) where email=?";
             String sql2="update dat set timing=addtime((select timing),'1500')";
             String sql3="update users set outof=(select timing from dat) where email=?";
             String sql4="update users set rate=? where email=?";
             String sql5="update users set haircut='false', beardcut='false', haircolor='true' where email=?";
             price=30;
             try{
                con=(Connection)ConEst.connect();
                PreparedStatement ps1=con.prepareStatement(sql1);
                PreparedStatement ps2=con.prepareStatement(sql2);
                PreparedStatement ps3=con.prepareStatement(sql3);
                PreparedStatement ps4=con.prepareStatement(sql4);
                PreparedStatement ps5=con.prepareStatement(sql5);
                ps1.setString(1, email);
                ps1.executeUpdate();    
                ps2.executeUpdate();
                ps3.setString(1, email);
                ps3.executeUpdate();
                ps4.setInt(1, price);
                ps4.setString(2, email);
                ps4.executeUpdate();
                ps5.setString(1, email);
                ps5.executeUpdate();
                response.sendRedirect("personalDetails.jsp");
             }catch(Exception e){
                 out.println(e);
             }
        }
        
        }else if(cno==1){
            out.println("<html><body><center>");
            out.println("<h2>Hair Cutter Saloon</h2>");
            out.println("<hr><br>");
            out.println("<h1>You Have Already Booked Slot</h1>");
            out.println("<br><hr>");
            out.println("<a href=personalDetails.jsp>View Your Slot</a>");
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
