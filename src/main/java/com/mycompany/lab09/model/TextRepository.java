/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab09.model;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 2108310
 */
public interface TextRepository extends MongoRepository<Text, String>{
    public Text findByIdentifier(String identifier);
}
