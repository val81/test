package Controlleur;

import Modele.Customer;
import Modele.DAO;
import Modele.DataSourceFactory;
import Modele.IDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Entry", urlPatterns = {"/Entry"})
public class Entry extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        IDAO dao = new DAO(DataSourceFactory.getDataSource());
        HttpSession userSession = request.getSession(true);
        
        String action = request.getParameter("action");
        
        if (action != null && action.equals("Connexion")) {
            String login = request.getParameter("login");
            String password = request.getParameter("mdp");
            
            User user = null;
            
            if (login != null && password != null) {
                if (login.equals("admin") && password.equals("admin")) {
                    user = new User(null);
                } else {
                    try {
                        Customer customer = dao.login(login, password);
                        if (customer != null)
                            user = new User(customer);
                    } catch(NumberFormatException e) {}
                }
            }
            
            if (user != null)
                userSession.setAttribute("user", user);
            else
                request.setAttribute("erreurAut", "Identifiants incorrects !");
        }
        
        User user = (User) userSession.getAttribute("user");
        
        if (user != null) {
            if (user.isAdministrator())
                response.sendRedirect(request.getContextPath() + "/AdminPage");
            else
                response.sendRedirect(request.getContextPath() + "/EditClientData");
        } else {
            request.getRequestDispatcher("/views/Connexion.jsp").forward(request, response);
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
