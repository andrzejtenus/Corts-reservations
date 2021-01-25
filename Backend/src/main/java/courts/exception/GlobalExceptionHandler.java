package courts.exception;

import java.io.IOException;
import java.util.Date;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletException;

@ControllerAdvice
public class GlobalExceptionHandler {

	// handling specific exception
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(NotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}


	//handling dto exceptions
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> dtoNotValidExceptionHandling(MethodArgumentNotValidException exception)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"Validation Error",
				exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	//handling Conflict Exceptions
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<?> conflictValidExceptionHandling(ConflictException exception)
	{
		ErrorDetails errorDetails = new ErrorDetails(new Date(),"Conflict Error",
				exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
	}
	

}
