package com.workspaceai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "workspace.platform")
public record WorkspaceProperties(
    String name,
    String version,
    String environment
) {
}