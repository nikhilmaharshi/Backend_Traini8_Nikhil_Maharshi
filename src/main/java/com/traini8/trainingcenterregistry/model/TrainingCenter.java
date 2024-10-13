package com.traini8.trainingcenterregistry.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String centerName;

    private String centerCode;

    @Embedded
    private Address address;

    private Integer studentCapacity;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> coursesOffered;

    private Instant createdOn;

    @PrePersist
    public void prePersist() {
        createdOn = Instant.now();
    }

    private String contactEmail;

    private String contactPhone;

}
