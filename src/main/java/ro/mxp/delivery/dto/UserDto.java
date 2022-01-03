package ro.mxp.delivery.dto;

import lombok.Data;

public @Data
class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;

}
