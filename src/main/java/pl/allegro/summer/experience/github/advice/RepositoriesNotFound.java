package pl.allegro.summer.experience.github.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.allegro.summer.experience.github.exception.RepositoriesNotFoundException;

@ControllerAdvice
public class RepositoriesNotFound {

    @ResponseBody
    @ExceptionHandler(RepositoriesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String bookNotFoundHandler(RepositoriesNotFoundException ex) {
        return ex.getMessage();
    }
}
