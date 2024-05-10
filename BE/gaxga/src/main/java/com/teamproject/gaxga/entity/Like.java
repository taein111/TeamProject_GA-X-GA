package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.springframework.data.util.Lazy;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Getter
@NoArgsConstructor
@Entity(name = "heart")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OnDelete(action = CASCADE)
    @ManyToOne
    @JoinColumn(name = "gabowatdago_id")
    private Gabowatdago gabowatdago;


    @Builder
    public Like(User user, Gabowatdago gabowatdago) {
        this.user = user;
        this.gabowatdago = gabowatdago;
    }

}
