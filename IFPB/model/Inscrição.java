package Even.IFPB.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "inscrições")
public class Inscrição {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inscrição;

    @Column(nullable = false)
    private LocalDate data_inscrição=LocalDate.now();

    @Column(nullable = false)
    private LocalTime horário_inscrição=LocalTime.now();

    public enum Status{
        Confirmada, Pendente
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name="id_usuario", nullable = false)
    private Usuário usuario;

    @ManyToOne
    @JoinColumn(name="id_evento", nullable = false)
    private Evento evento;

    public Inscrição(){}

    public Inscrição(Evento evento, Usuário usuario){

        this.evento=evento;
        this.usuario=usuario;
    }

    // Métodos assessores

    public Long getId_inscrição() {
        return id_inscrição;
    }

    public void setId_inscrição(Long id_inscrição) {
        this.id_inscrição = id_inscrição;
    }

    public LocalDate getData_inscrição() {
        return data_inscrição;
    }

    public void setData_inscrição(LocalDate data_inscrição) {
        this.data_inscrição = data_inscrição;
    }

    public LocalTime getHorário_inscrição() {
        return horário_inscrição;
    }

    public void setHorário_inscrição(LocalTime horário_inscrição) {
        this.horário_inscrição = horário_inscrição;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Usuário getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuário usuario) {
        this.usuario = usuario;
    }
}
