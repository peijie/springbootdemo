package com.mountainwind.sample.sample.mqservice;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleMqserviceApplication {
	
	  final static String queueName = "spring-boot";
	  
		@Bean
		public ConnectionFactory connectionFactory() {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
			return connectionFactory;
		}
		
		@Bean
		public AmqpAdmin amqpAdmin() {
			return new RabbitAdmin(connectionFactory());
		}
		
		@Bean
		public RabbitTemplate rabbitTemplate() {
			RabbitTemplate template = new RabbitTemplate(connectionFactory());
			//The routing key is set to the name of the queue by the broker for the default exchange.
			template.setRoutingKey(queueName);
			//Where we will synchronously receive messages from
			template.setQueue(queueName);
			return template;
		}

	    @Bean
	    Queue queue() {
	        return new Queue(queueName, false);
	    }

	    @Bean
	    TopicExchange exchange() {
	        return new TopicExchange("spring-boot-exchange");
	    }

	    @Bean
	    Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with(queueName);
	    }

	    @Bean
	    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	            MessageListenerAdapter listenerAdapter) {
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.setQueueNames(queueName);
	        container.setMessageListener(listenerAdapter);
	        return container;
	    }

	    @Bean
	    Receiver receiver() {
	        return new Receiver();
	    }

	    @Bean
	    MessageListenerAdapter listenerAdapter(Receiver receiver) {
	        return new MessageListenerAdapter(receiver, "receiveMessage");
	    }
	    
	    
	    

//		@Bean
//		// Every queue is bound to the default direct exchange
//		public Queue helloWorldQueue() {
//			return new Queue(this.helloWorldQueueName);
//		}

		/*
		@Bean 
		public Binding binding() {
			return declare(new Binding(helloWorldQueue(), defaultDirectExchange()));
		}*/
		
		/*	
		@Bean
		public TopicExchange helloExchange() {
			return declare(new TopicExchange("hello.world.exchange"));
		}*/
		
		/*
		public Queue declareUniqueQueue(String namePrefix) {
			Queue queue = new Queue(namePrefix + "-" + UUID.randomUUID());
			rabbitAdminTemplate().declareQueue(queue);
			return queue;
		}
		
		// if the default exchange isn't configured to your liking....
		@Bean Binding declareP2PBinding(Queue queue, DirectExchange exchange) {
			return declare(new Binding(queue, exchange, queue.getName()));
		}
		
		@Bean Binding declarePubSubBinding(String queuePrefix, FanoutExchange exchange) {
			return declare(new Binding(declareUniqueQueue(queuePrefix), exchange));
		}
		
		@Bean Binding declarePubSubBinding(UniqueQueue uniqueQueue, TopicExchange exchange) {
			return declare(new Binding(uniqueQueue, exchange));
		}
		
		@Bean Binding declarePubSubBinding(String queuePrefix, TopicExchange exchange, String routingKey) {
			return declare(new Binding(declareUniqueQueue(queuePrefix), exchange, routingKey));
		}*/

	    
	    

	public static void main(String[] args) {
		SpringApplication.run(SampleMqserviceApplication.class, args);
	}



	
	
}
