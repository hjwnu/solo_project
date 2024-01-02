package project2.HRService.domain.organization.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.domain.organization.employee.service.layer2.RoleService;
import project2.HRService.global.response.SingleResponseDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<SingleResponseDto<Role>> createRole() {
        return null;
    }
}
