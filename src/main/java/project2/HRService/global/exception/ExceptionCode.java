package project2.HRService.global.exception;

import lombok.Getter;

public enum ExceptionCode {
    DEPARTMENT_NOT_FOUND(404,"존재하지 않는 부서입니다."),
    EMPLOYEE_NOT_FOUND(404, "존재하지 않는 직원입니다.");
    @Getter
    private final int status;

    @Getter
    private final String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
