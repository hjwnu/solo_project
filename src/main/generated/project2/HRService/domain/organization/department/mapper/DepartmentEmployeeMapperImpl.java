package project2.HRService.domain.organization.department.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto.PatchDto;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto.PostDto;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto.ResponseDto;
import project2.HRService.domain.organization.department.dto.DepartmentEmployeeDto.ResponseDto.ResponseDtoBuilder;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee;
import project2.HRService.domain.organization.department.entity.DepartmentEmployee.DepartmentEmployeeBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T10:37:54+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class DepartmentEmployeeMapperImpl implements DepartmentEmployeeMapper {

    @Override
    public DepartmentEmployee postDtoToEntity(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        DepartmentEmployeeBuilder departmentEmployee = DepartmentEmployee.builder();

        departmentEmployee.department( postDto.getDepartment() );

        return departmentEmployee.build();
    }

    @Override
    public DepartmentEmployee patchDtoToEntity(PatchDto patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        DepartmentEmployeeBuilder departmentEmployee = DepartmentEmployee.builder();

        departmentEmployee.department( patchDto.getDepartment() );

        return departmentEmployee.build();
    }

    @Override
    public ResponseDto entityToResponseDto(DepartmentEmployee entity) {
        if ( entity == null ) {
            return null;
        }

        ResponseDtoBuilder responseDto = ResponseDto.builder();

        responseDto.department( entity.getDepartment() );

        return responseDto.build();
    }
}
