package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.entity.UserRole;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.UserMapper;
import com.sda.Final.Project.repository.UserRepository;
import com.sda.Final.Project.service.IServiceImpl.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService, UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public void save(UserDTO userDTO) {
        if (!userRepository.findAllByEmail(userDTO.getEmail()).isEmpty()) {
            throw new BadRequestException("This user already exists");
        }
        userRepository.save(UserMapper.toEntity(userDTO));
    }

    @Override
    public void update(UserDTO userDTO, String email) {

        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(userDTO.getEmail());

        if (userEntityOptional.isPresent()) {
            UserEntity userToUpdate = userEntityOptional.get();
            UserMapper.toEntityForUpdate(userDTO, userToUpdate);
            userRepository.save(userToUpdate);
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }


    @Override
    public void delete(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("User not found");

        }
    }
    @Override
    public UserDTO findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(email);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return UserMapper.toDTO(userEntity);
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }

    @Override
    public void deleteCurrentUser(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(email);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            userRepository.delete(userEntity);
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> personOptional
                = userRepository.findUserEntityByEmail(email);
        if (personOptional.isEmpty()) {
            throw new UsernameNotFoundException("Username %s does not exist".formatted(email));
        }

        return new User(personOptional.get().getEmail(), personOptional.get().getPassword(), getAuthorities(personOptional.get().getRole()));
    }
    private Collection<? extends GrantedAuthority> getAuthorities(UserRole role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

}
