package com.example.controller;

import com.example.service.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversionController {

    private final ConversionService service;

    ConversionController(ConversionService service){
        this.service = service;
    }

    /**
     * Controller method to call service conversion method.
     *
     * @param sourceUnit
     * @param targetUnit
     * @return
     */
    @GetMapping ("/amphora/v1/convert")
    public Double doConversion (@RequestParam String sourceUnit,
                                @RequestParam String targetUnit,
                                @RequestParam Double sourceAmount){
        if(sourceUnit.equals(targetUnit))
            throw new IllegalArgumentException("Source and target units cannot be same");
        return service.doConversion(sourceUnit, targetUnit, sourceAmount);
    }
}
