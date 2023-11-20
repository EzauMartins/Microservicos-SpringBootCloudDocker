package com.example.convesionservice.controller;

import com.example.convesionservice.model.Cambio;
import com.example.convesionservice.repository.CambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @Autowired
    private CambioRepository repository;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal total,
                            @PathVariable("from") String from,
                            @PathVariable("to")String to){

        var cambio = repository.findByFromAndTo(from,to);
        System.out.println(cambio);
        if (cambio == null) throw new RuntimeException("Currency Unsuported");
        var port = environment.getProperty("local.server.port");

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(total);
        cambio.setEnvironment(port);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        return cambio;
    }

}
