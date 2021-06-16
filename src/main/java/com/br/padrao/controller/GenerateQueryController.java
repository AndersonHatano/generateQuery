package com.br.padrao.controller;

import com.br.padrao.domain.GenerateQuery;
import com.br.padrao.service.GenerateQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerateQueryController {

    @Autowired
    GenerateQueryService generateQueryService;

    @RequestMapping(path = "/generatequery", method = RequestMethod.POST)
    public String generateQuery(@RequestBody GenerateQuery generateQuery){
        return generateQueryService.generateQuery(generateQuery);
    }
}
