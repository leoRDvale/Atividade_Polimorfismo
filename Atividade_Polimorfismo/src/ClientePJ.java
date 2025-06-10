public class ClientePJ extends Cliente {

    private String nomeRepresentante;
    private String cnpj;

    public ClientePJ(String nome, String endereco, String telefone, String nomeRepresentante, String cnpj) {
        super(nome, endereco, telefone);
        this.nomeRepresentante = nomeRepresentante;
        this.cnpj = cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return cnpj;
    }
}
