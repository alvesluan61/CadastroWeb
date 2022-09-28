
<%@page import="model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Usuario</title>
    </head>
    <body bgcolor = #B0E0E6>
        <a>
            <% 
                Usuarios u = (Usuarios) session.getAttribute("usuarioLogado");
                
                if(u!= null){
                out.print(u.getNome());
                }
            %>  
            
            
        </a>
        <a href="LogoutServelet">Sair</a>
        <h1>Homepage</h1>
    </body>
</html>
