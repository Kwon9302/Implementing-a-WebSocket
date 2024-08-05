package org.scoula.sockettest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/topic/public")
    public Message receiveMessage(@Payload Message message){
        return message;
    }

//    "/message" 경로로 메시지가 날아오면 receiveMessage 메소드가 실행되어 Message 객체가 반환된다.
//    이 Message 객체는 @SendTo 어노테이션에 매핑되어있는 "/topic/public"를 구독하고 있는 모든 구독자들에게 메시지를 전달한다.

//    @MessageMapping("/private-message")
//    public void recMessage(@Payload Message message){
//        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
//        System.out.println(message.toString());
//    }
}
