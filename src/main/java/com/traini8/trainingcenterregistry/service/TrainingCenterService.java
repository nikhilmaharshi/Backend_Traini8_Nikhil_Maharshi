package com.traini8.trainingcenterregistry.service;

import com.traini8.trainingcenterregistry.dto.request.TrainingCenterRequestDto;
import com.traini8.trainingcenterregistry.dto.response.TrainingCenterResponseDto;

import java.util.List;

public interface TrainingCenterService {
    TrainingCenterResponseDto createService(TrainingCenterRequestDto trainingCenterRequestDto);

    List<TrainingCenterResponseDto> getAllServices();

    List<TrainingCenterResponseDto> filterTrainingCenters(String course, String city, String state);
}
