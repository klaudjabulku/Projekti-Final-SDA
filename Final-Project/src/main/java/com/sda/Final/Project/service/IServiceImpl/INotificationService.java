package com.sda.Final.Project.service.IServiceImpl;

import com.sda.Final.Project.dto.NotificationDTO;
import java.util.List;

public interface INotificationService {
    void save(NotificationDTO notificationDTO);
    List<NotificationDTO> findAllUser(Integer id);

    List<NotificationDTO> findAllClient(Integer id);
    void deleteByUserId (Integer id);
    void deleteByClientId(Integer id);
    void deleteAll();







}
