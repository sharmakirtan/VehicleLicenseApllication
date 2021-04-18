package com.capgemini.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class CustomResponseEntityExceptionHandler {
	
	 @ExceptionHandler(value=AppointmentNotFoundException.class)
	    public ResponseEntity<String> exception(AppointmentNotFoundException exception){
		     return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND); //Http: 404 error
	    }
	 
	 @ExceptionHandler(value=ApplicationNotFoundException.class)
	    public ResponseEntity<String> exception2(ApplicationNotFoundException exception){
		     return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND); //Http: 404 error
	    }
	 
	 @ExceptionHandler(value=CannotGenerateDrivingLicenseException.class)
	    public ResponseEntity<String> handleexception1(CannotGenerateDrivingLicenseException exception ) 
	    { 
		    return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);//Http: 400 error
	    }

	 @ExceptionHandler(value=CannotGenerateLearnerLicenseException.class)
	    public ResponseEntity<String> handleexception2(CannotGenerateLearnerLicenseException exception )
	    {
		    return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);//Http: 400 error
	    }
	 
	 @ExceptionHandler(value=CannotUpdateApplicationException.class)
	    public ResponseEntity<String> handleexception(CannotUpdateApplicationException exception)
	    {
		    return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);//Http: 400 error
	    }
	 
	 @ExceptionHandler(value = DuplicateRequestException.class)
	    public ResponseEntity<String> exception(DuplicateRequestException ex){
		    return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_ACCEPTABLE);//Http: 406 error
	    }
	 
	 @ExceptionHandler(value=InvalidLoginCredentialsException.class)
     public ResponseEntity<String> handleexception(InvalidLoginCredentialsException exception){
	        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);//Http: 406 error
     }
	 
	 @ExceptionHandler(value=NoRecordsFoundException.class)
     public ResponseEntity<String> handleexception(NoRecordsFoundException exception){
	        return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NO_CONTENT);//Http: 204 error
     }
	 
	 @ExceptionHandler(value=NullInputException.class)
	    public ResponseEntity<String> handleNullInputexception(NullInputException exception){
		    return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_ACCEPTABLE);//Http: 406 error
	    }
	
	 @ExceptionHandler(value = RTOOfficerNotFoundException.class)
	    public ResponseEntity<String> exception(RTOOfficerNotFoundException exception1){
		    return new ResponseEntity<String>(exception1.getMessage(),HttpStatus.NOT_FOUND);//Http: 404 error
		
	    }
	
	 @ExceptionHandler(value = UserNotFoundException.class)
	    public ResponseEntity<String> exception(UserNotFoundException exception1){
		    return new ResponseEntity<String>(exception1.getMessage(),HttpStatus.NOT_FOUND);//Http: 404 error
		
	    }

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map> handleValidationExceptions(
		  MethodArgumentNotValidException ex) {
		    Map<String, String> errors = new HashMap<>();
		    ex.getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);});
		    return new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
		}
    
    
     //For Handling generic Exceptions
     @ExceptionHandler(Exception.class)//for handling else other exceptions
        public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
   
            ExceptionResponse expResp = new ExceptionResponse(new Date(),ex.getMessage(),"Generic Exception thrown");
            return new ResponseEntity(expResp,HttpStatus.INTERNAL_SERVER_ERROR);
        }



}
