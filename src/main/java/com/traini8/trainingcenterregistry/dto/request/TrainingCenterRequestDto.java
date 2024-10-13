package com.traini8.trainingcenterregistry.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.ElementCollection;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TrainingCenterRequestDto {
    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Valid
    private AddressRequestDto address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    // Allow phone numbers with spaces, digits, and hyphens
    @Pattern(regexp = "^\\+?[0-9 ]+[-0-9 ]*$", message = "Invalid phone number format")
    private String contactPhone;
}
