package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuarios;


/**
 *
 * @author luan_
 */
public class dao {

    private static final String DB_URL = "jdbc:mysql://localhost :3306";
    private static final String DB_USER = "root";
    private static final String DB_SENHA = "";

    private static final String SELECTEMAIL_SQL = ("SELECT * FROM cadastrouser.usuario WHERE nome = ?");
    private static final String DELETE_SQL = ("DELETE FROM cadastro_user.usuario WHERE id = ?");
    private static final String ATT_SQL = ("UPDATE cadastro_user.usuario SET nome = ?, email = ? , senha = ? , cpf = ? , pis = ?, rua = ? , numero = ? , complemento = ?, cep = ?, cidade = ?, estado = ?, pais = ? WHERE ID = ?");
    private static final String SELECT_SQL = ("SELECT * FROM cadastro_user.usuario");
    private static final String INSERT_SQL = ("INSERT INTO cadastro_user.usuario (nome, email, senha, cpf, pis, rua, numero, complemento, cep, cidade, estado, pais) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

    public static ArrayList<Usuarios> buscarUser() {

        ArrayList<Usuarios> usuarios = new ArrayList();

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_SENHA);

            PreparedStatement stmt = c.prepareStatement(SELECT_SQL);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String cpf = rs.getString("cpf");
                String pis = rs.getString("pis");
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String complemento = rs.getString("complemento");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String pais = rs.getString("pais");

                Usuarios u = new Usuarios();
                u.setId(id);
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

                usuarios.add(u);

            }
            stmt.close();
            c.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return usuarios;
    }

    public static Usuarios buscarUserEmail(String nome){
        
        Usuarios u = null;
        
        try{
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            
            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_SENHA);
            
            PreparedStatement stmt = c.prepareStatement(SELECTEMAIL_SQL);
            
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String cpf = rs.getString("cpf");
                String pis = rs.getString("pis");
                String rua = rs.getString("rua");
                String numero = rs.getString("numero");
                String complemento = rs.getString("complemento");
                String cep = rs.getString("cep");
                String cidade = rs.getString("cidade");
                String estado = rs.getString("estado");
                String pais = rs.getString("pais");
                
                u = new Usuarios();
                u.setId(id);
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
            }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
    return u;
    }
    
    public static boolean criarUser(Usuarios u) {

        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_SENHA);

            PreparedStatement stmt = c.prepareStatement(INSERT_SQL);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getPis());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getNumero());
            stmt.setString(8, u.getComplemento());
            stmt.setString(9, u.getCep());
            stmt.setString(10, u.getCidade());
            stmt.setString(11, u.getEstado());
            stmt.setString(12, u.getPais());

            int linhaAfetada = stmt.executeUpdate();

            if (linhaAfetada > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public static boolean atualizarUser(Usuarios u) {

        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_SENHA);

            PreparedStatement stmt = c.prepareStatement(ATT_SQL);

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getPis());
            stmt.setString(6, u.getRua());
            stmt.setString(7, u.getNumero());
            stmt.setString(8, u.getComplemento());
            stmt.setString(9, u.getCep());
            stmt.setString(10, u.getCidade());
            stmt.setString(11, u.getEstado());
            stmt.setString(12, u.getPais());
            stmt.setInt(13, u.getId());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                sucesso = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public static boolean deletarUser(Usuarios u) {

        boolean sucesso = false;

        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);

            Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_SENHA);

            PreparedStatement stmt = c.prepareStatement(DELETE_SQL);

            stmt.setInt(1, u.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                sucesso = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }
}
