package com.LegacyLaboratories.documentManagementSystem.Services;

import com.LegacyLaboratories.documentManagementSystem.DTOS.UploadDocs;
import com.LegacyLaboratories.documentManagementSystem.Entities.Docs;
import com.LegacyLaboratories.documentManagementSystem.Repositories.DocRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;
    @Autowired
    private FileService fileService;
    @Autowired
    private HeaderService headerService;

    public boolean uploadDocument(UploadDocs docs) throws Exception {
        Docs newDoc= new Docs();
        newDoc.setCustomerId(docs.getCustomerId().toUpperCase());
        newDoc.setPath(this.fileService.uploadFile(docs.getFile()));
        newDoc.setLabId(docs.getLabId().toUpperCase());
        newDoc.setDate(new Date());
        docRepository.save(newDoc);
        return true;
    }

    public ResponseEntity<byte[]> getFile(String customerId) throws IOException {
        List<Docs> docs=this.docRepository.findByCustomerId(customerId.toUpperCase());
        docs.sort((b,a)->a.getDate().compareTo(b.getDate()));
        if(!docs.isEmpty()) {
           String path=docs.getFirst().getPath();
           byte[] content= this.fileService.GetFile(path);
            HttpHeaders headers = new HttpHeaders();

          return ResponseEntity.ok().contentType(MediaType.parseMediaType(headerService.getContentType(path))).contentLength(content.length).body(content);

        }
        return null;

    }
}
