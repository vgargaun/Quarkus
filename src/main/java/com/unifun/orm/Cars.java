package com.unifun.orm;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
@Entity
@Table
public class Cars extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public int price;
    public String color;
    public String model;


    public Cars(int price, String color, String model) {
        this.price = price;
        this.color = color;
        this.model = model;
    }

    public Cars() {

    }


    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Transactional

    public static String deleteByID(Long id) {

        return Cars.deleteById(id) ? "deleted" : "not deleted";

    }

}
