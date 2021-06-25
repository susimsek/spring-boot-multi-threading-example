package io.susimsek.completablefuture.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Car implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotNull
    @Column(nullable=false)
    String manufacturer;

    @NotNull
    @Column(nullable=false)
    String model;

    @NotNull
    @Column(nullable=false)
    String type;

}
