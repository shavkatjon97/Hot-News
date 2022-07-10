package shavkatjon.hotnews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import shavkatjon.hotnews.entity.User;
import shavkatjon.hotnews.payload.ApiResponse;
import shavkatjon.hotnews.payload.dto.UserDto;
import shavkatjon.hotnews.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
//@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getCustomers() {
        List<User> customers = userService.getUsers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public User getCustomer(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public HttpEntity<ApiResponse> addCustomer(@Validated @RequestBody UserDto userDto) {

        ApiResponse apiResponse = userService.addUser(userDto);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> updateCustomer(@Validated @RequestBody UserDto userDto, @PathVariable String id) {

        ApiResponse apiResponse = userService.updateUser(userDto, id);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteCustomer(@Validated @PathVariable String id) {

        ApiResponse apiResponse = userService.deleteUser(id);

        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
