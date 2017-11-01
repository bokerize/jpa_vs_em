package com.bok.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by JerichoJohn on 01-Nov-17.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="sam_table")
public class SamTab {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "drn")
    private String drn;

    @Column(name = "other")
    private String other;

}



