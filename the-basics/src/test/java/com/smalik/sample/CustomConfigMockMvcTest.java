package com.smalik.sample;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@ActiveProfiles("spring-test")
@AutoConfigureMockMvc
public class CustomConfigMockMvcTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testMyInfo() throws Exception {
		MvcResult mvcResult = mvc.perform(get("/myinfo")).andReturn();

		Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
		Assert.assertTrue(mvcResult.getResponse().getContentType().startsWith("application/json"));

		JsonNode node = new ObjectMapper().readTree(mvcResult.getResponse().getContentAsByteArray());
		Assert.assertTrue(node.has("message"));
		Assert.assertEquals("inside-spring-test", node.get("message").asText());
	}

	@TestConfiguration
	static class CustomConfiguration {

		@Bean
		public MessageService messageService() {
			return new MessageService() {
				@Override
				public String getMessage() {
					return "inside-spring-test";
				}
			};
		}
	}
}