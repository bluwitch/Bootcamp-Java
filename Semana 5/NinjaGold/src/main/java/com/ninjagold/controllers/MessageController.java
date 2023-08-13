package com.ninjagold.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class MessageController {

    @SuppressWarnings("unchecked")
	@GetMapping("/get-messages")
    public Map<String, List<String>> getMessages(HttpSession session) {
        List<String> messages = (List<String>) session.getAttribute("ganancias");
        Map<String, List<String>> response = new HashMap<>();
        response.put("messages", messages);
        return response;
    }
}
