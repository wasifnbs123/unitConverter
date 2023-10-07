package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    public Double doConversion(String sourceUnit, String targetUnit, Double sourceAmount){

        Double targetAmount = 0.0;
        switch (sourceUnit) {
            case "BBL":
                if (targetUnit.equals("MT")) {
                    targetAmount = sourceAmount / 7.6;
                } else if (targetUnit.equals("KG")) {
                    sourceAmount = sourceAmount / 7.6;
                    targetAmount = sourceAmount * 1000;
                } else if (targetUnit.equals("LB")) {
                    sourceAmount = sourceAmount / 7.6;
                    targetAmount = sourceAmount * 2204.62;
                } else{
                    throw new IllegalArgumentException("Invalid target unit: " + targetUnit);
                }
                break;
            case "MT":
                if (targetUnit.equals("BBL")) {
                    targetAmount = sourceAmount * 7.6;
                } else if (targetUnit.equals("KG")) {
                    targetAmount = sourceAmount * 1000;
                } else if (targetUnit.equals("LB")) {
                    targetAmount = sourceAmount * 2204.62;
                } else{
                    throw new IllegalArgumentException("Invalid target unit: " + targetUnit);
                }
                break;
            case "KG":
                if (targetUnit.equals("BBL")) {
                    sourceAmount = sourceAmount / 1000;
                    targetAmount = sourceAmount * 7.6;
                } else if (targetUnit.equals("MT")) {
                    targetAmount = sourceAmount / 1000;
                } else if (targetUnit.equals("LB")) {
                    targetAmount = sourceAmount * 2.204623;
                } else{
                    throw new IllegalArgumentException("Invalid target unit: " + targetUnit);
                }
                break;
            case "LB":
                if (targetUnit.equals("BBL")) {
                    sourceAmount = sourceAmount / 2204.62;
                    targetAmount = sourceAmount * 7.6;
                } else if (targetUnit.equals("MT")) {
                    targetAmount = sourceAmount / 2204.62;
                } else if (targetUnit.equals("KG")) {
                    targetAmount = sourceAmount / 2.204623;
                } else{
                    throw new IllegalArgumentException("Invalid target unit: " + targetUnit);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid source unit: " + sourceUnit);
        }
        return targetAmount;
    }
}
