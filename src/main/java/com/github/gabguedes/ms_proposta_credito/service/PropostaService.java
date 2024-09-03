package com.github.gabguedes.ms_proposta_credito.service;

import com.github.gabguedes.ms_proposta_credito.dto.PropostaDTO;
import com.github.gabguedes.ms_proposta_credito.dto.PropostaResponseDTO;
import com.github.gabguedes.ms_proposta_credito.dto.UserDTO;
import com.github.gabguedes.ms_proposta_credito.model.Proposta;
import com.github.gabguedes.ms_proposta_credito.model.User;
import com.github.gabguedes.ms_proposta_credito.repository.PropostaRepository;
import com.github.gabguedes.ms_proposta_credito.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<PropostaDTO> findAll(){
        return repository.findAll().stream().map(PropostaDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PropostaDTO findById(Long id){

        Proposta entity = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso não encontrado ID: " + id)
        );

        return new PropostaDTO(entity);

    }

    @Transactional
    public PropostaResponseDTO insert(PropostaResponseDTO dto){

        Proposta propostaEntity = new Proposta();
        User userEntity = new User();
        copyDtoToEntity(dto, userEntity, propostaEntity);
        userEntity = userRepository.save(userEntity);
        propostaEntity.setUser(userEntity);
        propostaEntity = repository.save(propostaEntity);
        return new PropostaResponseDTO(userEntity, propostaEntity);

    }

    private void copyDtoToEntity(PropostaResponseDTO dto, User userEntity, Proposta propostaEntity) {

//        userEntity.setId(dto.getIdUser());
//        propostaEntity.setId(dto.getIdProposta());

        userEntity.setNome(dto.getNome());
        userEntity.setSobrenome(dto.getSobrenome());
        userEntity.setCpf(dto.getCpf());
        userEntity.setTelefone(dto.getTelefone());
        userEntity.setRenda(dto.getRenda());

        propostaEntity.setValorSolicitado(dto.getValorSolicitado());
        propostaEntity.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        propostaEntity.setAprovado(false);


    }

}
