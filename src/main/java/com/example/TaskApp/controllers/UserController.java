package com.example.TaskApp.controllers;

import com.example.TaskApp.models.UserModel;
import com.example.TaskApp.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final IUserService userService;

    @GetMapping("/get-list")
    public List<UserModel> getList() {
        return userService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED) // Set the response status for created resources
    public UserModel create(@RequestBody @Valid UserModel userModel) {
        return userService.create(userModel);
    }

    @PutMapping("/update/{id}") // Using PathVariable for better REST practice
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody @Valid UserModel userModel, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        userModel.setId(id); // Ensure the ID is set for the update
        return ResponseEntity.ok(userService.update(userModel));
    }

    @DeleteMapping("/delete/{id}") // Using PathVariable for better REST practice
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}

