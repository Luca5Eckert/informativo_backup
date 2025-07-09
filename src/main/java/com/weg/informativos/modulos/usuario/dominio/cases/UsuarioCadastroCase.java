package com.weg.informativos.modulos.usuario.dominio.cases;

import com.weg.informativos.core.cases.UseCase;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioCadastroDto;
import com.weg.informativos.modulos.usuario.dominio.exceptions.EmailNaoUnicoException;
import com.weg.informativos.modulos.usuario.aplicacao.exceptions.SenhaConfirmacaoDiferenteException;
import com.weg.informativos.modulos.usuario.aplicacao.repository.UsuarioRepository;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import com.weg.informativos.modulos.usuario.dominio.enums.TipoUsuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioCadastroCase implements UseCase<UsuarioCadastroDto,Void> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioCadastroCase(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Void executar(UsuarioCadastroDto usuarioCadastroDto){
        if(!verificarEmailUnico(usuarioCadastroDto.email())){
            throw new EmailNaoUnicoException("Email já usado");
        }

        if(!usuarioCadastroDto.eMesmoSenha()){
            throw new SenhaConfirmacaoDiferenteException("A senha de confirmação precisa ser identica a senha");
        }

        UsuarioEntidade usuario = dtoParaModelo(usuarioCadastroDto);

        usuarioRepository.save(usuario);

        return null;
    }

    private boolean verificarEmailUnico(String email){
        return usuarioRepository.findByEmail(email).isEmpty();
    }

    private UsuarioEntidade dtoParaModelo(UsuarioCadastroDto userCadastroDto){
        return new UsuarioEntidade(userCadastroDto.nome(), userCadastroDto.email(), userCadastroDto.senha(), TipoUsuario.NORMAL);
    }




}
