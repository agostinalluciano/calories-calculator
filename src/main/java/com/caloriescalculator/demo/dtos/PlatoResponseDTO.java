package com.caloriescalculator.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoResponseDTO {

    private double cantCal;
    private List<IngredienteResponseDTO> ingredienteResponseDTOS;
    private IngredienteResponseDTO ingredienteResponseDTO;
}
