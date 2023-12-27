package project2.HRService.domain.organization.employee.mapper;

import org.mapstruct.Mapper;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.employee.dto.EmployeeDto;
import project2.HRService.domain.organization.employee.entity.Employee;
import project2.HRService.global.generic.GenericMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDto.PostDto, EmployeeDto.ResponseDto, EmployeeDto.PatchDto, Long > {
    default EmployeeDto.ResponseDto entityToResponseDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDto.ResponseDto.ResponseDtoBuilder responseDto = EmployeeDto.ResponseDto.builder();
        responseDto.employeeNumber(entity.getId());
        responseDto.corporation( entity.getCorporation() );
        responseDto.name( entity.getName() );
        responseDto.type( entity.getType() );
        responseDto.department(getDepartmentName(entity.getDepartmentEmployees()));
        responseDto.role(getRoleName(entity.getDepartmentEmployees()));
        return responseDto.build();
    }

    default List<String> getDepartmentName(List<DepartmentEmployee> list) {
        if(list.size()==1){return Collections.singletonList(list.get(0).getDepartment().getName());}
        List<String> nameList = new ArrayList<>();
        for (DepartmentEmployee de : list) {
            nameList.add(de.getDepartment().getName());
        }
        return nameList;
    }
    default List<String> getRoleName(List<DepartmentEmployee> list) {
        if(list.size()==1){return Collections.singletonList(list.get(0).getRole().getName());}
        List<String> roleList = new ArrayList<>();
        for (DepartmentEmployee de : list) {
            roleList.add(de.getRole().getName());
        }
        return roleList;
    }
}
