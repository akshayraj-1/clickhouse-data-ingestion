package io.akshayraj.controllers;

import com.clickhouse.client.api.Client;
import com.clickhouse.client.api.data_formats.ClickHouseBinaryFormatReader;
import com.clickhouse.client.api.query.QueryResponse;
import io.akshayraj.dto.ClickHouseConnectRequest;
import io.akshayraj.services.ClickHouseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;

@RestController
@RequestMapping("/api/clickhouse")
@RequiredArgsConstructor
public class ClickHouseController {

    private final ClickHouseService clickHouseService;

    @PostMapping("/connect")
    public ResponseEntity<?> connect(@Valid @RequestBody ClickHouseConnectRequest connectRequest) {
        try {
            Client client = clickHouseService.getClientInstance(connectRequest);
            QueryResponse queryResponse = client.query("SELECT * FROM powershell_test_table LIMIT 5").get();
            ClickHouseBinaryFormatReader reader = client.newBinaryFormatReader(queryResponse);

            while (reader.hasNext()) {
                reader.next();
                String eventId = reader.getString("event_id");
                System.out.println(eventId);
            }
            return ResponseEntity.ok().body(Collections.singletonMap("success", true));
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }



}
