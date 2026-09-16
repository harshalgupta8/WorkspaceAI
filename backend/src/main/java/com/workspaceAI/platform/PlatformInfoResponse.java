package com.workspaceai.platform;

public record PlatformInfoResponse(
    String name,
    String version,
    String environment
) {
}
