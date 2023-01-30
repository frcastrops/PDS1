package br.com.evasion.src.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.event.Level;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum ErrorsEnum implements Serializable {

    INTERNAL("1", "Erro interno!", Level.ERROR, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_CREATE_VALIDATION_ERROR("2", "Parâmetro obrigatório não preenchido",
            Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_ALREADY_EXIST("3", "Usuário já está cadastrado", Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR),
    USER_OR_PASS_ERROR("4", "Usuário ou senha inválido", Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR),

    NOT_SAMPLE_OF_STUDANTS("5", "Não é permitido cadastrar usuário sem informação de " +
            "disistência sem uma amostra de estudantes previamente cadastrada",
            Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR),

    USER_NOT_EXIST("6", "Usuário não existe na base de dados.",
            Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR),

    STUDANT_NOT_EXIST("7", "Estudante não existe na base de dados.",
                   Level.INFO, HttpStatus.INTERNAL_SERVER_ERROR);

    private String code;
    private String message;
    private Level logLevel;
    private HttpStatus httpStatus;

    @Override
    public String toString() {
        return "{" +
               "\"code\":\"" + code + "\"" +
               ",\"message\":\"" + message + "\"" +
               ",\"logLevel\":\"" + logLevel + "\"" +
               ",\"httpStatus\":\"" + httpStatus + "\"" +
               "}";
    }

}
