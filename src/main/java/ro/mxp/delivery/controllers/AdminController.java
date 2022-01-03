package ro.mxp.delivery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.mxp.delivery.dto.AdminDto;
import ro.mxp.delivery.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/{username}")
    public AdminDto getAdmin(@PathVariable("username") String username) {
        return adminService.getAdmin(username);
    }

    @PostMapping
    public void addAdmin(@RequestBody AdminDto adminDto) {
        adminService.addAdmin(adminDto);
    }

    @PutMapping
    public void updateAdmin(@RequestBody AdminDto adminDto) {
        adminService.updateAdmin(adminDto);
    }

}
