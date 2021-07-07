package com.caloriescalculator.demo.controllers;

import com.caloriescalculator.demo.services.CalculadoraService;
import com.caloriescalculator.demo.dtos.PlatoRequestDTO;
import com.caloriescalculator.demo.dtos.PlatoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calories-calculator")
public class CalculadoraController {

    CalculadoraService calculadoraService;


    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/total-calories")
    public ResponseEntity<PlatoResponseDTO> getTotalCalories(@RequestBody PlatoRequestDTO platoRequestDTO){
       PlatoResponseDTO platoResponseDTO;
       platoResponseDTO= calculadoraService.getTotalCalories(platoRequestDTO);
       return new ResponseEntity<PlatoResponseDTO>(platoResponseDTO, HttpStatus.OK);
    }

}
