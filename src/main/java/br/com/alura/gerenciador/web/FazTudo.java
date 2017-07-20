package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/fazTudo"})
public class FazTudo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String tarefa = req.getParameter("tarefa");
        
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não informada");
        }

        String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;

        try {
            Class type = Class.forName(nomeDaClasse);
            Tarefa instancia = (Tarefa) type.newInstance();
            String pagina = instancia.executa(req, resp);
            req.getRequestDispatcher(pagina).forward(req, resp);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

}
