package com.community.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.community.model.HelpRequest;

public interface HelpRepository extends MongoRepository<HelpRequest, String> {

}