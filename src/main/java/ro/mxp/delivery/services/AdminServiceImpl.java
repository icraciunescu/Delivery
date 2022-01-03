package ro.mxp.delivery.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.mxp.delivery.dto.AdminDto;
import ro.mxp.delivery.entities.Admin;
import ro.mxp.delivery.repositories.AdminRepository;
import ro.mxp.delivery.utils.CurrentUsername;
import ro.mxp.delivery.utils.UserRole;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final ModelMapper modelMapper = new ModelMapper();
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AdminDto getAdmin(String username) {
        Optional<Admin> adminOptional = adminRepository.findAdminByUsername(username);
        Admin admin = adminOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found !"));
        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public void addAdmin(AdminDto adminDto) {
        if (adminRepository.findAll().isEmpty()) {
            adminDto.setRole("ROLE_" + UserRole.ADMIN.name());
            adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
            adminRepository.save(modelMapper.map(adminDto, Admin.class));
        } else {
            throw new IllegalArgumentException("admin exists!");
        }
    }

    @Override
    public void updateAdmin(AdminDto adminDto) {
        Optional<Admin> adminOptional = adminRepository.findAdminByUsername(CurrentUsername.getCurrentUsername());
        Admin adminUpdated = adminOptional.orElseThrow(() -> new UsernameNotFoundException("Username not found !"));
        adminUpdated.setUsername(CurrentUsername.getCurrentUsername());
        adminUpdated.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        adminUpdated.setRole("ROLE_" + UserRole.ADMIN.name());
        adminUpdated.setEmail(adminDto.getEmail());
        adminRepository.save(adminUpdated);
    }

}
