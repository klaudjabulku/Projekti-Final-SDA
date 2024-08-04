package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.MeetingDTO;

import java.util.List;

public interface iMeetingService {

    void save(MeetingDTO meetingDTO);
    void update(MeetingDTO meetingDTO, Integer id);
    MeetingDTO findById(Integer id);
    List<MeetingDTO> findAll();
    void delete (Integer id);


}
