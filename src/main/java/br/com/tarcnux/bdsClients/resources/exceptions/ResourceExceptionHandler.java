package br.com.tarcnux.bdsClients.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.tarcnux.bdsClients.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(
			ResourceNotFoundException e, 
			HttpServletRequest request) {
		
		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource Not Found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
