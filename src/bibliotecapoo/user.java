public class user {
    String nome;
    String cpf;
    String telefone;

    public user (String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String toString() {
        return 
        "Usuario: " + this.nome + 
        "   CPF: " + this.cpf + 
        "   Numero: " + this.telefone;
    }
}
