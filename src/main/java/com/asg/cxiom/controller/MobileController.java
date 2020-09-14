package com.asg.cxiom.controller;

import com.asg.cxiom.model.MobileData;
import com.asg.cxiom.services.MobileService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    MobileService service;

    @RequestMapping("/")
    public String hello(){
        return "Hello mumtaz";
    }

    @RequestMapping(value = {"/search"}, produces = "application/json")
    public ResponseEntity<?> search(@RequestParam("priceEur") Optional<String> priceEur,
                                    @RequestParam("sim") Optional<String> sim,
                                    @RequestParam("announceDate") Optional<String> annouceDateYear,
                                    @RequestParam("price") Optional<String> price)
    {
        try {

            List<MobileData> searchResult;
            if (priceEur.isPresent()) {
                searchResult = service.searchByPrice(priceEur.get());
            } else if (sim.isPresent()) {
                searchResult = service.searchBySim(sim.get());
            } else if (annouceDateYear.isPresent() && price.isPresent()) {
                searchResult = service.searchByAnnouceDateByPrice(annouceDateYear.get(), price.get());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            return ResponseEntity.ok(searchResult);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
     //   return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
