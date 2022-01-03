package ro.mxp.delivery.entities;

import lombok.Data;
import ro.mxp.delivery.embeddables.Address;

import javax.persistence.*;

@Entity
public @Data
class Seller extends User {

    @Column
    private String name;
    @Column(name = "type_of_products")
    private String typeOfProducts;
    @Embedded
    private Address address;
    @Column
    private String phone;

}
