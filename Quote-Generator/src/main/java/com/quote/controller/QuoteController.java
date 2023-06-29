package com.quote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.quote.model.ChatGptRequest;
import com.quote.model.ChatGptResponse;

@RestController
@RequestMapping("/quote")
@CrossOrigin("*")
public class QuoteController {
	
	@Value("${openai.model}")
	private String model;
	
	@Value("${openai.api.url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		
		ChatGptRequest chatGptRequest= new ChatGptRequest(model, "generate a quote on "+prompt);
		
		ChatGptResponse chatGptResponse = restTemplate.postForObject(apiUrl, chatGptRequest, ChatGptResponse.class);
		
		return chatGptResponse.getChoices().get(0).getMessage().getContent();
		
	}
}
