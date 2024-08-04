package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.service.IServiceImpl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @CrossOrigin("*")
    @PostMapping
    public void save(@RequestBody UserDTO userDTO) {
        iUserService.save(userDTO);
    }

    @PutMapping("/{email}")
    public void update(@PathVariable String email, @RequestBody UserDTO userDTO) {
        userDTO.setEmail(email);
        iUserService.update(userDTO, email);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Integer id) {
        iUserService.delete(id);
    }
    @DeleteMapping("/{email}")
    public void deleteByEmail(@PathVariable String email) {
        iUserService.deleteCurrentUser(email);
    }
    @GetMapping("/{email}")
    public UserDTO findByEmail(@PathVariable String email) {
        return iUserService.findByEmail(email);
    }
}
