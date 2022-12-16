package objetos;

/**
 *
 * @author bruno
 */
public class Cliente implements Comparable{
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String instagram;
    private String email;
    private String facebook ;
    private int cartaoCredito; 

    public Cliente(String cpf, String nome, String telefone, String endereco, String instagram, String email, String facebook, int cartaoCredito) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.instagram = instagram;
        this.email = email;
        this.facebook = facebook;
        this.cartaoCredito = cartaoCredito;
    }
    
    public Cliente() {
        this.cpf = "Sem CPF";
        this.nome = "Sem Nome";
        this.telefone = "Sem telefone";
        this.endereco = "Sem Endereço";
        this.instagram = "Sem instagram";
        this.email = "Sem email";
        this.facebook = "Sem Facebook";
        this.cartaoCredito = -1;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public int getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(int cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" + 
                "cpf = " + cpf +
                ", nome = " + nome + 
                ", telefone = " + telefone + 
                ", endereco = " + endereco + 
                ", instagram = " + instagram + 
                ", email = " + email + 
                ", facebook = " + facebook + 
                ", cartaoCredito = " + cartaoCredito + 
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getNome().compareTo(((Cliente)o).getNome());
    }
    
    
}
