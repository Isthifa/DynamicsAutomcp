package com.example.dynamicauto;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;

public class mcpTest {
    public static void main(String[] args) {

        var stdioParams = ServerParameters.builder("java")
                .args("-jar",
                        "target/DynamicAuto-0.0.1-SNAPSHOT.jar")
                .build();

        var transport = new StdioClientTransport(stdioParams);
        var client = McpClient.sync(transport).build();

        client.initialize();

        McpSchema.ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);


        client.closeGracefully();
    }
}
