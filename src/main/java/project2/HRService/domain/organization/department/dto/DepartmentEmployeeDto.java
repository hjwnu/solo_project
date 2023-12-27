package project2.HRService.domain.organization.department.dto;

import lombok.*;
import project2.HRService.domain.organization.department.entity.Department;
import project2.HRService.domain.organization.employee.entity.Employee;


public class DepartmentEmployeeDto {

    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PostDto {
        Employee name;
        Department department;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PatchDto  {
        Employee name;
        Department department;
    }

    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    public static class ResponseDto {
        Employee name;
        Department department;
    }
}
