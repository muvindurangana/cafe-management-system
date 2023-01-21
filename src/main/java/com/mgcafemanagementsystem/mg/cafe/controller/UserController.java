package com.mgcafemanagementsystem.mg.cafe.controller;

import com.mgcafemanagementsystem.mg.cafe.service.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/v1/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requestMap) {
        try {
            userService.signUp(requestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
        // return new ResponseEntity<String>({}, HttpStatus.ACCEPTED);
    }
}
