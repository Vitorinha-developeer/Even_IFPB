package Even.IFPB.controller;

import Even.IFPB.model.Evento;
import Even.IFPB.model.Usuário;

import Even.IFPB.repository.repositoryEvento;
import Even.IFPB.repository.repositoryUsuário;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private repositoryEvento repositoryevento;

    @Autowired
    private repositoryUsuário repositoryusuario;

    // CADASTRAR
    @PostMapping("/cadastrarevento")
    public void cadastrarEvento(@RequestBody Evento e){

        Long idUsuario = e.getUsuario().getId_usuario();

        Usuário usuario = repositoryusuario.findById(idUsuario).orElseThrow();

        // verifica se o usuário é administrador
        if(usuario.getPerfil() != Usuário.Perfil.Administrador){

            throw new RuntimeException(); // Lançando um erro!!
        }

        e.setUsuario(usuario);

        repositoryevento.save(e);
    }

    // Listar
    @GetMapping
    public List<Evento> listarEventos(){

        return repositoryevento.findAll();
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public void deleteEvento(@PathVariable Long id){

        if(repositoryevento.existsById(id)){

            repositoryevento.deleteById(id);
        }
    }

    // Delete por parâmetro
    @DeleteMapping("/remover")
    public void deleteEventov2(@RequestParam Long id){

        if(repositoryevento.existsById(id)){

            repositoryevento.deleteById(id);
        }
    }

    // Edit
    @PutMapping("/editar/{id}")
    public void editarEvento(@PathVariable Long id,
                             @RequestBody Evento eventoAtualizado){

        if(repositoryevento.existsById(id)){

            Evento eventoExistente = repositoryevento.findById(id).orElseThrow();

            Long idUsuario = eventoAtualizado.getUsuario().getId_usuario();

            Usuário usuario = repositoryusuario.findById(idUsuario).orElseThrow(() ->
                                    new RuntimeException("Usuário não encontrado"));

            eventoExistente.setUsuario(usuario);

            eventoExistente.setTítulo(eventoAtualizado.getTítulo());

            eventoExistente.setDescrição(eventoAtualizado.getDescrição());

            eventoExistente.setData(eventoAtualizado.getData());

            eventoExistente.setHorário(eventoAtualizado.getHorário());

            eventoExistente.setLocal(eventoAtualizado.getLocal());

            eventoExistente.setTipo_evento(eventoAtualizado.getTipo_evento());

            eventoExistente.setQtde_vagas(eventoAtualizado.getQtde_vagas());

            repositoryevento.save(eventoExistente);
        }
    }
}