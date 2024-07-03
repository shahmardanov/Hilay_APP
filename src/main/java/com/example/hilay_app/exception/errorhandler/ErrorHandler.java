package com.example.hilay_app.exception.errorhandler;

import com.example.hilay_app.exception.*;
import com.example.hilay_app.exception.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(ChatMessageNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerChatMessageNotFoundException(Exception exception) {
        log.error("handlerChatMessageNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(CardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerCardNotFoundException(Exception exception) {
        log.error("handlerCardNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(SubCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerSubCategoryNotFoundException(Exception exception) {
        log.error("handlerSubCategoryNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(ChatGroupNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerChatGroupNotFoundException(Exception exception) {
        log.error("handlerChatGroupNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(MainCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerMainCategoryNotFoundException(Exception exception) {
        log.error("handlerMainCategoryNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(MainCategoryExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerMainCategoryExistsException(Exception exception) {
        log.error("handlerMainCategoryExistsException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerTeacherNotFoundException(Exception exception) {
        log.error("handlerTeacherNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(AnswerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerAnswerNotFoundException(Exception exception) {
        log.error("handlerAnswerNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }



    @ExceptionHandler(ImageFileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerImageNotFoundException(Exception exception) {
        log.error("handlerImageNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }


    @ExceptionHandler(QuestionLevelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerQuestionLevelNotFoundException(Exception exception) {
        log.error("handlerQuestionLevelNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(UserAnswerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerUserAnswerNotFoundException(Exception exception) {
        log.error("handlerUserAnswerNotFoundException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerValidationException(Exception exception) {
        log.error("handlerValidationException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(ImageFileNameExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerImageFileNameExistsException(Exception exception) {
        log.error("handlerImageFileNameExistsException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(ChatGroupExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerChatGroupExistsException(Exception exception) {
        log.error("handlerChatGroupExistsException {}", exception.getMessage());

        return ErrorResponse.builder()
                .code(HttpStatus.CONFLICT.name())
                .message(exception.getMessage())
                .build();
    }

}