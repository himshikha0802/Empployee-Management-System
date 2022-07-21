package com.election.Online.Voting.System.service;

import com.election.Online.Voting.System.model.ResourceFile;
import com.election.Online.Voting.System.utils.FileType;
import org.springframework.web.multipart.MultipartFile;

public interface ResourceFileService {
    ResourceFile addFile(MultipartFile multipartFile,
                         FileType fileType);

    ResourceFile findById(int id);
}
