package com.LegacyLaboratories.documentManagementSystem.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HeaderService {
    static HashMap<String,String> contentTypes=new HashMap<>();
    static{
            contentTypes.put("html", "text/html");
            contentTypes.put("htm", "text/html");
            contentTypes.put("txt", "text/plain");
            contentTypes.put("csv", "text/csv");
            contentTypes.put("json", "application/json");
            contentTypes.put("xml", "application/xml");
            contentTypes.put("pdf", "application/pdf");
            contentTypes.put("doc", "application/msword");
            contentTypes.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            contentTypes.put("xls", "application/vnd.ms-excel");
            contentTypes.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            contentTypes.put("ppt", "application/vnd.ms-powerpoint");
            contentTypes.put("pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
            contentTypes.put("jpg", "image/jpeg");
            contentTypes.put("jpeg", "image/jpeg");
            contentTypes.put("png", "image/png");
            contentTypes.put("gif", "image/gif");
            contentTypes.put("bmp", "image/bmp");
            contentTypes.put("svg", "image/svg+xml");
            contentTypes.put("mp3", "audio/mpeg");
            contentTypes.put("wav", "audio/wav");
            contentTypes.put("mp4", "video/mp4");
            contentTypes.put("avi", "video/x-msvideo");
            contentTypes.put("mov", "video/quicktime");
            contentTypes.put("zip", "application/zip");
            contentTypes.put("rar", "application/x-rar-compressed");
            contentTypes.put("7z", "application/x-7z-compressed");
            contentTypes.put("tar", "application/x-tar");
        }

        String getContentType(String path)
        {
            path=path.toLowerCase();
            String extension=path.substring(path.lastIndexOf(".")+1);
            return contentTypes.get(extension);

        }
}
