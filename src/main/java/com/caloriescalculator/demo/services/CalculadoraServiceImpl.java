package com.caloriescalculator.demo.services;

import com.caloriescalculator.demo.IngredientNotFoundException;
import com.caloriescalculator.demo.dtos.IngredienteDTO;
import com.caloriescalculator.demo.dtos.IngredienteResponseDTO;
import com.caloriescalculator.demo.dtos.PlatoRequestDTO;
import com.caloriescalculator.demo.dtos.PlatoResponseDTO;
import com.caloriescalculator.demo.repositories.CalculadoraRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    CalculadoraRepositorio calculadoraRepositorio;

    public CalculadoraServiceImpl(CalculadoraRepositorio calculadoraRepositorio) {
        this.calculadoraRepositorio = calculadoraRepositorio;
    }

    public PlatoResponseDTO getTotalCalories(PlatoRequestDTO platoRequestDTO) {

        double calorias = 0;
        double calMax = 0;
        IngredienteResponseDTO ingredienteMasCal = new IngredienteResponseDTO();
        List<IngredienteResponseDTO> ingredienteResponseDTOList = new ArrayList<>();

        for (IngredienteDTO ingr : platoRequestDTO.getIngredientesDTOS()) {
            try {
                IngredienteDTO ingredienteDTOActual = calculadoraRepositorio.getIngredientes(ingr.getName());
                double aux;

                aux = ingredienteDTOActual.getCalories() * (ingr.getWeight() / 100);
                ingredienteResponseDTOList.add(new IngredienteResponseDTO(ingr.getName(), aux));
                calorias += aux;

                if (aux > calMax) {
                    ingredienteMasCal.setCalories(aux);
                    ingredienteMasCal.setName(ingr.getName());
                    calMax = aux;
                }

            } catch (IngredientNotFoundException e) {
                e.printStackTrace();
            }
        }
        return new PlatoResponseDTO(calorias, ingredienteResponseDTOList, ingredienteMasCal);
    }


}
