public class Organizador {
    int id;
    String nome;
    String email;

    Pessoa pessoa;

    public Organizador (
        int id,
        String nome,
        String email
    ){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    public String toString() {
        return " Id: " +this.id+" Nome: "+this.nome+" Email: "+this.email;
    }









}
