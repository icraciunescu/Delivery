package ro.mxp.delivery.services;

import ro.mxp.delivery.dto.AdminDto;

public interface AdminService {

    AdminDto getAdmin(String username);
    void addAdmin(AdminDto adminDto);
    void updateAdmin(AdminDto adminDto);

}
