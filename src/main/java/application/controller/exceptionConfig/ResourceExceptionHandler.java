package application.controller.exceptionConfig;

import application.service.exception.InvalidParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {  // Se ocorrer alguma das execções abaixo durante o programa, o Spring vai cair nessa classe e vai retornar o erro
    // de uma forma mais agradavél pro cliente.

    @ExceptionHandler(InvalidParamException.class)
    // Caso algum parametro esteja inválido (diferente de = yes && !null).
    public ResponseEntity<StandardError> invalidParam(InvalidParamException e, HttpServletRequest request) {
        String error = "Invalid param";
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
