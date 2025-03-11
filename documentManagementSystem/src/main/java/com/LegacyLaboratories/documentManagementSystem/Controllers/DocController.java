package com.LegacyLaboratories.documentManagementSystem.Controllers;

import com.LegacyLaboratories.documentManagementSystem.DTOS.UploadDocs;
import com.LegacyLaboratories.documentManagementSystem.Entities.Docs;
import com.LegacyLaboratories.documentManagementSystem.Services.DocService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("api/docs")
@Validated
public class DocController {
    @Autowired
    private DocService docService;

    @PostMapping
    public boolean addDoc(@Valid @RequestParam("customerId") String customerId, @Valid @RequestParam("labId") String labId, @RequestParam("file")MultipartFile file) throws Exception {
       UploadDocs docs = new UploadDocs();
       docs.setCustomerId(customerId);
       docs.setLabId(labId);
       docs.setFile(file);

        return this.docService.uploadDocument(docs);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<byte[]> getDoc(@PathVariable String customerId) throws IOException {
     return this.docService.getFile(customerId);
    }
}
