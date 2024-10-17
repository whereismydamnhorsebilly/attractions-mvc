package com.springApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springApp.util.ServiceOptionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "service_option")
public class ServiceOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private ServiceOptionType name;

    @Column(name = "about_service")
    private String aboutService;

    @OneToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            mappedBy = "serviceOption",
            fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Attraction> attraction;

}


