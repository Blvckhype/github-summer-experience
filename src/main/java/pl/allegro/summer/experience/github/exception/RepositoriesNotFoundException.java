package pl.allegro.summer.experience.github.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RepositoriesNotFoundException extends RuntimeException{

    public RepositoriesNotFoundException() {
        super("User haven't got any repositories");
    }
}
