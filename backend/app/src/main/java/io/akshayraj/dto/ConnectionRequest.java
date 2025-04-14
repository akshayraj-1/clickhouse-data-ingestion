package io.akshayraj.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConnectionRequest {

    @NotBlank(message = "Please enter the host")
    public String host;

    @NotNull(message = "Please enter the port")
    @Min(value = 1, message = "Invalid port number")
    public Integer port;

    @NotBlank(message = "Please enter username")
    public String username;

    @NotBlank(message = "Please enter password")
    public String password;

}
