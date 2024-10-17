package com.springApp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springApp.util.AttractionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "attraction")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2)
    private String name;

    @Column(name = "creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "about_attraction")
    private String aboutAttraction;

    @Enumerated(EnumType.STRING)
    @Column(name = "attraction_type")
    private AttractionType attractionType;

    @ManyToOne
    @JoinColumn(name="settlement_id")
    private Settlement settlement;

    @ManyToOne
    @JoinColumn(name="service_option_id")
    private ServiceOption serviceOption;
}


