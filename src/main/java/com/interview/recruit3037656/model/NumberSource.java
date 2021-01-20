package com.interview.recruit3037656.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number_source")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NumberSource {
    @Id
    @Column
    private Long id;

    @Column
    private String numberValue;

    //TODO dodac sposob laczenia z innymi danymi badz dodanie mozliwosci dodania kolejnego typu danych...
}
