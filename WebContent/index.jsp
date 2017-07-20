<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        Bem vindo ao nosso gerenciador de empresas!<br/>

        <c:if test="${usuarioLogado!=null}">
            Você está logado como ${usuarioLogado.email}<br/>
        </c:if>

        <form action="login" method="post">
            Email: <input type="text" name="email" /><br />
            Senha: <input type="password" name="senha" /><br />
            <input type="submit" value="Login" />
        </form>

        <br /><br />

        <form action="fazTudo" method="post">
            <input type="hidden" name="tarefa" value="Logout" />
            <input type="submit" value="Logout" />
        </form>

        <br /><br />

        <form action="fazTudo" method="post">
            <input type="hidden" name="tarefa" value="NovaEmpresa" />
            Nome: <input type="text" name="nome" /><br />
            <input type="submit" value="Enviar" />
        </form>

    </body>
</html>