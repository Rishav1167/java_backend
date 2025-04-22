package com.addressbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/address-book")
public class AddressBookController {
    @GetMapping()
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Hello World from Spring AddressBook");
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable int id){
        return ResponseEntity.ok("Hello World from Spring AddressBook at ID: " + id);
    }

    @PostMapping()
    public ResponseEntity<String> post(){
        return ResponseEntity.ok("Hello World from Spring AddressBook at POST");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable int id){
        return ResponseEntity.ok("Hello World from Spring AddressBook at PUT at ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return ResponseEntity.ok("Hello World from Spring AddressBook at DELETE at ID: " + id);
    }
}