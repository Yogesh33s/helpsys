package com.community.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "requests")
public class HelpRequest {

    @Id
    private String id;

    private String title;

    private String status;
}