package com.genc.warranty_reminder.api;

import com.genc.warranty_reminder.DTO.LogInResponse;
import com.genc.warranty_reminder.DTO.LoginRequest;
import com.genc.warranty_reminder.DTO.UserDetails;
import com.genc.warranty_reminder.DTO.UserRegistrationResponse;
import com.genc.warranty_reminder.service.AuthenticationService;
import com.genc.warranty_reminder.model.UserAuthenticationData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserAuthentication {
    private final AuthenticationService authenticationService;
    @PostMapping(path="/userRegistration",consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponse> userRegistration(@RequestBody UserAuthenticationData user)
    {
        return new  ResponseEntity<>(authenticationService.createUser(user), HttpStatus.OK);
    }
    @GetMapping("/userRegistration/{id}")
    public ResponseEntity<UserDetails>getUser(@PathVariable("id")  String id)
    {
        return new ResponseEntity<>(authenticationService.getOneUser(id),HttpStatus.OK);
    }
    @GetMapping("/userRegistration")
    public ResponseEntity<List<UserDetails>>getAllUser()
    {
        return new ResponseEntity<>(authenticationService.getAlluser(),HttpStatus.OK);

    }
    @DeleteMapping("/userRegistration/{id}")
    public ResponseEntity<Void>deleteOneUser(@PathVariable("id") String id)
    {
        authenticationService.deleteOneUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/userRegistration")
    public ResponseEntity<UserRegistrationResponse>updateUserDetails(@RequestBody UserDetails updatedUser)
    {
        return new ResponseEntity<>(authenticationService.updateUser(updatedUser),HttpStatus.OK);
    }
    @PostMapping(path="/userSignIn",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogInResponse>CanWeAllowThisRequest(@RequestBody LoginRequest request)
    {
        return new ResponseEntity<>(this.authenticationService.userSignIn(request),HttpStatus.OK);
    }







}
