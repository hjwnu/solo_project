package project2.HRService.domain.organization.department.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.lang.Nullable;
import project2.HRService.domain.organization.department.entity.Department;

import java.time.ZonedDateTime;

public class DepartmentDto  {

    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PatchDto  {
        long id;
        @Nullable
        String name;
        @Nullable
        Department.Status status;
        @Nullable
        ZonedDateTime establishDate;
        @Nullable
        String head;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class PostDto {
        @NotNull(message =  "부서명은 필수 입력입니다.")
        String name;
        @NotNull(message = "부서 상태는 필수 입력입니다. ACTIVE, INACTIVE")
        Department.Status status;
        @NotNull(message = "부서설립일은 필수로 입력되어야 합니다.")
        ZonedDateTime establishDate;
        @Nullable
        String head;
    }
    @Getter@Setter
    @AllArgsConstructor
    @RequiredArgsConstructor
    @Builder
    public static class ResponseDto {
        String name;
        String head;
        Department.Status status;
        ZonedDateTime establishDate;
        Integer headCount;
    }
}
