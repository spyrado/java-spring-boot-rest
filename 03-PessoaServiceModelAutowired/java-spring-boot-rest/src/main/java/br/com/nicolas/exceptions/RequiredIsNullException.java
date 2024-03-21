package br.com.nicolas.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RequiredIsNullException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public RequiredIsNullException(String text) { super(text); }

  public RequiredIsNullException() { super("Não é permitido persistir um objeto nullo."); }
}
