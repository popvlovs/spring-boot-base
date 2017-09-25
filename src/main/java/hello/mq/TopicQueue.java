package hello.mq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

@Configuration
public class TopicQueue {
    @Bean
    public Topic queue() {
        return new ActiveMQTopic("sample.topic");
    }
}
