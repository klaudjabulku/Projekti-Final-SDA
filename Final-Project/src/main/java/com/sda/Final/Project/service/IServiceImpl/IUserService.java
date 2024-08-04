package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.UserDTO;

public interface IUserService {
    void save(UserDTO userDTO);
    void update(UserDTO userDTO, String email);
    void delete (Integer id);
    UserDTO findByEmail (String email);
    void deleteCurrentUser (String email);
}
