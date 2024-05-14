package com.teamproject.gaxga.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;

import static org.hibernate.annotations.OnDeleteAction.CASCADE;

@NoArgsConstructor
@Entity
@Getter
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_id_seq")
    @SequenceGenerator(name="file_id_seq", sequenceName = "file_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @OnDelete(action = CASCADE)
    @ManyToOne
    @JoinColumn
    private Gabowatdago gabowatdagoId;

    private String originalFileName;
    private String savedfilename;
    private String savedPath;

    @Builder
    public FileEntity(Long id, String originalFileName, String savedfilename, String savedPath) {
        this.id = id;
        this.originalFileName = originalFileName;
        this.savedfilename = savedfilename;
        this.savedPath = savedPath;
    }


}
