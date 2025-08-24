package com.todo.workbench.controller;

import com.todo.workbench.entity.User;
import com.todo.workbench.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepo;

    @PutMapping("/upgrade/{userId}")
    public ResponseEntity<?> upgradeUserLevel(@PathVariable Long userId, @RequestParam String level) {
        Optional<User> userOpt = userRepo.findById(userId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        User user = userOpt.get();
        if (!level.equalsIgnoreCase("LOW") &&
            !level.equalsIgnoreCase("MEDIUM") &&
            !level.equalsIgnoreCase("HIGH")) {
            return ResponseEntity.badRequest().body("Invalid level");
        }

        user.setLevel(level.toUpperCase());
        userRepo.save(user);
        return ResponseEntity.ok("User " + user.getUsername() + " upgraded to " + level);
    }
}
