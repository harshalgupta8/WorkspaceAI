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
        return new PlatformInfoResponse(
            workspaceProperties.name(),
            workspaceProperties.version(),
            workspaceProperties.environment()
        );
    }
}
