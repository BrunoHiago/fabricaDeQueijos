package objetos;

import java.time.LocalDate;

/**
 *
 * @author bruno
 */
public class Queijo {
    private int id;
    private int lote;
    private String tipo;
    private float valor;
    private float peso;
    private LocalDate dataFabricacao;

    public Queijo(int id, int lote, String tipo, float valor, float peso, LocalDate dataFabricacao) {
        this.id = id;
        this.lote = lote;
        this.tipo = tipo;
        this.valor = valor;
        this.peso = peso;
        this.dataFabricacao = dataFabricacao;
    }
    
    public Queijo() {
        this.id = -1;
        this.lote = -1;
        this.tipo = "Sem tipo";
        this.valor = -1;
        this.peso = -1;
        this.dataFabricacao = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return "Queijo{" + 
                "id = " + id + 
                ", lote = " + lote + 
                ", tipo = " + tipo + 
                ", valor = " + valor + 
                ", peso = " + peso + 
                ", dataFabricacao = " + dataFabricacao + 
                '}';
    }
    
    
}
