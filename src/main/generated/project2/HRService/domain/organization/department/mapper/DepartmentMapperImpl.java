package project2.HRService.domain.organization.department.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project2.HRService.domain.organization.department.dto.DepartmentDto.PatchDto;
import project2.HRService.domain.organization.department.dto.DepartmentDto.PostDto;
import project2.HRService.domain.organization.department.entity.Department;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-27T10:37:54+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department postDtoToEntity(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setName( postDto.getName() );
        department.setStatus( postDto.getStatus() );
        department.setEstablishDate( postDto.getEstablishDate() );

        return department;
    }

    @Override
    public Department patchDtoToEntity(PatchDto patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( patchDto.getId() );
        department.setName( patchDto.getName() );
        department.setStatus( patchDto.getStatus() );
        department.setEstablishDate( patchDto.getEstablishDate() );

        return department;
    }
}
