package Even.IFPB.controller;

import Even.IFPB.model.Usuário;
import Even.IFPB.repository.repositoryUsuário;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuárioController {

    @Autowired // Injeção de dependências
    private repositoryUsuário repositoryusuário;


    // Crinado os endpoints:

    // Cadastrar usuário
    @PostMapping("/cadastrarusuario")
    public void cadastrarUsuario(@RequestBody Usuário U){

        repositoryusuário.save(U);

    }

    // Listar usuários
    @GetMapping
    public List<Usuário> listarUsuarios(){

        return repositoryusuário.findAll();
    }

    // Deletar usuário pelo id
    @DeleteMapping("/delete/{id}")
    public void deleteUsuario(@PathVariable Long id){

        if(repositoryusuário.existsById(id)){

            repositoryusuário.deleteById(id);
        }
    }

    // Deletar usuário usando parâmetro
    @DeleteMapping("/remover")
    public void deleteUsuariov2(@RequestParam Long id){

        if(repositoryusuário.existsById(id)){
            repositoryusuário.deleteById(id);
        }
    }

    // Editar usuário
    @PutMapping("/editar/{id}")
    public void editarUsuario(@PathVariable Long id,
                              @RequestBody Usuário usuarioAtualizado){

        if (repositoryusuário.existsById(id)){

            usuarioAtualizado.setId_usuario(id);

            repositoryusuário.save(usuarioAtualizado);
        }
    }
}
