package pl.edu.wszib.jproject;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@AllArgsConstructor
public class MqListener implements MessageListener {
    private final JmsTemplate jmsTemplate;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                String textMessage = ((TextMessage)message).getText();
                System.out.println(textMessage);

                jmsTemplate.send(session -> session.createTextMessage(textMessage));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
