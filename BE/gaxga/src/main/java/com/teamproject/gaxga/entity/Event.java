package com.teamproject.gaxga.entity;

import java.time.LocalDateTime;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Event extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name="event_id_seq", sequenceName = "event_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "ga_id")
    private String gaId;

    @Column(name = "start_date")
    private LocalDateTime startDate;


    @Column(updatable = false,name = "end_date")
    private LocalDateTime endDate;

    @CreatedDate
    @Column(updatable = false, name = "reg_date")
    private LocalDateTime regDate;

    @JoinColumn(name ="like_count")
    private Integer likeCount = 0;

    @Column(updatable = false, name = "event_flag")
    private Integer eventFlag = 0;

//    public LocalDateTime getRegDate() {
//        return super.getRegDate();
//    }

    // setEventFlag 메서드
    public void setEventFlag(LocalDateTime startDate, LocalDateTime endDate) {
        if (regDate != null && startDate != null && endDate != null) {
            if(regDate.isEqual(startDate) || (regDate.isAfter(startDate) && regDate.isBefore(endDate))) {
                eventFlag = 1;
        } else {
                eventFlag= 0;
        }
    } else {
            eventFlag = 0;
    }
}
}
