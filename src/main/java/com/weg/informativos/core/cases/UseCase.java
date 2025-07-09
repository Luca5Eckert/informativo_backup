package com.weg.informativos.core.cases;

import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioCadastroDto;

public interface UseCase<INPUT, OUTPUT> {

    public OUTPUT executar(INPUT input);

}
