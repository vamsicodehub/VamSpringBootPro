package com.vamsi.sbs.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {
	
//	final static Logger logger = Logger.getLogger(GlobalExceptionController.class);

	@ExceptionHandler({ Exception.class })
	public String handleAllException(Exception ex) {

		String exceptionMsg = getExceptionMsg(ex);
		/*
		 * Logging all elements in the log file
		 */
//		logger.error(exceptionMsg, ex);

		ex.printStackTrace();

		/*d
		 * This Exception is thrown when ever their is a server side validation
		 * failure <p> for example if the parameters sent during loginRequest
		 * fails the validation line the password entered is not numeric
		 * respective exception message will be returned in the response
		 */
		

		return exceptionMsg;
	}
	
	private String getExceptionMsg(Exception ex) {
		Throwable cause = ex.getCause();

		while (cause != null) {
			if (null == cause.getCause()) {
				break;
			}
			cause = cause.getCause();
		}
		return null != cause ? (null != cause.getMessage() ? cause.getMessage()
				: cause.toString()) : ex.getMessage();
	}
}
