package com.zipcodewilmington.bakery.controllers;

import com.zipcodewilmington.bakery.models.Muffin;
import com.zipcodewilmington.bakery.services.MuffinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MuffinController {

    @Autowired
    private MuffinService service;



    public MuffinController(MuffinService service) {
        this.service = service;
    }

    @RequestMapping("/index")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    public ResponseEntity<Muffin> show(Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }

    @RequestMapping("/create")
    public ResponseEntity<Muffin> create(Muffin baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }

    @RequestMapping("/update")
    public ResponseEntity<Muffin> update(Long id, Muffin baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }

    @RequestMapping("destroy")
    public ResponseEntity<Boolean> destroy(Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
