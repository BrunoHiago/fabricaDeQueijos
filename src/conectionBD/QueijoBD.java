package conectionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Queijo;

/**
 *
 * @author bruno
 */
public class QueijoBD {
    private Connection conexao;
    
    public QueijoBD(){
        this.conexao = ConexaoBD.getConexao();
    }
    
    public void novoQueijo(Queijo q){
        PreparedStatement ps_estado;
        String msg = "Insert into Queijo() values (?,?,?,?,?,?)";
         
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(1, q.getId());
            ps_estado.setInt(2, q.getLote());
            ps_estado.setString(3, q.getTipo());
            ps_estado.setFloat(4,q.getValor());
            ps_estado.setFloat(5, q.getPeso());
            ps_estado.setDate(6, java.sql.Date.valueOf(q.getDataFabricacao()));
           
            if(ps_estado.execute()){
                System.out.println("Queijo inserido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo nao inserido");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
    }
    
    public void removeQueijo(int id){
        PreparedStatement ps;
        String msg = "delete from queijo where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            if(!ps.execute()){
                System.out.println("Queijo removido no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo nao removido");
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public Queijo buscarQueijo(int id){
        Queijo q = null;
        PreparedStatement ps;
        String msg = "select * from Queijo where id = ?";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                q = new Queijo();
                q.setId(res.getInt("id"));
                q.setLote(res.getInt("lote"));
                q.setTipo(res.getString("tipo"));
                q.setValor(res.getFloat("valor"));
                q.setPeso(res.getFloat("peso"));
                q.setDataFabricacao(res.getDate("dataFabricacao").toLocalDate());
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return q;
    }
    
    
    public ArrayList<Queijo> buscarQueijos(){
        ArrayList<Queijo> list = new ArrayList();
        PreparedStatement ps;
        String msg = "select * from Queijo";
        
        try {
            ps = this.conexao.prepareStatement(msg);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                Queijo q = new Queijo();
                q.setId(res.getInt("id"));
                q.setLote(res.getInt("lote"));
                q.setTipo(res.getString("tipo"));
                q.setValor(res.getFloat("valor"));
                q.setPeso(res.getFloat("peso"));
                q.setDataFabricacao(res.getDate("dataFabricacao").toLocalDate());
                
                list.add(q);
            }
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
        
        return list;
    }
    
    public void editarQueijo(Queijo q){
        PreparedStatement ps_estado;
        String msg = "update queijo set "
                + "lote = ?, "
                + "tipo = ?, "
                + "valor = ?, "
                + "peso = ?, "
                + "dataFabricacao = ? "
                + "where id = ?";
        
        try {
            ps_estado = this.conexao.prepareStatement(msg);
            
            ps_estado.setInt(6, q.getId());
            ps_estado.setInt(1, q.getLote());
            ps_estado.setString(2, q.getTipo());
            ps_estado.setFloat(3,q.getValor());
            ps_estado.setFloat(4, q.getPeso());
            ps_estado.setDate(5, java.sql.Date.valueOf(q.getDataFabricacao()));
            
            if(!ps_estado.execute()){
                System.out.println("Queijo editado no Banco de Dados com sucesso!");
            }else{
                System.out.println("Queijo nao editado");
            }
            
            ps_estado.close();
        } catch (SQLException ex) {
            System.out.println("Erro na Conexao com BD: "+ex);
        }
    }
    
    public boolean isExist(int id){
        Queijo q = this.buscarQueijo(id);
        
        return q != null;
    }
}
