package com.sda.Final.Project.service;
import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.mapper.ClientMapper;
import com.sda.Final.Project.repository.ClientRepository;

import com.sda.Final.Project.service.IServiceImpl.IClientService;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final ClientRepository clientRepository;

   @Override
   public void save(ClientDTO clientDTO) {
       if (!clientRepository.findClientEntitiesByEmail(clientDTO.getEmail()).isEmpty()) {
           throw new BadRequestException("This client already exists");
       }
       clientRepository.save(ClientMapper.toEntity(clientDTO));
   }

   @Override
   public void update(ClientDTO clientDTO, String email) {
       Optional<ClientEntity> clientEntity = clientRepository.findClientEntitiesByEmail(clientDTO.getEmail());
       if (clientEntity.isPresent()){
           ClientEntity clientEntityUpdate = ClientMapper.toEntityForUpdate(
                   clientEntity.get(), clientDTO
           );
           clientRepository.save(clientEntityUpdate);
       }else {
           throw new NotFoundException("Client not found!");
       }
}

    @Override
    public ClientDTO findByEmail(String email) {
    Optional<ClientEntity> clientEntity = clientRepository.findClientEntitiesByEmail(email);
    if (clientEntity.isPresent()){
        return ClientMapper.toDTO(clientEntity.get());
    }else {
        throw new NotFoundException("Client not found ");
    }
}

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(ClientMapper::toDTO).toList();
    }

    @Override
    public void deleteCurrentClient(String email) {
        Optional<ClientEntity> clientEntityOptional = clientRepository.findClientEntitiesByEmail(email);

        if (clientEntityOptional.isPresent()) {
            ClientEntity clientEntity = clientEntityOptional.get();
            clientRepository.delete(clientEntity);
        } else {
            throw new NotFoundException("Client not found with email: " + email);
        }
    }
}
