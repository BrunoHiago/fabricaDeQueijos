package conectionBD;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.QueijoPedido;

/**
 *
 * @author bruno
 */
public class QueijoPedidoBD {
    private Connection conexao;
    
    public QueijoPedidoBD(){
        this.conexao = ConexaoBD.getConexao();
    }
    
    public void novoQueijoPedido(QueijoPedido p){
        PreparedStatement ps_estado;
        String msg = "Insert into QueijoPedido() values (?,?,?,?)";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(1, p.getId());
            ps_estado.setInt(2, p.getIdPedido());
            ps_estado.setInt(3, p.getIdQueijo());
            ps_estado.setInt(4,p.getQtd());
            
            if(!ps_estado.execute()){
                System.out.println("Queijo Pedido inserido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo Pedido nao inserido");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
    }
    
    public void removeQueijoPedido(int id){
        PreparedStatement ps;
        String msg = "delete from queijoPedido where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            if(!ps.execute()){
                System.out.println("Queijo Pedido removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo Pedido nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public void removeQueijoPedido_IdPedido(int idPedido){
        PreparedStatement ps;
        String msg = "delete from queijoPedido where idPedido = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, idPedido);
            
            if(!ps.execute()){
                System.out.println("Queijo Pedido removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo Pedido nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public QueijoPedido buscarQueijoPedido(int id){
        QueijoPedido p = null;
        PreparedStatement ps;
        String msg = "select * from QueijoPedido where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                p = new QueijoPedido();
                p.setId(res.getInt("id"));
                p.setIdPedido(res.getInt("idPedido"));
                p.setIdQueijo(res.getInt("idQueijo"));
                p.setQtd(res.getInt("Qtd"));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return p;
    }
    
    
    public ArrayList<QueijoPedido> buscarQueijoPedido(){
        ArrayList<QueijoPedido> list = new ArrayList();
        PreparedStatement ps;
        String msg = "select * from QueijoPedido";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                QueijoPedido p = new QueijoPedido();
                
                p.setId(res.getInt("id"));
                p.setIdPedido(res.getInt("idPedido"));
                p.setIdQueijo(res.getInt("idQueijo"));
                p.setQtd(res.getInt("Qtd"));
                
                list.add(p);
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return list;
    }
    
    public void editarQueijoPedido(QueijoPedido p){
        PreparedStatement ps_estado;
        String msg = "update queijopedido set "
                + "idPedido = ?,"
                + "idQueijo = ?,"
                + "qtd = ? "
                + "where id = ?";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(4, p.getId());
            ps_estado.setInt(1, p.getIdPedido());
            ps_estado.setInt(2, p.getIdQueijo());
            ps_estado.setInt(3,p.getQtd());
            
            if(!ps_estado.execute()){
                System.out.println("Queijo Pedido editado no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo Pedido nao editado");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public boolean isExist(int id){
        QueijoPedido q = this.buscarQueijoPedido(id);
        
        return q != null;
    }
}
