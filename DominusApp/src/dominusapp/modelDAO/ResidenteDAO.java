/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominusapp.modelDAO;

import dominusapp.modelDomain.Residente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class ResidenteDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean inserir(Residente residente){
        String sql = "INSERT INTO residente(nome, cpf, email, nascimento, blocoApt, numeroApt, senha) "
                + "VALUES(?,?,?,?,?,?,?)";
         try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, residente.getNome());
            stmt.setString(2, residente.getCpf());
            stmt.setString(3, residente.getEmail());
            stmt.setDate(4, Date.valueOf(residente.getDataNascimento()));
            stmt.setString(5, residente.getBlocoApt());
            stmt.setInt(6, residente.getNumeroApt());
            stmt.setString(7, residente.getSenha());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ResidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Residente verificar(String email, String senha) throws SQLException{
        String sql = "SELECT * FROM residente "
                + "WHERE email = ? and senha = ? ";
        Residente residenteResultado = new Residente();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                residenteResultado.setCdResidente(resultado.getInt("cdResidente"));
                residenteResultado.setNome(resultado.getString("nome"));
                residenteResultado.setCpf(resultado.getString("cpf"));
                residenteResultado.setEmail(resultado.getString("email"));
                residenteResultado.setDataNascimento(resultado.getDate("nascimento").toLocalDate());
                residenteResultado.setBlocoApt(resultado.getString("blocoApt"));
                residenteResultado.setNumeroApt(resultado.getInt("numeroApt"));
                residenteResultado.setSenha(resultado.getString("senha"));
            }
        }catch(SQLException ex) {
            Logger.getLogger(ResidenteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return residenteResultado;
    }
}
