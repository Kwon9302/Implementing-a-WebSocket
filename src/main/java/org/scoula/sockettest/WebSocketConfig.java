package org.scoula.sockettest;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
//         index.html에서 sendMessage()
//        stompClient.send("/app/message", {}, JSON.stringify(message));

        registry.enableSimpleBroker("/topic", "/queue");
//        "/topic/..." 경로로 메시지를 보내면 이 메시지는 브로커로 향하게 되고
//        브로커는 이 경로를 구독 중인 구독자들에게 메시지를 발송한다.

        registry.setApplicationDestinationPrefixes("/app");
//        우리는 "/app" 접두사가 붙은 경로는 @MessageMapping 어노테이션이 붙은 곳을 타겟으로 한다는 설정을 한 것이다.
//        즉 "/app/..." 경로로 메시지를 보내면
//        이 메시지는 @MessageMapping 어노테이션이 붙은 곳으로 향하게 된다.
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }
}
