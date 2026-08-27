package com.workspaceai.platform;

public class PlatformController {
    // Define your REST endpoints here
    @GetMapping("/api/platform/info")
    public PlatformInfoResponse getPlatformInfo() {
        
        PlatformInfoResponse response = new PlatformInfoResponse();
        response.setName("WorkspaceAI Platform");
        response.setVersion("0.1.0");
        response.setEnvironment("local");
        response.setJavaVersion(System.getProperty("java.version"));
        response.setUptime(ManagementFactory.getRuntimeMXBean().getUptime() + " ms");
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }
}
