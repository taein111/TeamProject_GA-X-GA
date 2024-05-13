package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;

import java.time.LocalDateTime;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Gabowatdago extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gabowatdago_id_seq")
    @SequenceGenerator(name="gabowatdago_id_seq", sequenceName = "gabowatdago_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column
    private String title;
    @Column
    private String gaId;
    @Column
    private String local;
    @Column
    private String thema;
    @Column
    private String image;
    @Column
    private String content;
    @Column
    private String address;
    @Column
    private String de_address;
    @Column
    private String lat;
    @Column
    private String lng;

    @ManyToOne
    @JoinColumn(name = "userCode")
    private User userCode;

    @Column
    private Integer likeCount;


    public LocalDateTime getRegDate() {
        return super.getRegDate();
    }

    //수정할 내용이 있는 경우에만 동작하는 메서드
    public void patch(Gabowatdago gabowatdago) {
        if(gabowatdago.title != null)
            this.title = gabowatdago.title;
        if(gabowatdago.local != null)
            this.local = gabowatdago.local;
        if (gabowatdago.thema != null)
            this.thema = gabowatdago.thema;
        if (gabowatdago.image != null)
            this.image = gabowatdago.image;
        if (gabowatdago.content != null)
            this.content = gabowatdago.content;
        if (gabowatdago.address != null)
            this.address = gabowatdago.address;
        if (gabowatdago.de_address != null)
            this.de_address = gabowatdago.de_address;
        if (gabowatdago.lat != null)
            this.lat = gabowatdago.lat;
        if (gabowatdago.lng != null)
            this.lng = gabowatdago.lng;
    }

    public void likeCountAdd() {
        this.likeCount = likeCount + 1;
    }

    public void likeCountDelete() {
        this.likeCount = likeCount - 1;
    }



}
