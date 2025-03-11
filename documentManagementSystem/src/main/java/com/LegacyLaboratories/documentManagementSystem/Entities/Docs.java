package com.LegacyLaboratories.documentManagementSystem.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Docs{

    @Id
    private String id;
    public String customerId;
    public String LabId;
    public String path;
    public Date date;

}