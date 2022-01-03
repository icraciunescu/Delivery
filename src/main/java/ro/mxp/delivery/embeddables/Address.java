package ro.mxp.delivery.embeddables;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public @Data class Address {

    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String city;

}
