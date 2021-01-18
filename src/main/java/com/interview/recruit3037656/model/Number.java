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
@Table(name = "number")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Number {
    @Id
    @Column
    private Long id;

    @Column
    private String number;
}
