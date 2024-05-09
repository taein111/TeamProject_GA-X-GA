package com.teamproject.gaxga.entity.gabojago;

import com.teamproject.gaxga.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GPid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GRid")
    private GR region;

    @ManyToOne
    @JoinColumn(name="GTid")
    private GT thema;

    @Column(name= "name")
    private String name;

    @Column(name="img")
    private String img;

    @Column
    private String state;

    @Column
    private String text;

    @Column(nullable = false)
    private Long jjimcount;

    public void increaseJjimCount() {
        this.jjimcount++;
    }
    public void decreseJjimCount() {
        this.jjimcount--;
    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userCode")
//    private User userCode;
}
