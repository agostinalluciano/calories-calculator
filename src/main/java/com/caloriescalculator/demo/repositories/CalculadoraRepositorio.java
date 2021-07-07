package com.caloriescalculator.demo.repositories;

import com.caloriescalculator.demo.IngredientNotFoundException;
import com.caloriescalculator.demo.dtos.IngredienteDTO;

import java.util.List;

public interface CalculadoraRepositorio {

    IngredienteDTO getIngredientes(String nombreIngrediente) throws IngredientNotFoundException;
}
