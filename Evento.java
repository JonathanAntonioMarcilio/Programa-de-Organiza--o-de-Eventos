public class Evento {
    int idEvento;
    int data;
    String descricao;
    int vaga;
    int id;
    int idLocal;

    Local local;
    Organizador organizador;

    public Evento(
        int idEvento,
        int data,
        String descricao,
        int vaga,
        int id,
        int idLocal
    ){
        this.idEvento = idEvento;
        this.data = data;
        this.descricao = descricao;
        this.vaga = vaga;
        this.id = id;
        this.idLocal = idLocal;
    }

    public String toString() {
        return "Id: "+this.idEvento+" Data: "+this.data+" Descrição: "+this.descricao+" Vagas: "+this.vaga+" Id do Organizador: "+this.id+" Id Local: "+idLocal;
    }
}
