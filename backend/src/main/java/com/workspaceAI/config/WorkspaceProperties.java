package com.workspaceai.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//using records class to hold the workspace platform properties
@ConfigurationProperties(prefix = "workspace.platform")
public record WorkspaceProperties(
    String name,
    String version,
    String environment
) {
}