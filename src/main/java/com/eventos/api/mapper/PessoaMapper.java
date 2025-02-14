package com.eventos.api.mapper;

import com.eventos.api.dto.PessoaDto;
import com.eventos.api.entity.PessoaEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface PessoaMapper {
    PessoaDto entityToDto(PessoaEntity pessoa);
    PessoaEntity dtoToEntity(PessoaDto pessoa);

    List<PessoaDto> entitiesToDtos(List<PessoaEntity> pessoas);
}
