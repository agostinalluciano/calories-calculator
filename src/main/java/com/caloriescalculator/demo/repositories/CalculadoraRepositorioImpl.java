package com.caloriescalculator.demo.repositories;

import com.caloriescalculator.demo.IngredientNotFoundException;
import com.caloriescalculator.demo.dtos.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class CalculadoraRepositorioImpl  implements CalculadoraRepositorio {




    private List<IngredienteDTO> loadDB() {
        File file=null;

        try {
            file = ResourceUtils.getFile("classpath:static/food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mapObject(file);
    }

    private List<IngredienteDTO> mapObject(File file) {
        ObjectMapper objectMapper = new ObjectMapper(); // indagar en este mappeador
        TypeReference<List<IngredienteDTO>> typeReference = new TypeReference<>() {};
        List<IngredienteDTO> priceDTO = null;
        try{
            priceDTO = objectMapper.readValue(file,typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTO;
    }

    @Override
    public IngredienteDTO getIngredientes(String nombreIngrediente) throws IngredientNotFoundException {

        List<IngredienteDTO> ingredienteDTOList= loadDB();
       return ingredienteDTOList
                .stream()
                .filter(ingredienteDTO-> ingredienteDTO.getName().equals(nombreIngrediente))
                .findFirst()
                .orElseThrow(IngredientNotFoundException::new);
    }
}
