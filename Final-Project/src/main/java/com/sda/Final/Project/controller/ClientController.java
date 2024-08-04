package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.service.IServiceImpl.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private IClientService iClientService;


    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO){
        iClientService.save(clientDTO);
    }
    @PutMapping("/{email}")
    public void update(@PathVariable String email, @RequestBody ClientDTO clientDTO){
        clientDTO.setEmail(email);
        iClientService.update(clientDTO, email);
    }

    @GetMapping("/{email}")
    public  ClientDTO findByEmail(@PathVariable String email){
        return iClientService.findByEmail(email);
    }

    @GetMapping
    public List<ClientDTO> findAll(){
        return iClientService.findAll();
    }

    @DeleteMapping("/{email}")
    public  void deleteByEmail (@PathVariable String email){
        iClientService.deleteCurrentClient(email);
    }
}