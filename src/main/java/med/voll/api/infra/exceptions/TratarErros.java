package med.voll.api.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream()
                .map(DadosErrosValidation::new)
                .toList());
    }

    public record DadosErrosValidation(String campo,
                                       String mensagem) {

        public DadosErrosValidation(FieldError erro) {
            this(erro.getField(),
                    erro.getDefaultMessage());
        }
    }

}
