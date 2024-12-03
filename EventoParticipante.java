public class EventoParticipante {
    int idEvento;
    int id;

    Evento evento;
    Participante participante;

    public EventoParticipante (
        int idEvento,
        int id
    ){
        this.idEvento=idEvento;
        this.id=id;
    }

    public String toString(){
        return " Id Evento: "+this.idEvento+" Id Participante: "+this.id;
    }
}
