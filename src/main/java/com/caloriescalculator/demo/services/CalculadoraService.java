package com.caloriescalculator.demo.services;

import com.caloriescalculator.demo.dtos.PlatoRequestDTO;
import com.caloriescalculator.demo.dtos.PlatoResponseDTO;

public interface CalculadoraService {

    PlatoResponseDTO getTotalCalories(PlatoRequestDTO platoRequestDTO);
}
