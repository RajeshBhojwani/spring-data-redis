package org.acn.config;

import javax.inject.Inject;

import org.acn.service.BookService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class SpringContextListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Inject 
	private BookService bookService;

	/**
	 * This method will run on application startup and load up the default book
	 * collection into the Redis database.
	 */
	public void onApplicationEvent(ContextRefreshedEvent event) {
		bookService.restoreDefaultBooks();
	};
}
