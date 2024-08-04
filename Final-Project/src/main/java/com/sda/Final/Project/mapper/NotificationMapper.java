package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.NotificationEntity;


public class NotificationMapper {
    public static NotificationEntity toEntity(NotificationDTO notificationDTO, MeetingEntity meeting) {
        NotificationEntity notification = new NotificationEntity();
        notification.setMeeting(meeting);

        return extractFields(notificationDTO, notification);
    }

    public static NotificationEntity toEntityForUpdate(NotificationDTO notificationDTO, NotificationEntity notification) {
        return extractFields(notificationDTO, notification);
    }

    public static NotificationDTO toDTO(NotificationEntity notificationEntity) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notificationEntity.getId());
        notificationDTO.setSender(notificationEntity.getSender());
        notificationDTO.setReceiver(notificationEntity.getReceiver());
        notificationDTO.setCarbon_copy(notificationEntity.getCarbon_copy());
        notificationDTO.setBody(notificationEntity.getBody());
        notificationDTO.setSubject(notificationEntity.getSubject());
        notificationDTO.setMeeting(MeetingMapper.toDTO(notificationEntity.getMeeting()));
        return notificationDTO;
    }


    public static NotificationEntity extractFields(NotificationDTO notificationDTO, NotificationEntity notification) {
        notification.setId(notificationDTO.getId());
        notification.setSender(notificationDTO.getSender());
        notification.setReceiver(notificationDTO.getReceiver());
        notification.setCarbon_copy(notificationDTO.getCarbon_copy());
        notification.setBody(notificationDTO.getBody());
        notification.setSubject(notificationDTO.getSubject());
        return notification;
    }

}

