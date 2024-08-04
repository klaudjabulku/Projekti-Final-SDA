package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.SocialMediaDTO;

import java.util.List;

public interface ISocialMediaService {

    void save(SocialMediaDTO socialMediaDTO) ;

    void update(SocialMediaDTO socialMediaDTO);
    SocialMediaDTO findById(Integer id);
    List<SocialMediaDTO> findAll();
    void delete (Integer id);



}
