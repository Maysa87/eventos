package com.eventos.api.service;

import com.eventos.api.dto.PessoaDto;
import com.eventos.api.entity.PessoaEntity;
import com.eventos.api.mapper.PessoaMapper;
import com.eventos.api.repository.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public PessoaService(PessoaMapper pessoaMapper, PessoaRepository repository) {
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = repository;
    }
    @Transactional
    public List<PessoaDto> getPessoas() {
        return pessoaMapper.entitiesToDtos(pessoaRepository.findAllByActiveTrue());
    }
    @Transactional
    public PessoaDto save(PessoaDto pessoaDto) {
        PessoaEntity newPessoa = pessoaMapper.dtoToEntity(pessoaDto);
        newPessoa.setActive(true);
        return pessoaMapper.entityToDto(pessoaRepository.save(newPessoa));
    }
    @Transactional
    public PessoaDto update(PessoaDto pessoaDto) {
        PessoaEntity pessoa = pessoaRepository.findById(pessoaDto.getId()).orElseThrow(() -> new RuntimeException("Pessoa not found"));
        pessoa.setName(pessoaDto.getName());
        pessoa.setAge(pessoaDto.getAge());
        pessoa.setEmail(pessoaDto.getEmail());
        return pessoaMapper.entityToDto(pessoaRepository.save(pessoa));
    }
    @Transactional
    public void delete(String id) {
        pessoaRepository.deleteById(id);
    }
}
