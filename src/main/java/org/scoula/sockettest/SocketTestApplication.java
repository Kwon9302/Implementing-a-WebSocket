package org.scoula.sockettest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocketTestApplication.class, args);
    }

// 1.   "/topic"으로 시작하는 경로는 메시지 브로커를 향하도록 설정한다.
// 2.   "/app"으로 시작하는 경로는 @MessageMapping을 향하도록 설정한다.
// 3.   구독자는 "/topic/public"으로 시작하는 경로를 구독한다. (1번 설정 때문에)
// 4.   발행자는 "/app/message"로 시작하는 경로로 메시지를 보낸다.
// 5.   2번 설정 때문에 @MessageMapping("/message")가 붙어있는 곳으로 메시지가 간다.
// 6.   메시지 가공이 끝난 후 ("/topic/public")로 보낸다.
// 7.   1번 설정 때문에 이 메시지는 메시지 브로커로 가게 된다.
// 8.   메시지 브로커에서 "/topic/public"를 구독 중인 구독자들에게 메시지를 전송한다.
}
