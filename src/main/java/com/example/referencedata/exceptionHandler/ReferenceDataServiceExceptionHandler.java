package com.example.referencedata.exceptionHandler;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;

@Requires(classes = {Exception.class, ExceptionHandler.class})
public class ReferenceDataServiceExceptionHandler implements ExceptionHandler<Exception, HttpResponse<String>>{
	
	@Override
    public HttpResponse<String> handle(HttpRequest request, Exception exception) {
		return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to process request due to "+ exception.getMessage());
    }

}
