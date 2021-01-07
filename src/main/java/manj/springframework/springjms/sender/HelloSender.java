package manj.springframework.springjms.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import manj.springframework.springjms.config.JmsConfig;
import manj.springframework.springjms.model.HelloWorldMessage;

@Component
@RequiredArgsConstructor
public class HelloSender {
	private final JmsTemplate jmsTemplate;

	@Scheduled(fixedRate = 2000)
	public void sendMessage() {

		System.out.println("I'm Sending a message");

		HelloWorldMessage message = HelloWorldMessage.builder().id(UUID.randomUUID()).message("Hello World!").build();

		jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

		System.out.println("Message Sent!");

	}
}
