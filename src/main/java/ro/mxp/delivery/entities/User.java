package ro.mxp.delivery.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public @Data
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Long id;

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String role;

}
