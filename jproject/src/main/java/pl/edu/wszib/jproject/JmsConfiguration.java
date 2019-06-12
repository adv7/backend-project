package pl.edu.wszib.jproject;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfiguration {
    @Bean
    public ConnectionFactory connectionFactory() {return new ActiveMQConnectionFactory("top://localhost:61616");}

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setDefaultDestinationName("out");
        return jmsTemplate;
    }

    @Bean
    public MqListener mqListener(JmsTemplate jmsTemplate) {return new MqListener(jmsTemplate);}

    @Bean
    public DefaultMessageListenerContainer defaultMessageListenerContainer(
            ConnectionFactory connectionFactory,
            MqListener mqListener
    ) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestinationName("in");
        container.setMessageListener(mqListener);

        return container;
    }
}
