package io.akshayraj.controllers;

import io.akshayraj.dto.ConnectionRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClickHouseController {

    @PostMapping("/api/connect")
    public @ResponseBody String connect(@RequestBody ConnectionRequest connectionRequest) {
        System.out.println("Received connection request: " + connectionRequest);
        return "Not Connected";
    }



}
