package objetos;

import java.time.LocalDate;

/**
 *
 * @author bruno
 */
public class Pedido {
    private int id;
    private String cpf;
    private LocalDate data;
    private int entrega;

    public Pedido(int id, String cpf, LocalDate data, int entrega) {
        this.id = id;
        this.cpf = cpf;
        this.data = data;
        this.entrega = entrega;
    }
    
    public Pedido() {
        this.id = -1;
        this.cpf = "Sem CPF";
        this.data = LocalDate.now();
        this.entrega = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getEntrega() {
        return entrega;
    }

    public void setEntrega(int entrega) {
        this.entrega = entrega;
    }

    @Override
    public String toString() {
        return "Pedido{" + 
                "id = " + id + 
                ", cpf = " + cpf + 
                ", data = " + data + 
                ", entrega = " + entrega + 
                '}';
    }
    
    
}
