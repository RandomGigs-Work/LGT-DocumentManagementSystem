package com.LegacyLaboratories.documentManagementSystem.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.io.*;
import java.util.UUID;

@Service
public class FileService {

    @Value("${upload.file.path}")
    String baseFilePath;
    String uploadFile(MultipartFile file) throws Exception
    {
        var fileName=file.getOriginalFilename();



        var extension=   fileName.substring(fileName.lastIndexOf(".")+1);

        var path=baseFilePath+"/"+UUID.randomUUID()+"."+ extension;
        File dir=new File(path);
        if(dir.createNewFile()) {
            FileOutputStream fis = new FileOutputStream(dir.getAbsoluteFile());
            fis.write(file.getBytes());
            fis.close();

        }

        return path;

    }

    public byte[] GetFile(String path) throws IOException {
        File file=new File(path);

        if(!file.exists())
            return null;
        FileInputStream fis=new FileInputStream(file);
        byte[] buffer=new byte[(int)file.length()];

        fis.read(buffer);
        fis.close();
        return buffer;

    }
}
