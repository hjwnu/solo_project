package project2.HRService.domain.organization.employee.dto;

import lombok.*;
import project2.HRService.domain.organization.employee.entity.Employee;

import java.util.List;

public class EmployeeDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PostDto {
        String corporation;
        String name;
        Employee.Status type;
        String department;
        String role;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PatchDto {
        String corporation;
        String name;
        Employee.Status type;
        String department;
        String role;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    public static class ResponseDto {
        Long employeeNumber;
        String corporation;
        String name;
        Employee.Status type;
        List<String> department;
        List<String> role;
    }
}
