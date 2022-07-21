package com.election.Online.Voting.System.controller;

import com.election.Online.Voting.System.model.ResourceFile;
import com.election.Online.Voting.System.service.ResourceFileService;
import com.election.Online.Voting.System.utils.FileType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class ResourceFileController {
    @Autowired
    private ResourceFileService resourceFileService;

    @PostMapping
    public ResourceFile uploadFile
            (@RequestParam MultipartFile file, @RequestParam FileType fileType){
        return resourceFileService.addFile(file, fileType);
    }//in postman key must be the parameter of controller
}
