package cadastro.loja.Service;

import cadastro.loja.Model.UsuarioDTO;
import cadastro.loja.Model.UsuarioModel;
import cadastro.loja.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    ///criptografia//

    private BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }



    public List<UsuarioDTO> todosUsuario() {
        List<UsuarioModel> buscarUsuarios = usuarioRepository.findAll();
        return buscarUsuarios.stream().map(retorno1 -> new UsuarioDTO(retorno1.getNome(),retorno1.getLogin(),retorno1.getSenha())).collect(Collectors.toList());

    }

    public Optional<UsuarioModel> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel registrarUsuario(UsuarioModel usuarioModel) {
        usuarioModel.setSenha(passwordEncoder().encode(usuarioModel.getSenha()));
        return usuarioRepository.save(usuarioModel);
    }
    public UsuarioModel alterarUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }
    public void deleteUsuarioId(Long id) {
        usuarioRepository.deleteById(id);
    }




}
