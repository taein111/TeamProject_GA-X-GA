package com.teamproject.gaxga.dto;


import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class GabowatdagoForm {

    private Long id;
    private String title;
    private String gaId;
    private String local;
    private String thema;
    private List<MultipartFile> image;
    private String content;
    private String address;
    private String de_address;
    private String lat;
    private String lng;
    private User userCode;
    private Integer likeCount;



    public Gabowatdago toEntity() {
        return new Gabowatdago(id, title, gaId, local, thema, image.toString(), content, address, de_address, lat, lng, userCode, likeCount);
    }

}
