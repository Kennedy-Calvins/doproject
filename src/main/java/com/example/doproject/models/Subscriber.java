package com.example.doproject.models;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="subscribers")
public class Subscriber {
    @Id
    @Column(name="id")
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name="name")
    @NotNull(groups = Create.class)
    private String name;

    @Column(name="id_number")
    @NotNull(groups = Create.class)
    private Integer idNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public Subscriber(String name, Integer idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public Subscriber(){}

    public interface Create{}
    public  interface  Update{}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNumber=" + idNumber +
                '}';
    }
}
