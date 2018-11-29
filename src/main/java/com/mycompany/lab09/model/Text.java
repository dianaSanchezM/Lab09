/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab09.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2108310
 */

public class Text {
    @Id
    public String identifier;
    private String text;
    private Date date;

    public Text(String text) {
        this.text = text;
        this.date = new Date();
    }
    
    
}
