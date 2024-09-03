package com.github.gabguedes.ms_proposta_credito.controller;

import com.github.gabguedes.ms_proposta_credito.dto.PropostaDTO;
import com.github.gabguedes.ms_proposta_credito.dto.PropostaResponseDTO;
import com.github.gabguedes.ms_proposta_credito.dto.UserDTO;
import com.github.gabguedes.ms_proposta_credito.service.PropostaService;
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
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService service;

    @GetMapping
    public ResponseEntity<List<PropostaDTO>> findAll(){
        List<PropostaDTO> propostas = service.findAll();
        return ResponseEntity.ok(propostas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> findById(@PathVariable @NotNull Long id){
        PropostaDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PropostaResponseDTO> insert(@RequestBody @Valid PropostaResponseDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(dto.getNome()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

}
