package com.demo.niq.controllers;

import com.demo.niq.request.PersonalizedProductRequest;
import com.demo.niq.response.AppBaseResponse;
import com.demo.niq.services.DataTeamInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/internal")
public class DataTeamController {

    @Autowired
    private DataTeamInterface dataTeamInterface;

    @RequestMapping(path = "/add-personalized-product", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addPersonalizedProduct(@RequestBody PersonalizedProductRequest personalizedProductRequest) {
        dataTeamInterface.storeData(personalizedProductRequest);
        return ResponseEntity.ok(new AppBaseResponse<>());
    }
}
