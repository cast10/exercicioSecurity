package cadastro.loja.Controller;

import cadastro.loja.Model.UsuarioDTO;
import cadastro.loja.Model.UsuarioModel;
import cadastro.loja.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    //Buscar todos os Usuarios//

    @GetMapping(path = "/usuario")
    public ResponseEntity<List<UsuarioDTO>> buscarUsuario(){
        return ResponseEntity.ok(usuarioService.todosUsuario());
    }

    //Buscar Usuario or ID//

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<Optional<UsuarioModel>> buscarUsuarioId(@PathVariable long id){
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    //Cadastrar Usuario//

    @PostMapping(path = "/usuario")
    public ResponseEntity <UsuarioModel> cadastrarUsuario(@RequestBody UsuarioModel cadastreUsuario){
        UsuarioModel novoUsuario = usuarioService.registrarUsuario(cadastreUsuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    //Alterar os dados do Usuario//

    @PutMapping(path = "/usuario/{id}")
    ResponseEntity<UsuarioModel>alteraUsuario (@RequestBody UsuarioModel altereUsuario, @PathVariable Long id) {
        altereUsuario.setId(id);
        return ResponseEntity.ok(usuarioService.alterarUsuario(altereUsuario));
    }

    //Deletar  Usuario//

    @DeleteMapping(path = "/usuario/{id}")
    public ResponseEntity<Void>deletarConta(@PathVariable long id){
        usuarioService.deleteUsuarioId(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
