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
@Table(name="req_sent")
public class ReqSent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "sam_type")
    private String samType;

    @Column(name = "sam_id")
    private String samId;

    @Column(name = "comment")
    private String comment;

}
