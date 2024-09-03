package com.github.gabguedes.ms_proposta_credito.service;

import com.github.gabguedes.ms_proposta_credito.dto.UserDTO;
import com.github.gabguedes.ms_proposta_credito.model.User;
import com.github.gabguedes.ms_proposta_credito.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll(){

        return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id){

        User entity = repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Recurso não encontrado ID: " + id)
        );

        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserDTO dto){

        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto){

        try {
            User entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new UserDTO(entity);
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Recurso não encontrado ID: " + id);
        }
    }

    @Transactional
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Recurso não encontrado ID: " + id);
        }
        try {
            repository.deleteById(id);
        }catch (Exception e){
            throw new EntityNotFoundException("Recurso não encontrado ID: " + id);
        }
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setSobrenome(dto.getSobrenome());
        entity.setCpf(dto.getCpf());
        entity.setTelefone(dto.getTelefone());
        entity.setRenda(dto.getRenda());
    }
}
