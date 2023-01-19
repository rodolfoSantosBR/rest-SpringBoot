package br.com.rodolfo.api.transaction.controller;


import br.com.rodolfo.api.transaction.exception.UnsuportedMethodOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {


    private static final String template = "Hello, %s ! ";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/sum/{number1}/{number2}")
    public Double sum(@PathParam(value = "number1")
                      String number1,
                      @PathParam(value = "number2")
                      String number2) throws Exception {

        if (!isNumeric(number1) || isNumeric(number2)) {
            throw new UnsuportedMethodOperationException("Numero informado invalido ! ");
        }
        return convertToDouble(number1) + convertToDouble(number2);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;

    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null ) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
