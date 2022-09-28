package servlet;

import dao.dao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuarios;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        Usuarios u = dao.buscarUserEmail(email);
            boolean loginSucesso = false;
        
            if (u != null && u.getSenha().equals(senha)) {
                loginSucesso = true;
            }
            if (loginSucesso) {
                
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", u);
                
                RequestDispatcher rd =  request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);
                
            } else {
                
                request.setAttribute("erro", "Email ou senha incorretos.");
                
                RequestDispatcher rd =  request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
                
            }
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
