package project2.HRService.domain.organization.employee.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project2.HRService.domain.organization.employee.dto.RoleDto.PatchDto;
import project2.HRService.domain.organization.employee.dto.RoleDto.PostDto;
import project2.HRService.domain.organization.employee.dto.RoleDto.ResponseDto;
import project2.HRService.domain.organization.employee.entity.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-26T18:08:17+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role postDtoToEntity(PostDto postDto) {
        if ( postDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( postDto.getName() );
        role.setRank( postDto.getRank() );

        return role;
    }

    @Override
    public Role patchDtoToEntity(PatchDto patchDto) {
        if ( patchDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( patchDto.getName() );
        role.setRank( patchDto.getRank() );

        return role;
    }

    @Override
    public ResponseDto entityToResponseDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        ResponseDto responseDto = new ResponseDto();

        responseDto.setName( entity.getName() );
        if ( entity.getRank() != null ) {
            responseDto.setRank( entity.getRank() );
        }

        return responseDto;
    }
}
