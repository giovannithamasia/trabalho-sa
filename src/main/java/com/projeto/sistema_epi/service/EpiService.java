package com.projeto.sistema_epi.service;

import com.projeto.sistema_epi.dto.EpiDto;
import com.projeto.sistema_epi.dto.EpiResponseDto;
import com.projeto.sistema_epi.entity.EpiEntity;
import com.projeto.sistema_epi.repository.EmprestimoRepository;
import com.projeto.sistema_epi.repository.EpiRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class EpiService {

    private final EpiRepository epiRepository;

    private final EmprestimoRepository emprestimoRepository;

    public void cadastrarEpi(@Valid EpiDto epiDto){

        EpiEntity epi = new EpiEntity();

        epi.setNomeEpi(epiDto.getNome());
        epi.setTipoEpi(epiDto.getTipo());
        epi.setDescricao(epiDto.getDescricao());
        epi.setSituacao(epiDto.getSituacao());
        epi.setValidade(epiDto.getValidade());
        epi.setTamanho(epiDto.getTamanho());

        epiRepository.save(epi);

    }
    public List<EpiResponseDto> listarEPIs(){
        List<EpiEntity> listaEpis = epiRepository.findAll();

        List<EpiResponseDto> listaDtos = new ArrayList<>();

        for (EpiEntity e:listaEpis){
            EpiResponseDto epi = new EpiResponseDto();

            epi.setNome(e.getNomeEpi());
            epi.setTipo(e.getTipoEpi());
            epi.setDescricao(e.getDescricao());
            epi.setValidade(e.getValidade());
            epi.setTamanho(e.getTamanho());
            epi.setSituacao(e.getSituacao());

            listaDtos.add(epi);
        }

        return listaDtos;
    }
    public void atualizarEpi(Long id,@Valid EpiDto epiDto){
        EpiEntity epi = epiRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Epi não encontrado"));

        epi.setNomeEpi(epiDto.getNome());
        epi.setTipoEpi(epiDto.getTipo());
        epi.setSituacao(epiDto.getSituacao());
        epi.setDescricao(epiDto.getDescricao());
        epi.setTamanho(epiDto.getTamanho());
        epi.setValidade(epiDto.getValidade());

        epiRepository.save(epi);

    }
    public void deletarEpi(Long id){
        epiRepository.findById(id).orElseThrow(() -> new RuntimeException("Epi não existe"));

        if (emprestimoRepository.existsByEpiIdEpi(id)){
            throw new RuntimeException("Não pode deletar epi com empréstimos ativos");
        }

        epiRepository.deleteById(id);
    }
}
