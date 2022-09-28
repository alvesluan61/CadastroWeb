<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String erro = (String) request.getAttribute("erro");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body bgcolor = #B0E0E6>
        <h1>Realize o login</h1>
        <form method = "POST" action="LoginServlet">
            <p>
                <label>Email: </label>
                <input type="email" name="email" />    
            </p>
            <p>
                <label>Senha: </label>
                <input type="password" name="senha" />
            </p>
            <input type="submit" value="Login"/>
            <p><%
                if (erro != null){
                out.print(erro);
                }
                %></p>
        </form>
    </body>
</html>
