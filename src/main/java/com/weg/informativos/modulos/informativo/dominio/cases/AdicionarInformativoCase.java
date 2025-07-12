package com.weg.informativos.modulos.informativo.dominio.cases;

import com.weg.informativos.core.cases.UseCase;
import com.weg.informativos.modulos.informativo.aplicacao.dtos.CriarInformativoCommand;
import com.weg.informativos.modulos.informativo.aplicacao.repository.InformativoRepository;
import com.weg.informativos.modulos.informativo.dominio.InformativoEntidade;

public class AdicionarInformativoCase implements UseCase<CriarInformativoCommand, Void> {

    private final InformativoRepository informativoRepository;

    public AdicionarInformativoCase(InformativoRepository informativoRepository) {
        this.informativoRepository = informativoRepository;
    }

    //Método incompleto. Só para testes
    @Override
    public Void executar(CriarInformativoCommand informativoDto) {
        InformativoEntidade informativoEntidade = transformDtoToModel(informativoDto);
        informativoRepository.save(informativoEntidade);
        return null;
    }

    private InformativoEntidade transformDtoToModel(CriarInformativoCommand informativoDto) {
        return new InformativoEntidade(informativoDto.titulo(), informativoDto.conteudo(), informativoDto.nivelImportancia(), informativoDto.tags(), informativoDto.criadoPor());
    }
}
