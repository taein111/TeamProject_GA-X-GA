package com.teamproject.gaxga.dto;


//import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.entity.Gabowatdago;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@ToString
public class GabowatdagoForm {

    private String title;
    private String local;
    private String thema;
    private String image;
    private String content;
    private String address;
    private String de_address;


    public Gabowatdago toEntity() {
        return new Gabowatdago(null, title, local, thema, image, content, address, de_address);
    }
}
