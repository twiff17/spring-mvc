package by.bsuir.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND,
        reason="Article Not Found")
public class ArticleNotFoundException extends RuntimeException {
}
