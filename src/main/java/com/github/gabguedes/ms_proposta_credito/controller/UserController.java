package com.github.gabguedes.ms_proposta_credito.controller;

import com.github.gabguedes.ms_proposta_credito.dto.UserDTO;
import com.github.gabguedes.ms_proposta_credito.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<UserDTO> users = service.findAll();
        return ResponseEntity.ok(users);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable @NotNull Long id){

        UserDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserDTO dto){
        dto = service.insert(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable @NotNull Long id,
                                          @RequestBody @Valid UserDTO dto){

        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
