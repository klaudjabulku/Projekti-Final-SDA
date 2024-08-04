package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.ClientDTO;


import java.util.List;

public interface IClientService {
    void save(ClientDTO clientDTO) ;
    void update(ClientDTO clientDTO, String email);
    ClientDTO findByEmail(String email);
    List<ClientDTO> findAll();
    void deleteCurrentClient (String email);


}

