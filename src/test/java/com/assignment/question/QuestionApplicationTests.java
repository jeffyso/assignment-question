package com.assignment.question;

import com.assignment.question.controller.QuestionController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionApplicationTests{

	@Autowired
	private MockMvc mvc;

	@Test
	void createQuestion() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders
				.post("/api/v1/question")
						.content("{\"question\":\"age\"}")
								.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
