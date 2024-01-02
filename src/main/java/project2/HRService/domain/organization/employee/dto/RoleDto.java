package project2.HRService.domain.organization.employee.dto;

import lombok.*;

import java.util.List;

public class RoleDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PostDto {
        String name;
        int rank;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PatchDto {
        String name;
        int rank;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor @Builder
    public static class ResponseDto {
        String name;
        int rank;
        List<String> Departments;
        List<String> Employees;
    }
}

