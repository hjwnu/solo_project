package project2.HRService.domain.organization.employee.mapper;

import org.mapstruct.Mapper;
import project2.HRService.domain.organization.employee.dto.RoleDto;
import project2.HRService.domain.organization.employee.entity.Role;
import project2.HRService.global.generic.GenericMapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<Role, RoleDto.PostDto, RoleDto.ResponseDto, RoleDto.PatchDto, Long> {

    @Override
    default RoleDto.ResponseDto entityToResponseDto(Role entity) {
        List<String> departmentList = extractNames(entity.getDepartmentRoles(),
                departmentRole -> departmentRole.getDepartment().getName());
        List<String> employeeList = extractNames(entity.getEmployeeRoles(),
                employeeRole -> employeeRole.getEmployee().getName());

        return RoleDto.ResponseDto.builder()
                .name(entity.getName())
                .rank(entity.getRank())
                .Departments(departmentList)
                .Employees(employeeList)
                .build();
    }

    private <T> List<String> extractNames(List<T> entities, Function<T, String> nameExtractor) {
        return entities.stream()
                .map(nameExtractor)
                .collect(Collectors.toList());
    }
}
