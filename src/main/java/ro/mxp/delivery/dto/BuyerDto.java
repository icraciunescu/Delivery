package ro.mxp.delivery.dto;

import lombok.Data;
import ro.mxp.delivery.embeddables.Address;

import java.time.LocalDate;

public @Data
class BuyerDto extends UserDto {

    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private LocalDate dateOfBirth;

}
