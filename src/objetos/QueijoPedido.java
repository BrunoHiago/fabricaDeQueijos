package objetos;

/**
 *
 * @author bruno
 */
public class QueijoPedido {
    private int id;
    private int idPedido;
    private int idQueijo;
    private int qtd;

    public QueijoPedido(int id, int idPedido, int idQueijo, int qtd) {
        this.id = id;
        this.idPedido = idPedido;
        this.idQueijo = idQueijo;
        this.qtd = qtd;
    }
    
    public QueijoPedido() {
        this.id = -1;
        this.idPedido = -1;
        this.idQueijo = -1;
        this.qtd = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdQueijo() {
        return idQueijo;
    }

    public void setIdQueijo(int idQueijo) {
        this.idQueijo = idQueijo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "QueijoPedido{" + 
                "id = " + id + 
                ", idPedido = " + idPedido + 
                ", idQueijo = " + idQueijo + 
                ", qtd = " + qtd + 
                '}';
    }
    
    
    
}
