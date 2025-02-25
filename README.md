# Rest-Crud

# Performed Exception Handling 

    Exception Handling in REST 
    1. Update Rest service to throw the exception if the Required Data is not found
    2. Add an exception handler method using **@ExceptionHandler**

  Steps : 

    1) create a error resopnse class

        public class EmployeeErrorReponse{
            private int status;
            private String message;
            private long timeStamp;
            //add getters and setters
        }
        
    2) create a exception class 
        public class EmployeeNotFoundException extends RuntimeException{
            public EmployeeNotFoundException(String message){
                super(message);
            }
        }
    
    3) create a Exception Handling Method in controller class
    ex :    
        @ExceptionHandler
        public ReponseEntity<EmployeeErrorReponse> handleException(EmployeeNotFoundException e ) {
            EmployeeErrorReponse error = new EmployeeErrorReponse();
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(e.getMessage());
            error.setTimeStamp(System.currentTimeMillis());
        }



# Global Exception Handling
    
    | -------- |            |------------------- |
    |          |            | Controller         |
    |  Rest    |--------->  | Advice             |
    |  Client  | <--------  |   |----------------|
    |          |            |   |ExceptionHadnler|
    | -------- |            | ----------- -------|


    use @ControllerAdvice

  
# URI versioning
    Versioning a Spring REST endpoint
    -- Versioning is an sevice which becomes omport tant when we want to create different versions if an already existing service

    ex : 
        version1 -> GET http://localhost:9090/api/employees/v1/2
          or 
        version2 -> GET http://localhost:9090/api/employees/v2/1

      Version 1
          @GetMapping(value = "/employees/v1/{id}")
          public ResponseEntity<Employee> getPlan(@PathVariable("id") int id){
              // returns the complete employee details
          }

      Version 2
          @GetMapping(value = "/employees/v2/{id}")
          public ResponseEntity<String> getPlan(@PathVariable("id") int id){
              // returns only emailId
          }
        
