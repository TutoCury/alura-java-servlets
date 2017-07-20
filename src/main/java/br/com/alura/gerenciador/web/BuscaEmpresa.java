package br.com.alura.gerenciador.web;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaEmpresa implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO()
                .buscaPorSimilaridade(filtro);

        req.setAttribute("empresas", empresas);
        return "/WEB-INF/paginas/buscaEmpresa.jsp";
    }
}
