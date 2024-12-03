public class Local {
    int idLocal;
    String descricao;
    int vaga;

    public Local(
        int idLocal,
        String descricao,
        int vaga
    ){
        this.idLocal = idLocal;
        this.descricao = descricao;
        this.vaga = vaga;
    }

    public String toString(){
        return " Id: "+this.idLocal+" Descrição: "+this.descricao+" Vaga: "+this.vaga;
    }















}
