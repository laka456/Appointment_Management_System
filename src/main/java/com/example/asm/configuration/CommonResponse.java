package com.example.asm.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResponse {
    private int status;
    private String message;
    private Object data;
}
