package conectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import objetos.Pedido;

/**
 *
 * @author bruno
 */
public class PedidoBD {
    private Connection conexao;
    
    public PedidoBD(){
        this.conexao = ConexaoBD.getConexao();
    }
    
    public void novoPedido(Pedido p){
        PreparedStatement ps_estado;
        String msg = "Insert into Pedido() values (?,?,?,?)";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(1, p.getId());
            ps_estado.setString(2, p.getCpf());
            ps_estado.setString(3, p.getData().toString());
            ps_estado.setInt(4,p.getEntrega());
            
            if(!ps_estado.execute()){
                System.out.println("Pedido inserido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Pedido nao inserido");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
    }
    
    public void removePedido(int id){
        PreparedStatement ps;
        String msg = "delete from pedido where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            if(!ps.execute()){
                System.out.println("Pedido removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Pedido nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public void removePedido(String cpf){
        PreparedStatement ps;
        String msg = "delete from pedido where cpf = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, cpf);
            
            if(!ps.execute()){
                System.out.println("Pedido removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Pedido nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public Pedido buscarPedido(int id){
        Pedido p = null;
        PreparedStatement ps;
        String msg = "select * from Pedido where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                p = new Pedido();
                p.setId(res.getInt("id"));
                p.setCpf(res.getString("cpf"));
                p.setData(LocalDate.parse(res.getString("data")));
                p.setEntrega(res.getInt("entrega"));
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return p;
    }
    
    
    public ArrayList<Pedido> buscarPedido(){
        ArrayList<Pedido> list = new ArrayList();
        PreparedStatement ps;
        String msg = "select * from Pedido";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Pedido p = new Pedido();
                
                p.setId(res.getInt("id"));
                p.setCpf(res.getString("cpf"));
                p.setData(LocalDate.parse(res.getString("data")));
                p.setEntrega(res.getInt("entrega"));
                
                list.add(p);
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return list;
    }
    
    public void editarPedido(Pedido p){
        PreparedStatement ps_estado;
        String msg = "update pedido set "
                + "cpf = ?,"
                + "data = ?,"
                + "entrega = ? "
                + "where id = ?";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(4, p.getId());
            ps_estado.setString(1, p.getCpf());
            ps_estado.setString(2, p.getData().toString());
            ps_estado.setInt(3,p.getEntrega());
            
            if(!ps_estado.execute()){
                System.out.println("Pedido editado no Banco de Dados com sucesso!");
            }else{
                System.out.println("Pedido nao editado");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public boolean isExist(int id){
        Pedido p = this.buscarPedido(id);
        
        return p != null;
    }
}
