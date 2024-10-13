package com.traini8.trainingcenterregistry.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

/**
 * Data Transfer Object (DTO) for representing the response containing address information.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressResponseDto {
    private String detailedAddress;

    private String city;

    private String state;

    private String pinCode;
}
