package com.workspaceai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private static final String SYSTEM_INSTRUCTIONS = """
            You are the AI assistant for WorkspaceAI.

            WorkspaceAI is an extensible AI Workspace Platform that allows different AI-powered
            workspaces to operate on a common backend platform.

            Do not claim knowledge about WorkspaceAI that is not provided in the system
            instructions or conversation.
            """;

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chat(String message) {
        return chatClient.prompt()
                .system(SYSTEM_INSTRUCTIONS)
                .user(message)
                .call()
                .content();
    }
}