package com.traini8.trainingcenterregistry.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import java.time.Instant;
import java.util.List;

/**
 * Data Transfer Object (DTO) for representing the response containing Response DTO information.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TrainingCenterResponseDto {
    private Long id;

    private String centerName;

    private String centerCode;

    private AddressResponseDto address;

    private Integer studentCapacity;

    private List<String> coursesOffered;

    private Instant createdOn;

    private String contactEmail;

    private String contactPhone;
}
