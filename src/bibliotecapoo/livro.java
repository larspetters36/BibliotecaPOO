import java.util.Random;

public class livro {
    String titulo;
    String autor;
    String id;
    boolean emprestado;

    private String idrandom() {
        Random random = new Random();
        int numero = random.nextInt(900000) + 100000;
        return String.valueOf(numero);
    } //sera ativo para gerar o id aleatorio do livro

    public livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = idrandom();
        this.emprestado = false;
    }

    public void emprestar(){
        emprestado = true;
    }

    public void devolver(){
        emprestado = false;
    }

    public boolean foiEmprestado(){
        return emprestado;
    }

    public String getId(){
        return id;
    }

    public String toString() {
        return "Titulo do livro: " + this.titulo +
                "   Autor: " + this.autor +
                "   ID: " + this.id;
    }
}
