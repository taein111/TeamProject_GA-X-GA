package com.teamproject.gaxga.entity.gabojago;

import com.teamproject.gaxga.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "jjim")
@Getter
@NoArgsConstructor
public class Jjim {
    @Id
    @GeneratedValue
    @Column(name="Jjim_id")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="Gpid")
    private GP gpid;

    @Builder
    public Jjim(GP gp, User user) {
        this.gpid = gp;
        this.user = user;
    }
}
