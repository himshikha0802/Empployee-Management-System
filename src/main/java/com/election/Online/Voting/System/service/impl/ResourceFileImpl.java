package com.election.Online.Voting.System.service.impl;

import com.election.Online.Voting.System.model.ResourceFile;
import com.election.Online.Voting.System.repository.ResourceFileRepository;
import com.election.Online.Voting.System.service.ResourceFileService;
import com.election.Online.Voting.System.utils.Constants;
import com.election.Online.Voting.System.utils.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Service
public class ResourceFileImpl implements ResourceFileService {
    @Autowired
    ResourceFileRepository resourceFileRepository;

    @Override
    public ResourceFile addFile(MultipartFile multipartFile, FileType fileType) {
        String originalFilename= multipartFile.getOriginalFilename();
        String filename=getFilename(originalFilename);
        String filePath=Constants.FILE_PATH+filename;
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ResourceFile resourceFile=new ResourceFile(originalFilename,filePath,fileType);
        return resourceFileRepository.save(resourceFile);
    }
    private String getFilename(String originalFilename) {
        long currentEpoch = Instant.now().toEpochMilli();
        return String.valueOf(currentEpoch).concat(".").concat(getExtension(originalFilename));

    }
    private String  getExtension(String filename){
        int i = filename.lastIndexOf('.');
        return filename.substring(i+1);
    }

    @Override
    public ResourceFile findById(int id) {
        return null;
    }
}
