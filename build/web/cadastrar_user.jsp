<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuário</title>
    </head>
    <body bgcolor = #B0E0E6>
        <h1>Cadastrar Novo Usuário</h1>
        <form method="POST" action="CadastrarServlet">
            <p>
                <label>Nome:</label>
                <input name= \"nome\" />
            </p>
            <p>
                <label>Email:</label>
                <input type= "email" name= "email" />
            </p>
            <p>
                <label>Senha:</label>
                <input type= "password" name= "senha" />
            </p>
            <p>
                <label>CPF:</label>
                <input name= "cpf" />
            </p>
            <p>
                <label>PIS:</label>
                <input name= "pis" />
            </p>
            <p>
                <label>Rua:</label>
                <input name= "rua" />
            </p>
            <p>
                <label>Numero:</label>
                <input name= "numero" />
            </p>
            <p>
                <label>Complemento:</label>
                <input name= "complemento" />
            </p>
            <p>
                <label>Cep:</label>
                <input name= "cep" />
            </p>
            <p>
                <label>Cidade:</label>
                <input name= "cidade" />
            </p>
            <p>
                <label>Estado:</label>
                <input name= "estado" />
            </p>
            <p>
                <label>País:</label>
                <input name= "pais" />
            </p>
                <input type= "submit" value= "Salvar"/>
            </formn>
    </body>
</html>
