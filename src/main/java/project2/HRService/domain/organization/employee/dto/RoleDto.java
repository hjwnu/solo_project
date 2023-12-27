package project2.HRService.domain.organization.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
    @RequiredArgsConstructor
    public static class ResponseDto {
        String name;
        int rank;
    }
}

