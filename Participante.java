public class Participante {
    int id;
    String nome;
    String telefone;

    Pessoa pessoa;

    public Participante (
        int id,
        String nome,
        String telefone
    ){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String toString() {
        return " Id: " +this.id+" Nome: "+this.nome+" Telefone: "+this.telefone;
    }


}
