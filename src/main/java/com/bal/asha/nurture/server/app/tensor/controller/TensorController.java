package com.bal.asha.nurture.server.app.tensor.controller;

import com.bal.asha.nurture.server.app.tensor.service.TensorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@AllArgsConstructor
@RequestMapping(("public/tensor"))
public class TensorController {

    private TensorService tensorService;
    @GetMapping("/globe/locations")
    public String find() {
        return tensorService.getGlobeCoOrdinates();
    }

}


