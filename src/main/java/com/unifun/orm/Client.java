package com.unifun.orm;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String firstName;
    public String lastName;
    public long idCars;

    @OneToOne
    public Cars cars;
}
