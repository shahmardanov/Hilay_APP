package com.example.hilay_app.exception.errorhandler;

import com.example.hilay_app.exception.*;
import com.example.hilay_app.exception.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.AccountNotFoundException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(StudentExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerStudentExitsException(Exception exception) {
        log.error("handlerStudentExitsException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerStudentNotFoundException(Exception exception) {
        log.error("handlerStudentNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerQuestionNotFoundException(Exception exception) {
        log.error("handlerQuestionNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(CardConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerCardConflictException(Exception exception) {
        log.error("handlerCardConflictException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(InvalidUsernameException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handlerInvalidUsernameException(Exception exception) {
        log.error("handlerInvalidUsernameException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handlerInvalidPasswordException(Exception exception) {
        log.error("handlerInvalidPasswordException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.name())
                .message(exception.getMessage())
                .build();
    }
}