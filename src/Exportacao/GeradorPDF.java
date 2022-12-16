/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exportacao;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conectionBD.ClienteBD;
import conectionBD.PedidoBD;
import conectionBD.QueijoBD;
import conectionBD.QueijoPedidoBD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import objetos.Cliente;
import objetos.Pedido;
import objetos.Queijo;
import objetos.QueijoPedido;
/**
 *
 * @author bruno
 */
public class GeradorPDF {
    
    PdfPTable tableClientes;
    PdfPTable tableQueijo;
    PdfPTable tablePedido;
    PdfPTable tableQueijoPedido;
    Paragraph par_paragrafo01 = new Paragraph("Tabela De Clientes");
    Paragraph par_paragrafo02 = new Paragraph("Tabela de Queijo");
    Paragraph par_paragrafo03 = new Paragraph("Tabela de Pedido");
    Paragraph par_paragrafo04 = new Paragraph("Tabela de Queijo Pedido");
    Document documento = new Document();    
    
    public void gerarPDF() throws DocumentException, FileNotFoundException{
        
        this.gerarTabela();
        PdfWriter.getInstance(documento, new FileOutputStream("Relatorio da Fabrica de Queijos.pdf"));
        documento.open();
        documento.add(par_paragrafo01);
        documento.add(new Paragraph(" "));
        documento.add(tableClientes);
        documento.add(par_paragrafo02);
        documento.add(new Paragraph(" "));
        documento.add(tableQueijo);
        documento.add(par_paragrafo03);
        documento.add(new Paragraph(" "));
        documento.add(tablePedido);
        documento.add(par_paragrafo04);
        documento.add(new Paragraph(" "));
        documento.add(tableQueijoPedido);
        System.out.println("Pdf Criado");
        documento.close();
    }
    
    private void gerarTabela() throws DocumentException, FileNotFoundException{
        
        this.tableClientes = new PdfPTable(8);
        this.tableQueijo = new PdfPTable(6);
        this.tablePedido = new PdfPTable(4);
        this.tableQueijoPedido = new PdfPTable(4);
        
        ClienteBD cbd = new ClienteBD();
        
        ArrayList<Cliente> clientes = cbd.buscarClientes();
        
        this.tableClientes.addCell("CPF");
        this.tableClientes.addCell("Nome");
        this.tableClientes.addCell("Telefone");
        this.tableClientes.addCell("Endereço");
        this.tableClientes.addCell("Instagram");
        this.tableClientes.addCell("Email");
        this.tableClientes.addCell("Facebook");
        this.tableClientes.addCell("Cartao de Credito");
            
        for(Cliente c: clientes){
            this.tableClientes.addCell(c.getCpf());
            this.tableClientes.addCell(c.getNome());
            this.tableClientes.addCell(c.getTelefone());
            this.tableClientes.addCell(c.getEndereco());
            this.tableClientes.addCell(c.getInstagram());
            this.tableClientes.addCell(c.getEmail());
            this.tableClientes.addCell(c.getFacebook());
            this.tableClientes.addCell(String.valueOf( c.getCartaoCredito()));
            
        }
        
        QueijoBD qbd = new QueijoBD();
        
        ArrayList<Queijo> queijos = qbd.buscarQueijos();
        this.tableQueijo.addCell("ID");
        this.tableQueijo.addCell("Lote");
        this.tableQueijo.addCell("Tipo");
        this.tableQueijo.addCell("Valor");
        this.tableQueijo.addCell("Peso");
        this.tableQueijo.addCell("Data de Fabricação");
        
        for(Queijo q : queijos){
            this.tableQueijo.addCell(String.valueOf( q.getId()));
            this.tableQueijo.addCell(String.valueOf( q.getLote()));
            this.tableQueijo.addCell(q.getTipo());
            this.tableQueijo.addCell(String.valueOf( q.getValor()));
            this.tableQueijo.addCell(String.valueOf( q.getPeso()));
            this.tableQueijo.addCell( q.getDataFabricacao().toString());
            
        }
        
        PedidoBD pbd = new PedidoBD();
        
        ArrayList<Pedido> pedidos = pbd.buscarPedido();
        this.tablePedido.addCell("ID");
        this.tablePedido.addCell("CPF");
        this.tablePedido.addCell("Data");
        this.tablePedido.addCell("Prazo de Entrega");
        
        for(Pedido p: pedidos){
            this.tablePedido.addCell(String.valueOf( p.getId()));
            this.tablePedido.addCell(p.getCpf());
            this.tablePedido.addCell(p.getData().toString());
            this.tablePedido.addCell(String.valueOf(p.getEntrega()));
            
        }
        
        QueijoPedidoBD qpbd = new QueijoPedidoBD();
        
        ArrayList<QueijoPedido> qp = qpbd.buscarQueijoPedido();
        this.tableQueijoPedido.addCell("ID");
        this.tableQueijoPedido.addCell("ID do Pedido");
        this.tableQueijoPedido.addCell("ID do Queijo");
        this.tableQueijoPedido.addCell("Quantidade");
        
        for(QueijoPedido q: qp){
            this.tableQueijoPedido.addCell(String.valueOf(q.getId()));
            this.tableQueijoPedido.addCell(String.valueOf(q.getIdPedido()));
            this.tableQueijoPedido.addCell(String.valueOf(q.getIdQueijo()));
            this.tableQueijoPedido.addCell(String.valueOf(q.getQtd()));
            
        }
        
    }
}
