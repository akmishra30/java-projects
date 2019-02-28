package com.makhir.springboot.jms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import com.makhir.springboot.jms.exception.CustomErrorHandler;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJms
@Slf4j
public class JmsConfiguration {
	
	@Value("${spring.activemq.brocker-url}")
	private String brokerUrl;
	
	@Value("${spring.activemq.user}")
	private String username;
	
	@Value("${spring.activemq.password}")
	private String password;
	
	@Bean
	public ActiveMQConnectionFactory getAmqConnectionFactory() {
		log.info("### Setting up activemq connection factory object");
		log.info("### amq connection details: {}, {}", brokerUrl, username);
		log.info("### Setting up activemq connection factory object");
	    ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory();
	    amqConnectionFactory.setBrokerURL(brokerUrl);
		amqConnectionFactory.setUserName(username);
		amqConnectionFactory.setPassword(password);

		return amqConnectionFactory;
	 }

	@Bean
    public JmsListenerContainerFactory<?> getConnectionFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
		log.info("### Setting up activemq JmsListenerContainerFactory factory object");
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(getAmqConnectionFactory());
        factory.setConcurrency("5-10");     //lower-upper = Min no. of cosumer and scale upto max no. of cosumers
        factory.setErrorHandler(new CustomErrorHandler());
        configurer.configure(factory, connectionFactory);
        
        // You could still override some of Boot's default if necessary.
        return factory;
    }
	
	@Bean
	public JmsTemplate jmsTemplate(){
		log.info("### Setting up jmsTemplate object");
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(getAmqConnectionFactory());
	    return template;
	}
}
