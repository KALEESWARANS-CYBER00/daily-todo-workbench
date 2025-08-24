package com.todo.workbench.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String identifier; // username OR email
    private String password;
}
