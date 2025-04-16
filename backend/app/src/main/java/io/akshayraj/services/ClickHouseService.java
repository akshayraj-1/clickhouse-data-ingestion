package io.akshayraj.services;

import com.clickhouse.client.api.Client;
import com.clickhouse.client.api.enums.Protocol;
import io.akshayraj.dto.ClickHouseConnectRequest;
import org.springframework.stereotype.Service;

@Service
public class ClickHouseService {

    public Client getClientInstance(ClickHouseConnectRequest connectRequest) throws IllegalArgumentException {

        boolean isSecure = connectRequest.getPort() == 8443 || connectRequest.getPort() == 9440;
        return new Client.Builder()
                .addEndpoint(Protocol.HTTP, connectRequest.getHost(), connectRequest.getPort(), isSecure)
                .httpHeader("Authorization", "Bearer " + connectRequest.getToken())
                .build();
    }
}
