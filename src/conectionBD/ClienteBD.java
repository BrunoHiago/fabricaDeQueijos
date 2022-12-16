package conectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import objetos.Cliente;
/**
 *
 * @author bruno
 */
public class ClienteBD {
    private Connection conexao;
    
    public ClienteBD(){
        this.conexao = ConexaoBD.getConexao();
    }
    
    public void novoCliente(Cliente c){
        PreparedStatement ps_estado;
        String msg = "Insert into cliente() values (?,?,?,?,?,?,?,?)";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setString(1, c.getCpf());
            ps_estado.setString(2, c.getNome());
            ps_estado.setString(3, c.getTelefone());
            ps_estado.setString(4,c.getEndereco());
            ps_estado.setString(5, c.getInstagram());
            ps_estado.setString(6, c.getEmail());
            ps_estado.setString(7, c.getFacebook());
            ps_estado.setInt(8, c.getCartaoCredito());
            
            if(!ps_estado.execute()){
                System.out.println("Cliente inserido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Cliente nao inserido");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
    }
    
    public void removeCliente(String cpf){
        PreparedStatement ps;
        String msg = "delete from cliente where cpf = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, cpf);
            
            if(!ps.execute()){
                System.out.println("Cliente removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Cliente nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public void removeClienteNome(String nome){
        PreparedStatement ps;
        String msg = "delete from cliente where nome = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, nome);
            
            if(!ps.execute()){
                System.out.println("Cliente removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Cliente nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public Cliente buscarCliente(String cpf){
        Cliente c = null;
        PreparedStatement ps;
        String msg = "select * from Cliente where cpf = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, cpf);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                c = new Cliente();
                c.setCpf(res.getString("cpf"));
                c.setNome(res.getString("nome"));
                c.setTelefone(res.getString("telefone"));
                c.setEndereco(res.getString("endereco"));
                c.setInstagram(res.getString("instagram"));
                c.setEmail(res.getString("email"));
                c.setFacebook(res.getString("facebook"));
                c.setCartaoCredito(res.getInt("cartaoCredito"));
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return c;
    }
    
    public Cliente buscarClienteNome(String nome){
        Cliente c = null;
        PreparedStatement ps;
        String msg = "select * from Cliente where nome = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, nome);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                c = new Cliente();
                c.setCpf(res.getString("cpf"));
                c.setNome(res.getString("nome"));
                c.setTelefone(res.getString("telefone"));
                c.setEndereco(res.getString("endereco"));
                c.setInstagram(res.getString("instagram"));
                c.setEmail(res.getString("email"));
                c.setFacebook(res.getString("facebook"));
                c.setCartaoCredito(res.getInt("cartaoCredito"));
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return c;
    }
    
    public ArrayList<Cliente> buscarClientes(){
        ArrayList<Cliente> list = new ArrayList();
        PreparedStatement ps;
        String msg = "select * from Cliente";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Cliente c = new Cliente();
                c.setCpf(res.getString("cpf"));
                c.setNome(res.getString("nome"));
                c.setTelefone(res.getString("telefone"));
                c.setEndereco(res.getString("endereco"));
                c.setInstagram(res.getString("instagram"));
                c.setEmail(res.getString("email"));
                c.setFacebook(res.getString("facebook"));
                c.setCartaoCredito(res.getInt("cartaoCredito"));
                
                list.add(c);
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return list;
    }
    
    public void editarCliente(Cliente c){
        PreparedStatement ps_estado;
        String msg = "update cliente set nome = ?,"
                + "telefone = ?,"
                + "endereco = ?,"
                + "instagram = ?,"
                + "email = ?,"
                + "facebook = ?,"
                + "cartaoCredito = ? "
                + "where cpf = ?";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            
            ps_estado.setString(1, c.getNome());
            ps_estado.setString(2, c.getTelefone());
            ps_estado.setString(3,c.getEndereco());
            ps_estado.setString(4, c.getInstagram());
            ps_estado.setString(5, c.getEmail());
            ps_estado.setString(6, c.getFacebook());
            ps_estado.setInt(7, c.getCartaoCredito());
            ps_estado.setString(8, c.getCpf());
            
            if(!ps_estado.execute()){
                System.out.println("Cliente editado no Banco de Dados com sucesso!");
            }else{
                System.out.println("Cliente nao editado");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public boolean isExist(String cpf){
        Cliente c = this.buscarCliente(cpf);
        
        return c != null;
    }
}
