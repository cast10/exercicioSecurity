package cadastro.loja.Model;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
@Data
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @Column(length = 3, nullable = false)
    private Number idade;

    @Column(length = 11, nullable = false)
    private Number telefone;

    @Column(length = 15, nullable = false)
    private String login;

    @Column(length = 15, nullable = false)
    private String senha;


}
