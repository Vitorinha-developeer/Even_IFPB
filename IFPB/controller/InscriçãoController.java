package Even.IFPB.controller;

import Even.IFPB.model.Evento;
import Even.IFPB.model.Inscrição;
import Even.IFPB.model.Usuário;

import Even.IFPB.repository.repositoryEvento;
import Even.IFPB.repository.repositoryInscricao;
import Even.IFPB.repository.repositoryUsuário;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscriçãoController {

    @Autowired
    private repositoryInscricao repositoryincricao;

    @Autowired
    private repositoryUsuário repositoryUsuario;

    @Autowired
    private repositoryEvento repositoryEvento;

    // CADASTRAR
    @PostMapping("/cadastrarinscricao")
    public void cadastrarInscricao(@RequestBody Inscrição i){

        Long idUsuario = i.getUsuario().getId_usuario();

        Long idEvento = i.getEvento().getId_evento();

        Usuário usuario = repositoryUsuario.findById(idUsuario).orElseThrow();

        Evento evento = repositoryEvento.findById(idEvento).orElseThrow();

        i.setUsuario(usuario);

        i.setEvento(evento);


        // Verifica quantidade de vagas

        if(evento.getQtde_vagas() > 0){

            i.setStatus(Inscrição.Status.Confirmada);

            // Diminui uma vaga
            evento.setQtde_vagas(evento.getQtde_vagas() - 1);

            repositoryEvento.save(evento);

        }else{

            i.setStatus(Inscrição.Status.Pendente);
        }

        repositoryincricao.save(i);
    }

    // LISTAR
    @GetMapping
    public List<Inscrição> listarInscricoes(){

        return repositoryincricao.findAll();
    }

    // DELETAR POR PATHVARIABLE
    @DeleteMapping("/delete/{id}")
    public void deleteInscricao(@PathVariable Long id){

        if(repositoryincricao.existsById(id)){

            repositoryincricao.deleteById(id);
        }
    }

    // DELETAR POR PARAM
    @DeleteMapping("/remover")
    public void deleteInscricaov2(@RequestParam Long id){

        if(repositoryincricao.existsById(id)){

            repositoryincricao.deleteById(id);
        }
    }

    // EDITAR
    @PutMapping("/editar/{id}")
    public void editarInscricao(@PathVariable Long id,
                                @RequestBody Inscrição inscricaoAtualizada){

        if(repositoryincricao.existsById(id)){

            Inscrição inscricaoExistente = repositoryincricao.findById(id).orElseThrow();

            inscricaoExistente.setData_inscrição(inscricaoAtualizada.getData_inscrição());

            inscricaoExistente.setHorário_inscrição(inscricaoAtualizada.getHorário_inscrição());

            repositoryincricao.save(inscricaoExistente);
        }
    }
}
