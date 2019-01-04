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
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Александр on 04.01.2019.
 */
@Entity
@Table(name = "storage")
@Data
public class Storage implements Serializable{
    private static final long serialVersionUID = -7057456985370410891L;

    @Id
    @Column(name = "bookid")
    private Long bookId;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Book book;

    @Column(name = "bookcount")
    private Integer bookCount;

}
