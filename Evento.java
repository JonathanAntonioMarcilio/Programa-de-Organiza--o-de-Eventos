public class Evento {
    int idEvento;
    String data;
    String descricao;
    int vaga;
    int id;
    int idLocal;

    Local local;
    Organizador organizador;

    public Evento(
        int idEvento,
        String data,
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

    public String toString(){
        return " ID: "+this.idEvento+" Data: "+this.data+" Descricao: "+descricao+" Quantidade de Vagas: "+vaga+" Id Organizador: "+id+" Id Local: "+idLocal;
    }
}
