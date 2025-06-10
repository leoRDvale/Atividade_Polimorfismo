public class ClientePF extends Cliente{

    private String cpf;

    public ClientePF(String nome, String endereco, String telefone, String cpf) {
        super(nome, endereco, telefone);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public void incrementarTotalEmprestimos() {
        if(this.getTotalEmprestimos() <= 0) {
            super.incrementarTotalEmprestimos();
        }
    }
}
