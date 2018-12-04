/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab09.controller;

import com.mycompany.lab09.model.Text;
import com.mycompany.lab09.services.TextServicesStub;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2108310
 */
@RestController
@RequestMapping(value= "/info")
public class TextAPIController {
    
    @Autowired
    private TextServicesStub services;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addText(@RequestBody String text){
        try{
            services.postText(text);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(TextAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
    }
    //curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/info -d 'fdsfdsfdsfds'

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getLast10Texts(){
         try{
            List<Text> ids= services.getLastNTexts();
            if (ids.size()>9){
                ids=ids.subList(ids.size()-10,ids.size());
            }
            return new ResponseEntity<>(ids,HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(TextAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
        
    }
}
