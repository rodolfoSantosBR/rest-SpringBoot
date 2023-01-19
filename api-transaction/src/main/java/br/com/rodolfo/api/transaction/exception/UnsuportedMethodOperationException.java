package br.com.rodolfo.api.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMethodOperationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnsuportedMethodOperationException(String message) {

        super(message);

    }
}
