package br.com.evasion.src.exception;

import br.com.evasion.src.enums.ErrorsEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class GeneralException extends RuntimeException {

    private final ErrorsEnum error;
    private final String message;
    // TODO: This field is shadowing the original "message" field in the parent. Is that intentional?

    @Builder
    public GeneralException(@NonNull ErrorsEnum error) {
        this.error = error;
        this.message = error.getMessage();
    }

//    @Builder
//    public GeneralException(@NonNull ErrorsEnum error, String message) {
//        this.error = error;
//        this.message = message;
//    }
//
//    @Builder
//    public GeneralException(@NonNull ErrorsEnum error, String message, Throwable cause) {
//        super(cause);
//
//        this.error = error;
//        this.message = message;
//    }

}