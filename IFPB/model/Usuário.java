package Even.IFPB.model;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class Usuário {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false)
    private String nome;

    private String cpf;

    @Column (nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public enum Perfil{
        Participante, Administrador
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Perfil perfil;

    public Usuário() {}

    public Usuário(String nome, String cpf, String email, String senha, Perfil perfil) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    // Métodos adicionais


    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

