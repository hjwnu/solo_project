package project2.HRService.domain.organization.employee.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.HRService.domain.organization.employee.dto.EmployeeDto;
import project2.HRService.domain.organization.employee.service.facade.EmployeeService;
import project2.HRService.global.response.SingleResponseDto;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController
{
    private final EmployeeService service;
    private  final HttpStatus ok = HttpStatus.OK;
    @PostMapping
    public ResponseEntity<SingleResponseDto<EmployeeDto.ResponseDto>> patchDepartment(
                                                                                      @Valid @RequestBody EmployeeDto.PostDto postDto){
        SingleResponseDto<EmployeeDto.ResponseDto> responses = new SingleResponseDto<>(service.createEmployee(postDto),ok);
        return new ResponseEntity<>(responses, ok);
    }
}
