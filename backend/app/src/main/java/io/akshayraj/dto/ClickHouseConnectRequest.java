package io.akshayraj.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClickHouseConnectRequest {

    @NotBlank(message = "Please enter the host")
    private String host;

    @NotNull(message = "Please enter the port")
    @Min(value = 1, message = "Invalid port number")
    private Integer port;

    @NotBlank(message = "Please enter the database name")
    private String database;

    @NotBlank(message = "Please enter connection token")
    private String token;
}
