package in.bhusanproj.expensetrackerapi.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.bhusanproj.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class globalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest req)
	{
		ErrorObject errorObject=new ErrorObject();
		errorObject.setstatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumantTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest req)
	{
		ErrorObject errorObject=new ErrorObject();
		errorObject.setstatusCode(HttpStatus.BAD_REQUEST.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
	
	
	//for all other exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest req)
	{
		ErrorObject errorObject=new ErrorObject();
		errorObject.setstatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(itemAlreadyExistsException.class)
	public ResponseEntity<ErrorObject> handleItemAlreadyExistsException(Exception ex, WebRequest req)
	{
		ErrorObject errorObject=new ErrorObject();
		errorObject.setstatusCode(HttpStatus.CONFLICT.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT);
	}
	
	protected ResponseEntity<Object> handleMethodArgumantNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		Map<String,Object> body=new HashMap<String,Object>();
		body.put("timestamp", new Date());
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		List<String> errors=ex.getBindingResult()
		.getFieldErrors()
		.stream()
		.map(x->x.getDefaultMessage())
		.collect(Collectors.toList());
		body.put("messages", errors);
		
		return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST);
	}

}
