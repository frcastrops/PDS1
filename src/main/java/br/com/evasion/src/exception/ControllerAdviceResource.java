package br.com.evasion.src.exception;


import br.com.evasion.src.vo.ErrorVO;
import br.com.evasion.src.vo.ErrorsVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class ControllerAdviceResource {

    @ExceptionHandler({GeneralException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorsVO> handlePixException(GeneralException ex) {
        return ResponseEntity.status(ex.getError().getHttpStatus()).body(buildErrorsVO(ex));
    }

    private static ErrorsVO buildErrorsVO(GeneralException ex) {
        return ErrorsVO.builder().errors(Collections.singletonList(ErrorVO.builder()
                .code(ex.getError().getCode())
                .message(ex.getError().getMessage())
                .build())).build();
    }

}