/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab09.services;

import com.mycompany.lab09.model.Text;
import com.mycompany.lab09.model.TextRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2108310
 */
@Service
public class TextServicesStub implements CommandLineRunner{
    @Autowired
    private TextRepository textRepository;
    
    public ArrayList<String> getInfo(){
        return null;
    }
    
    public void postText(String text){
        textRepository.save(new Text(text));
    }
    
    public List<Text> getLastNTexts(){
        return textRepository.findAll();
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CONECTION TO MONGODB");
    }
    
}
