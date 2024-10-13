package com.traini8.trainingcenterregistry.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String detailedAddress;

    private String city;

    private String state;

    private String pinCode;
}
