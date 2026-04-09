package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.data.models.Role;
import com.managmentapplication.taskmanagement.data.models.Users;
import io.jsonwebtoken.Claims;

public interface JwtService {
    String generateToken(Users user);
    boolean validateToken(String token);
    String extractUsername(String token);
    Role extractRole(String token);
}
