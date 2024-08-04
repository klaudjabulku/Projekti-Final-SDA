package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    Optional<ClientEntity> findClientEntitiesByEmail(String email);

}
