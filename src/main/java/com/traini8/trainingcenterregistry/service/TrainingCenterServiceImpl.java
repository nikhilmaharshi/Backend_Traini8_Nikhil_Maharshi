package com.traini8.trainingcenterregistry.service;

import com.traini8.trainingcenterregistry.dto.request.AddressRequestDto;
import com.traini8.trainingcenterregistry.dto.request.TrainingCenterRequestDto;
import com.traini8.trainingcenterregistry.dto.response.AddressResponseDto;
import com.traini8.trainingcenterregistry.dto.response.TrainingCenterResponseDto;
import com.traini8.trainingcenterregistry.model.Address;
import com.traini8.trainingcenterregistry.model.TrainingCenter;
import com.traini8.trainingcenterregistry.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService{

    @Autowired
    private TrainingRepository trainingRepository;

    /**
     * Creates a new Training Center and saves it to the repository.
     *
     * @param trainingCenterRequestDto DTO containing training center details
     * @return TrainingCenterResponseDto representing the created training center
     */
    @Override
    public TrainingCenterResponseDto createService(TrainingCenterRequestDto trainingCenterRequestDto) {

        TrainingCenter trainingCenter = trainingRepository.save(convertIntoEntity(trainingCenterRequestDto));
        return convertIntoDto(trainingCenter);
    }

    /**
     * Retrieves all training centers from the repository.
     *
     * @return List of TrainingCenterResponseDto for all training centers
     */
    @Override
    public List<TrainingCenterResponseDto> getAllServices() {
        List<TrainingCenter> trainingCenters = trainingRepository.findAll();
        List<TrainingCenterResponseDto> trainingCenterResponseDtos = new ArrayList<>();

        trainingCenters.forEach(trainingCenter -> {
            trainingCenterResponseDtos.add(convertIntoDto(trainingCenter));
        });

        return trainingCenterResponseDtos;
    }

    /**
     * Filters training centers based on course, city, and state.
     * @return List of TrainingCenterResponseDto matching the filters
     */
    @Override
    public List<TrainingCenterResponseDto> filterTrainingCenters(String course, String city, String state) {

        List<TrainingCenter> trainingCenters = trainingRepository.filterTrainingCenters(course, city, state);

        List<TrainingCenterResponseDto> trainingCenterResponseDtos = new ArrayList<>();

        trainingCenters.forEach(trainingCenter -> {
            trainingCenterResponseDtos.add(convertIntoDto(trainingCenter));
        });

        return trainingCenterResponseDtos;
    }

    /**
     * Converts a TrainingCenterRequestDto to a TrainingCenter entity.
     *
     * @param trainingCenterRequestDto DTO containing training center details
     * @return TrainingCenter entity
     */
    private TrainingCenter convertIntoEntity(TrainingCenterRequestDto trainingCenterRequestDto){

        AddressRequestDto addressRequestDto = trainingCenterRequestDto.getAddress();

        // Create Address entity object from the AddressRequestDto
        Address address = Address.builder()
                .detailedAddress(addressRequestDto.getDetailedAddress())
                .city(addressRequestDto.getCity())
                .state(addressRequestDto.getState())
                .pinCode(addressRequestDto.getPinCode())
                .build();

        // Build and return the TrainingCenter entity
        TrainingCenter trainingCenter = TrainingCenter.builder()
                .centerName(trainingCenterRequestDto.getCenterName())
                .centerCode(trainingCenterRequestDto.getCenterCode())
                .address(address)
                .studentCapacity(trainingCenterRequestDto.getStudentCapacity())
                .coursesOffered(trainingCenterRequestDto.getCoursesOffered())
                .contactEmail(trainingCenterRequestDto.getContactEmail())
                .contactPhone(trainingCenterRequestDto.getContactPhone())
                .build();

        return trainingCenter;
    }

    /**
     * Converts a TrainingCenter entity to a TrainingCenterResponseDto.
     *
     * @param trainingCenter the TrainingCenter entity to convert
     * @return TrainingCenterResponseDto representing the training center
     */
    private TrainingCenterResponseDto convertIntoDto(TrainingCenter trainingCenter){

        // Create AddressResponseDto from the Address entity
        Address address = trainingCenter.getAddress();
        AddressResponseDto addressResponseDto = AddressResponseDto.builder()
                .detailedAddress(address.getDetailedAddress())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .build();

        // Build and return the TrainingCenterResponseDto
        TrainingCenterResponseDto trainingCenterResponseDto = TrainingCenterResponseDto.builder()
                .id(trainingCenter.getId())
                .centerName(trainingCenter.getCenterName())
                .centerCode(trainingCenter.getCenterCode())
                .address(addressResponseDto)
                .studentCapacity(trainingCenter.getStudentCapacity())
                .coursesOffered(trainingCenter.getCoursesOffered())
                .createdOn(trainingCenter.getCreatedOn())
                .contactEmail(trainingCenter.getContactEmail())
                .contactPhone(trainingCenter.getContactPhone())
                .build();
        return trainingCenterResponseDto;
    }
}
