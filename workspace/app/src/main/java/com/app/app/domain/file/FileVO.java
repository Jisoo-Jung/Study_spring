package com.app.app.domain.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FileVO {
    private Long id;
    private String fileName;
    private String filePath;
    private Long postId;
    private String createdDate;
    private String updatedDate;
}
