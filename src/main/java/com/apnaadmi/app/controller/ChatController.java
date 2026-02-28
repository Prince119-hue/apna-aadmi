package com.apnaadmi.app.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatController {

    // Temporary in-memory session store
    private final Map<String, Map<String, String>> sessions = new HashMap<>();

    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> payload) {

        String msg = payload.get("message").toLowerCase();
        String sessionId = payload.getOrDefault("sessionId", "default");

        sessions.putIfAbsent(sessionId, new HashMap<>());
        Map<String, String> data = sessions.get(sessionId);

        String reply;

        if (!data.containsKey("service")) {
            if (msg.contains("wedding")) {
                data.put("service", "Wedding Planning");
                reply = "Great! How many guests are expected?";
            } else {
                reply = "Please tell me your requirement (wedding, event, personal help).";
            }
        }

        else if (!data.containsKey("guests")) {
            data.put("guests", msg);
            reply = "Nice! How many support members do you need?";
        }

        else if (!data.containsKey("members")) {
            data.put("members", msg);
            reply = "Please share your phone number so we can contact you.";
        }

        else if (!data.containsKey("phone")) {
            if (!msg.matches("[0-9]{10}")) {
                reply = "Please enter a valid 10-digit phone number.";
            } else {
                data.put("phone", msg);

                // TEMPORARY: Just simulate saving
                System.out.println("New Lead Captured:");
                System.out.println(data);

                sessions.remove(sessionId);

                reply = "Thank you! 🎉 Our team will contact you shortly.";
            }
        }

        else {
            reply = "How else can I help you?";
        }

        return Map.of("reply", reply);
    }
}