package Even.IFPB.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;



@Entity
@Table(name="eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_evento;

    @ManyToOne
    @JoinColumn(name="id_usuário", nullable = false)
    private Usuário usuario;

    @Column(nullable = false)
    private String título;

    @Column(nullable = false)
    private String descrição;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String local;

    @Column(nullable = false)
    private LocalTime horário;

    @Column(nullable = false)
    private String tipo_evento;

    @Column(nullable = false)
    private Long qtde_vagas;

    public Evento(){}

    public Evento(String título, String descrição, LocalDate data,
                  String local, LocalTime horário, String tipo_evento, Long qtde_vagas, Usuário usuario){

        this.título=título;
        this.descrição=descrição;
        this.data=data;
        this.horário=horário;
        this.local=local;
        this.tipo_evento=tipo_evento;
        this.qtde_vagas=qtde_vagas;
        this.usuario=usuario;
    }

    // Métodos Acessores para cada um


    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorário() {
        return horário;
    }

    public void setHorário(LocalTime horário) {
        this.horário = horário;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    public Long getQtde_vagas() {
        return qtde_vagas;
    }

    public void setQtde_vagas(Long qtde_vagas) {
        this.qtde_vagas = qtde_vagas;
    }

    public Usuário getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuário usuario) {
        this.usuario = usuario;
    }
}
