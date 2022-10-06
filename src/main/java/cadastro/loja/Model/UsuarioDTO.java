package cadastro.loja.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UsuarioDTO {

    public UsuarioDTO(String nome, String login, String senha) {
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class DtoUsuariosmodel {


        private String nome;
        private String login;
        private String senha;

    }
}
