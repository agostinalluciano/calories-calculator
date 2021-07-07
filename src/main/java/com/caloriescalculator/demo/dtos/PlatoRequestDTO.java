package com.caloriescalculator.demo.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoRequestDTO {

    private String  nombre;
    private List<IngredienteDTO> ingredientesDTOS;
    private double peso;

}
