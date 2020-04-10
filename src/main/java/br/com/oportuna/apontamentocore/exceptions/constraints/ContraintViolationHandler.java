package br.com.oportuna.apontamentocore.exceptions.constraints;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ContraintViolationHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    Set<ConstraintViolation<?>> setOfConstraintViolations = ((ConstraintViolationException) ex)
        .getConstraintViolations();

    Set<ErrorDescriminator> mapOfErrors = new HashSet<>();

    setOfConstraintViolations.stream().forEach(f -> {
      mapOfErrors.add(new ErrorDescriminator(f.getPropertyPath().toString() , f.getMessage()));
    });

    return new ResponseEntity(mapOfErrors, HttpStatus.BAD_REQUEST);
  }

}