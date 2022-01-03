package ro.mxp.delivery.dto;

import lombok.Data;
import ro.mxp.delivery.embeddables.Address;

public @Data
class SellerDto extends UserDto {

    private String name;
    private String typeOfProducts;
    private Address address;
    private String phone;
}
