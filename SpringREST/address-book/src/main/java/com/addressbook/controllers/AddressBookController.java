package com.addressbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address-book")
public class AddressBookController {
    @GetMapping()
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Hello World from Spring AddressBook");
    }
}