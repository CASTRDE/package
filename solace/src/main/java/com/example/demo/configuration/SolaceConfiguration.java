package com.example.demo.configuration;

import com.solacesystems.jms.SolConnectionFactory;
import com.solacesystems.jms.SolJmsUtility;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Session;

public class SolaceConfiguration {
    @Bean
    public SolConnectionFactory solConnectionFactoryListener(){
        try{
            String connectionValue = null;
            SolConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
            //String solaceHost = "localhost:55554";
            String solaceHost = "10.222.106.67:55554";

            connectionFactory.setHost(solaceHost);

            connectionFactory.setVPN("default");
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("IJnQc4mASn");

            connectionValue = connectionFactory.toString();
            return connectionFactory;
        }
        catch (Exception exception){
            return null;
        }
    }

    @Bean
    public SolConnectionFactory solConnectionFactoryLocal(){
        try{
            String connectionValue = null;
            SolConnectionFactory connectionFactory = SolJmsUtility.createConnectionFactory();
            String solaceHost = "localhost:55554";
            //String solaceHost = "10.222.106.67:55554";

            connectionFactory.setHost(solaceHost);

            connectionFactory.setVPN("default");
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("IJnQc4mASn");

            connectionValue = connectionFactory.toString();
            return connectionFactory;
        }
        catch (Exception exception){
            return null;
        }
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        CachingConnectionFactory ccf = new CachingConnectionFactory(solConnectionFactoryListener());
        JmsTemplate jmsTemplate = new JmsTemplate(ccf);

        return jmsTemplate;
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory () {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(solConnectionFactoryLocal());
        factory.setConcurrency("1");
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);

        return factory;
    }
}
