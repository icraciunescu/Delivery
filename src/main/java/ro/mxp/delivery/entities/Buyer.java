package ro.mxp.delivery.entities;

import lombok.Data;
import ro.mxp.delivery.embeddables.Address;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public @Data
class Buyer extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String phone;
    @Embedded
    private Address address;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

}
