package project2.HRService.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    NOT_FOUND(404, "존재하지 않는 요청입니다.");

    @Getter
    private final int status;
    @Getter
    private final String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
