package manj.springframework.springjms.listener;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import manj.springframework.springjms.config.JmsConfig;
import manj.springframework.springjms.model.HelloWorldMessage;

@Component
public class HelloMessageListener {
	
	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage,
						@Headers MessageHeaders messageHeaders, Message message) {
		
		System.out.println("I Got a Message!!!!!");

        System.out.println(helloWorldMessage);


        // uncomment and view to see retry count in debugger
       // throw new RuntimeException("foo");
		
	}

}
