package ru.me.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Александр on 05.01.2019.
 */
@Entity
@Table(name = "readingroom")
@Data
public class ReadingRoom implements Serializable{

    private static final String SEQUENCE_NAME = "readingRoomSeq";
    private static final long serialVersionUID = -4861331187157421726L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = SEQUENCE_NAME, strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "username")
    private String userName;

    @OneToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="id")
    private Book book;
}
