package com.inq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inq.binding.LoginForm;
import com.inq.binding.SignUpForm;
import com.inq.binding.UnlockForm;
import com.inq.service.UserService;

@RestController
@RequestMapping("/enq")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpForm form) {
        boolean isSignedUp = userService.signUp(form);
        if (isSignedUp) {
            return new ResponseEntity<>("SignUp Successful! Please check your email to unlock your account.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Email already registered!", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginForm form) {
        String status = userService.login(form);
        if (status == null) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/unlock")
    public ResponseEntity<String> unlockAccount(@RequestBody UnlockForm form) {
        boolean isUnlocked = userService.unlockAccount(form);
        if (isUnlocked) {
            return new ResponseEntity<>("Account unlocked successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid temporary password", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/forgotpwd")
    public ResponseEntity<String> forgotPwd(@RequestParam String email) {
        String status = userService.forgotPwd(email);
        if (status != null) {
            return new ResponseEntity<>(status, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
        }
    }
}
