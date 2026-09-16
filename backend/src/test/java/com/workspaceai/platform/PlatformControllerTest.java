package com.workspaceai.platform;

import com.workspaceai.config.WorkspaceProperties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlatformController.class)
@Import(PlatformControllerTest.TestConfig.class)
class PlatformControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsPlatformInfo() throws Exception {
        mockMvc.perform(get("/api/platform/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("WorkspaceAI Platform"))
                .andExpect(jsonPath("$.version").value("0.1.0"))
                .andExpect(jsonPath("$.environment").value("local"));
    }

    @TestConfiguration
    static class TestConfig {

        @Bean
        WorkspaceProperties workspaceProperties() {
            return new WorkspaceProperties(
                    "WorkspaceAI Platform",
                    "0.1.0",
                    "local"
            );
        }
    }
}