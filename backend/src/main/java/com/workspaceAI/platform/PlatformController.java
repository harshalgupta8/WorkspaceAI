package com.workspaceai.platform;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformController {
    // Define your REST endpoints here
    @GetMapping("/api/platform/info")
    public PlatformInfoResponse getPlatformInfo() {
        
        PlatformInfoResponse response = new PlatformInfoResponse();
        response.setName("WorkspaceAI Platform");
        response.setVersion("0.1.0");
        response.setEnvironment("local");
        response.setJavaVersion(System.getProperty("java.version"));
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }
}
