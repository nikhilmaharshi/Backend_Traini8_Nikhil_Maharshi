package com.traini8.trainingcenterregistry.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for Address details in training center registry.
 * Uses snake_case for JSON property naming.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressRequestDto {
    // Detailed address field (cannot be blank)
    @NotBlank(message = "Detailed address is required")
    private String detailedAddress;

    // City field (cannot be blank)
    @NotBlank(message = "City is required")
    private String city;

    // State field (cannot be blank)
    @NotBlank(message = "State is required")
    private String state;

    // Pin code field (must be exactly 6 digits and cannot be blank)
    @NotBlank(message = "Pin Code is required")
    @Pattern(regexp = "^\\d{6}$", message = "Invalid pin code")
    private String pinCode;
}
