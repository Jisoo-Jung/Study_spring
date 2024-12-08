package com.app.app.domain.file;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FileDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String fileName;
    private String filePath;
    private Long postId;
    private String createdDate;
    private String updatedDate;

    public FileVO toVO(){
        return new FileVO(id, fileName, filePath, postId, createdDate, updatedDate);
    }
}
