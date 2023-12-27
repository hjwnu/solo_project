package project2.HRService.domain.organization.department.mapper;

import org.mapstruct.Mapper;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.global.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface DepartmentEmployeeMapper
        extends GenericMapper<DepartmentEmployee, DepartmentEmployeeDto.PostDto,
        DepartmentEmployeeDto.ResponseDto, DepartmentEmployeeDto.PatchDto, Long> {
}
