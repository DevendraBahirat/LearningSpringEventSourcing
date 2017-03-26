/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Devendra Bahirat
 */
//@RestController
public class VersionController {
    //@RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String version() {
        return "1.0.0";
    }
}
