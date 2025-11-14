package com.projeto.sistema_epi.service;

import com.projeto.sistema_epi.dto.ColaboradorDto;
import com.projeto.sistema_epi.dto.ColaboradorResponseDto;
import com.projeto.sistema_epi.entity.ColaboradorEntity;
import com.projeto.sistema_epi.repository.ColaboradorRepository;
import com.projeto.sistema_epi.repository.EpiRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private EpiRepository epiRepository;

    public void cadastroColaborador(@Valid ColaboradorDto colaborador) {


        if (colaboradorRepository.existsByCpf(colaborador.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }


        ColaboradorEntity colaboradorEntity = new ColaboradorEntity();

        colaboradorEntity.setNome(colaborador.getNome());
        colaboradorEntity.setCargo(colaborador.getCargo());
        colaboradorEntity.setSetor(colaborador.getSetor());
        colaboradorEntity.setDataAdmissao(colaborador.getDataAdmissao());
        colaboradorEntity.setCpf(colaborador.getCpf());
        colaboradorEntity.setStatusAtivo(colaborador.isStatusAtivo());

        colaboradorRepository.save(colaboradorEntity);
    }

    public List<ColaboradorResponseDto> listarColaboradores() {

        List<ColaboradorEntity> colaboradorEntities = colaboradorRepository.findAll();
        List<ColaboradorResponseDto> colaboradores = new ArrayList<>();

        for (ColaboradorEntity colaboradorEntity : colaboradorEntities) {
            ColaboradorResponseDto colaboradorDto = new ColaboradorResponseDto();

            colaboradorDto.setNome(colaboradorEntity.getNome());
            colaboradorDto.setCargo(colaboradorEntity.getCargo());
            colaboradorDto.setSetor(colaboradorEntity.getSetor());

            colaboradores.add(colaboradorDto);
        }

        return colaboradores;
    }

    public void atualizarColaborador(int id, @Valid ColaboradorDto colaborador) {

        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));


        if (colaboradorRepository.existsByCpfAndIdColaboradorNot(colaborador.getCpf(), id)) {
            throw new RuntimeException("CPF já cadastrado");
        }

        colaboradorEntity.setNome(colaborador.getNome());
        colaboradorEntity.setCpf(colaborador.getCpf());
        colaboradorEntity.setCargo(colaborador.getCargo());
        colaboradorEntity.setSetor(colaborador.getSetor());

        colaboradorRepository.save(colaboradorEntity);
    }

    public void deletarColaborador(int idRemover) {

        colaboradorRepository.findById(idRemover)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        colaboradorRepository.deleteById(idRemover);
    }

}
