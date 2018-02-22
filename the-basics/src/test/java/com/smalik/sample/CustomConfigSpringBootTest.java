package com.smalik.sample;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ActiveProfiles("spring-test")
public class CustomConfigSpringBootTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testMyInfo() throws Exception {

		ResponseEntity<JsonNode> responseEntity = restTemplate.getForEntity("/myinfo", JsonNode.class);

		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertTrue(responseEntity.getHeaders().getContentType().isCompatibleWith(MediaType.APPLICATION_JSON));

		Assert.assertTrue(responseEntity.getBody().has("message"));
		Assert.assertEquals("inside-spring-test", responseEntity.getBody().get("message").asText());
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