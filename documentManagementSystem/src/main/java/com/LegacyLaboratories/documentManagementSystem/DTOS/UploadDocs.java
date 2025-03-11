package com.LegacyLaboratories.documentManagementSystem.DTOS;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadDocs {
    @NotNull
    public String customerId;
    @NotNull
    public String labId;
    @NotNull
    MultipartFile  file;

}