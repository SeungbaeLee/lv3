package com.hh99.lv3.domain.admin.service;

import com.hh99.lv3.domain.admin.dto.AdminPostDto;
import com.hh99.lv3.domain.admin.dto.AdminResponseDto;
import com.hh99.lv3.domain.admin.entity.Admin;
import com.hh99.lv3.domain.admin.entity.Department;
import com.hh99.lv3.domain.admin.entity.Role;
import com.hh99.lv3.domain.admin.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    //create
    public AdminResponseDto createAdmin(AdminPostDto adminPostDto) {

        if (adminPostDto.getRole() == Role.MANAGER
                && !(adminPostDto.getDepartment().equals(Department.curriculum) || adminPostDto.getDepartment().equals(Department.development))) {
            throw new RuntimeException("개발, 커리큘럼 부서만 매니저로 등록할 수 있습니다.");
        }
        String encryptedPassword = passwordEncoder.encode(adminPostDto.getPassword());
        Admin newAdmin = Admin.builder()
                .email(adminPostDto.getEmail())
                .password(encryptedPassword)
                .department(adminPostDto.getDepartment())
                .role(adminPostDto.getRole())
                .build();
        Admin savedAdmin = adminRepository.save(newAdmin);
        return AdminResponseDto.fromEntity(savedAdmin);
    }
    //get
}
