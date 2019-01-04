package ru.me.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Александр on 28.12.2018.
 */
@Entity
@Table(name = "book")
@Data
public class Book implements Serializable{

    private static final long serialVersionUID = -1629757189305196932L;
    private final static String SEQUENCE_NAME = "bookseq";

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Author author;

    @Column(name = "releasedate")
    private Date releaseDate;



}
