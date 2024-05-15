package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.FileEntity;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.FileRepository;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class FileService {
    @Value("${file.dir}")
    private String fileDir;

    private final FileRepository fileRepository;

    private final GabowatdagoRepository gabowatdagoRepository;



    public Long saveFile(List<MultipartFile> files) throws IOException {
        if (files.isEmpty()) {
            return null;
        }
        // 파일들을 저장할 리스트 생성
        List<FileEntity> savedFiles = new ArrayList<>();

        // 각 파일마다 처리
        for (MultipartFile file : files) {
            //원래 파일 이름 추출
            String origName = file.getOriginalFilename();

            // 파일 이름으로 쓸 uuid 생성
            String uuid = UUID.randomUUID().toString();

            //확장자 추출(ex : .png)
            String extension = origName.substring(origName.lastIndexOf("."));

            //uuid와 확장자 결합
            String savedName = uuid + extension;

            //파일을 불러올 때 사용할 경로
            String savedPath = fileDir + savedName;

            //파일 엔티티 생성
            FileEntity fileEntity = FileEntity.builder()
                    .originalFileName(origName)
                    .savedfilename(savedName)
                    .savedPath(savedPath)
                    .build();


            //실제 로컬에 uuid를 파일명으로 저장
            file.transferTo(new File(savedPath));

            //데이터베이스에 파일 정보 저장
            FileEntity savedFile = fileRepository.save(fileEntity);

            // 리스트에 저장된 파일 엔티티 추가
            savedFiles.add(savedFile);
        }

        // 여러 파일이 있을 경우 첫 번째 파일의 아이디 반환
        return savedFiles.isEmpty() ? null : savedFiles.get(0).getId();
    }
}
