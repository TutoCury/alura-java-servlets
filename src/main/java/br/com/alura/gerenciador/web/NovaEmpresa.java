package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        new EmpresaDAO().adiciona(new Empresa(nome));

        req.setAttribute("nome", nome);
        return "/WEB-INF/paginas/novaEmpresa.jsp";
    }

}
