package dev.sandeep.BookMyShow.controller;

import dev.sandeep.BookMyShow.dto.CityRequestDTO;
import dev.sandeep.BookMyShow.model.City;
import dev.sandeep.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity<String> getCityByName(@PathVariable("name") String cityName){
        City savedCity = cityService.getCityByName(cityName);
        ResponseEntity.ok(savedCity);  // we would return cityResponseDTO
        return ResponseEntity.ok("City Saved SuccessFullt");
    }

    @PostMapping("/city")
    public ResponseEntity<String> createCity(@RequestBody CityRequestDTO cityRequestDTO){
        try{
            String cityName = cityRequestDTO.getName();
            if(cityName == null || cityName.isEmpty() || cityName.isBlank()) {
                throw new Exception("City Name is invalid");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok("new City has been add to system"); // we would return cityResponseDTO
        }catch (Exception e){
            e.printStackTrace();
        }
         return ResponseEntity.ofNullable("new City failed to add");
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<Boolean> deleteCity(@PathVariable("id") int cityId){
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}
