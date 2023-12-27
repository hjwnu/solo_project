package project2.HRService.domain.organization.employee.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project2.HRService.domain.organization.employee.dto.EmployeeDto.PatchDto;
import project2.HRService.domain.organization.employee.dto.EmployeeDto.PostDto;
import project2.HRService.domain.organization.employee.entity.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T10:37:54+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee postDtoToEntity(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setCorporation( postDto.getCorporation() );
        employee.setName( postDto.getName() );
        employee.setType( postDto.getType() );

        return employee;
    }

    @Override
    public Employee patchDtoToEntity(PatchDto patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setCorporation( patchDto.getCorporation() );
        employee.setName( patchDto.getName() );
        employee.setType( patchDto.getType() );

        return employee;
    }
}
