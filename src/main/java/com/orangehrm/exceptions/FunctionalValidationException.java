package com.orangehrm.exceptions;

public class FunctionalValidationException extends AssertionError{

  public FunctionalValidationException(String message, Throwable cause){
    super(message, cause);
    this.initCause(cause);
  }
}
