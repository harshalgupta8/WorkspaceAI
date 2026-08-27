package com.workspaceai.platform;

import com.workspaceai.config.WorkspaceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatformController {
    private final WorkspaceProperties workspaceProperties;

    public PlatformController(WorkspaceProperties workspaceProperties) {
        this.workspaceProperties = workspaceProperties;
    }

    @GetMapping("/api/platform/info")
    public PlatformInfoResponse getPlatformInfo() {
        PlatformInfoResponse response = new PlatformInfoResponse();
        response.setName(workspaceProperties.getName());
        response.setVersion(workspaceProperties.getVersion());
        response.setEnvironment(workspaceProperties.getEnvironment());
        return response;
    }
}
