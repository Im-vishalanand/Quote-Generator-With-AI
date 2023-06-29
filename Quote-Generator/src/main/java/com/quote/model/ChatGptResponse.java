package com.quote.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptResponse {

	private List<Choice> choices;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Choice{
		
		private int index;
		
		private Message message;
	}
	
}
