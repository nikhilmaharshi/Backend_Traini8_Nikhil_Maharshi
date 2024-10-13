package com.traini8.trainingcenterregistry.controller;

import com.traini8.trainingcenterregistry.dto.request.TrainingCenterRequestDto;
import com.traini8.trainingcenterregistry.dto.response.TrainingCenterResponseDto;
import com.traini8.trainingcenterregistry.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class to handle API requests related to Training Centers.
 */

@Validated
@RestController
@RequestMapping("/api/trainingCenters")
public class TrainingCenterController {

    // Injecting the service layer to handle business logic
    @Autowired
    private TrainingCenterService trainingCenterService;

    /**
     * Endpoint to create a new training center.
     * Validates the input request body and returns the created training center details.
     */
    @PostMapping("/create")
    public ResponseEntity<TrainingCenterResponseDto> createTrainingCenter(@Valid @RequestBody TrainingCenterRequestDto trainingCenterRequestDto){
        // Call the service layer to create a new training center
        TrainingCenterResponseDto trainingCenterResponseDto = trainingCenterService.createService(trainingCenterRequestDto);

        return new ResponseEntity<>(trainingCenterResponseDto,HttpStatus.CREATED);
    }

    /**
     * Retrieves all training centers.
     * @return Response with list of all training centers.
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<TrainingCenterResponseDto>> getCenters(){
        List<TrainingCenterResponseDto> trainingCenters = trainingCenterService.getAllServices();
        return new ResponseEntity<>(trainingCenters,HttpStatus.OK);
    }
    /**
     * Filters training centers by optional course, city, or state parameters.
     * @return Response with filtered training centers.
     */
    @GetMapping("/filter")
    public ResponseEntity<List<TrainingCenterResponseDto>> filterTrainingCenters(
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {

        List<TrainingCenterResponseDto> trainingCenters = trainingCenterService.filterTrainingCenters(course, city, state);
        return new ResponseEntity<>(trainingCenters,HttpStatus.OK);
    }
}
