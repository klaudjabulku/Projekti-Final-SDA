package com.sda.Final.Project.repository;


import com.sda.Final.Project.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {
    boolean existsByMeetingId(Integer id);

    @Query("select n from NotificationEntity n where n.meeting.idUserMeeting.id = :id")
    List<NotificationEntity> findAllByMeetingIdUserMeeting_Id(Integer id);

    @Query("select n from NotificationEntity n where n.meeting.idClientMeeting.id = :id")
    List<NotificationEntity> findAllByMeetingIdClientMeeting_Id(Integer id);



    // Integer countBySender(ClientEntity clientEntity);

    //List<NotificationEntity> findByReceiverAndRead(UserEntity userEntity, boolean read);

   // List<NotificationEntity> findBySenderAndRead(ClientEntity clientEntity, boolean read);

}

