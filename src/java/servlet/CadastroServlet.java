
package servlet;
import dao.dao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuarios;

@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})

public class CadastroServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       RequestDispatcher rd =  request.getRequestDispatcher("cadastrar_user.jsp");
       
       rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String cpf = request.getParameter("cpf");
        String pis = request.getParameter("pis");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String pais = request.getParameter("pais");
        
        Usuarios u = new Usuarios();
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        u.setCpf(cpf);
        u.setPis(pis);
        u.setRua(rua);
        u.setNumero(numero);
        u.setComplemento(complemento);
        u.setCep(cep);
        u.setCidade(cidade);
        u.setEstado(estado);
        u.setPais(pais);
        
        boolean criado = dao.criarUser(u);
        
        if(criado){
            RequestDispatcher rd = request.getRequestDispatcher("cadastrar_sucesso.jsp");
            rd.forward(request, response);
            
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("cadastrar_erro.jsp");
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
