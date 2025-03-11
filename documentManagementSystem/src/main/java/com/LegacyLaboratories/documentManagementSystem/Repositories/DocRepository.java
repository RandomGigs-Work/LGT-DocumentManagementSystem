package com.LegacyLaboratories.documentManagementSystem.Repositories;

import com.LegacyLaboratories.documentManagementSystem.Entities.Docs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface DocRepository extends MongoRepository<Docs,String> {
    @Query("{customerId: ?0}")
    List<Docs> findByCustomerId(String customerId);
}
