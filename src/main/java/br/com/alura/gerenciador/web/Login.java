package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class Login extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
        if(usuario != null) {
            writer.println("Usuário Logado: " + usuario.getEmail());
            resp.addCookie(new Cookie("usuario.logado", usuario.getEmail()));
        } else {
            writer.println("Usuário ou senha inválidos");
        }
        
        writer.println("</body>");
        writer.println("</html>");
    }
}