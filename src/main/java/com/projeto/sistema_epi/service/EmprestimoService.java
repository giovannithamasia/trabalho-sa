package com.projeto.sistema_epi.service;
import com.projeto.sistema_epi.dto.EmprestimoDto;
import com.projeto.sistema_epi.dto.EmprestimoResponseDto;
import com.projeto.sistema_epi.entity.ColaboradorEntity;
import com.projeto.sistema_epi.entity.EpiEntity;
import com.projeto.sistema_epi.entity.EmprestimoEntity;
import com.projeto.sistema_epi.repository.ColaboradorRepository;
import com.projeto.sistema_epi.repository.EmprestimoRepository;
import com.projeto.sistema_epi.repository.EpiRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class EmprestimoService {


    private final EmprestimoRepository emprestimoRepo;
    private final ColaboradorRepository colaboradorRepo;
    private final EpiRepository epiRepo;

    //create
    public void retirarEpi(@Valid EmprestimoDto emprestimoDto) {

        ColaboradorEntity colaborador = colaboradorRepo.findById(emprestimoDto.getIdColaborador())
                .orElseThrow(() -> new RuntimeException("Colaborador não existe"));

        EpiEntity epi = epiRepo.findById(emprestimoDto.getIdEpi())
                .orElseThrow(() -> new RuntimeException("EPI não existe"));

        if (!colaborador.isStatusAtivo()){
            throw new RuntimeException("Colaborador não está ativo");
        }

        if (epi.getValidade().isBefore(LocalDate.now())) {
            throw new RuntimeException("EPI com validade vencida não pode ser emprestado");
        }

        if (emprestimoRepo.existsByEpiIdEpiAndDataDevolucaoIsNull
                (emprestimoDto.getIdEpi())) {
            throw new RuntimeException("Este EPI já está emprestado e não foi devolvido ainda.");
        }

        if (emprestimoDto.getDataPrevistaDevolucao()
                .isBefore(emprestimoDto.getDataEmprestimo())) {
            throw new RuntimeException("Data prevista não pode ser anterior ao empréstimo");
        }

        EmprestimoEntity entity = new EmprestimoEntity();
        entity.setColaborador(colaborador);
        entity.setEpi(epi);
        entity.setDataEmprestimo(emprestimoDto.getDataEmprestimo());
        entity.setDataPrevistaDevolucao(emprestimoDto.getDataPrevistaDevolucao());
        entity.setStatus("ABERTO");
        entity.setObservacao(emprestimoDto.getObservacao());

        epi.setSituacao("EMPRESTADO");

        emprestimoRepo.save(entity);
        epiRepo.save(epi);
    }

    //update
    public void devolverEpi(Long idEmprestimo) {

        EmprestimoEntity emprestimoEntity = emprestimoRepo.findById(idEmprestimo)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if (emprestimoEntity.getDataDevolucao() != null) {
            throw new RuntimeException("Este empréstimo já foi devolvido");
        }

        emprestimoEntity.setDataDevolucao(LocalDate.now());
        emprestimoEntity.setStatus("DEVOLVIDO");

        EpiEntity epi = emprestimoEntity.getEpi();
        epi.setSituacao("DISPONIVEL");
        epiRepo.save(epi);

        emprestimoRepo.save(emprestimoEntity);
    }

    //read
    public List<EmprestimoResponseDto> listarEmprestimos() {

        List<EmprestimoEntity> listaEmprestimoEntity = emprestimoRepo.findAll();
        List<EmprestimoResponseDto> listaEmprestimoDto = new ArrayList<>();

        for (EmprestimoEntity e : listaEmprestimoEntity) {

            EmprestimoResponseDto emprestimoDto = new EmprestimoResponseDto();

            emprestimoDto.setIdEmprestimo(e.getIdEmprestimo());
            emprestimoDto.setNomeColaborador(e.getColaborador().getNome());
            emprestimoDto.setNomeEpi(e.getEpi().getNomeEpi());
            emprestimoDto.setDataEmprestimo(e.getDataEmprestimo());
            emprestimoDto.setDataPrevistaDevolucao(e.getDataPrevistaDevolucao());
            emprestimoDto.setDataDevolucao(e.getDataDevolucao());
            emprestimoDto.setStatus(e.getStatus());
            emprestimoDto.setObservacao(e.getObservacao());

            listaEmprestimoDto.add(emprestimoDto);
        }

        return listaEmprestimoDto;
    }
}
