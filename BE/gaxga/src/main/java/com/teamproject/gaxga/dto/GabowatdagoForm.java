package com.teamproject.gaxga.dto;


import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.User;
import lombok.*;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class GabowatdagoForm {

    private Long id;
    private String title;
    private String local;
    private String thema;
    private String image;
    private String content;
    private String address;
    private String de_address;
    private String lat;
    private String lng;
    private User userCode;

    public Gabowatdago toEntity() {
        return new Gabowatdago(id, title, local, thema, image, content, address, de_address, lat, lng, userCode);
    }

}
