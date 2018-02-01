package com.guillaumetalbot.springdatarest.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Une configuration Spring-boot pour l'application. Cette classe remplace le traditionnel fichier XML.
 */
@SpringBootApplication
@EntityScan({ "com.guillaumetalbot.springdatarest.entite" })
@ComponentScan({})
@EnableJpaRepositories({ "com.guillaumetalbot.springdatarest.dao" })
@EnableGlobalMethodSecurity
public class RestApplication {

	/** Contexte applicatif démarré. */
	private static ApplicationContext ac;

	/** Configuration de la sécurité par défaut. */
	public static final String ADMIN_PAR_DEFAUT_LOGIN_MDP = "admin";
	public static final String ADMIN_PAR_DEFAUT_ROLE = "USER";

	/** Logger. */
	private static final Logger LOG = LoggerFactory.getLogger(RestApplication.class);

	/**
	 * Méthode de démarrage de l'application
	 *
	 * @param args
	 */
	public static void main(final String[] args) {
		ac = SpringApplication.run(RestApplication.class);

		// Log pour afficher l'URL de l'API
		final String port = ac.getEnvironment().getProperty("server.port");
		final String context = ac.getEnvironment().getProperty("server.context-path");
		LOG.info("Application disponible sur http://localhost:{}{}", port, context);
	}

	/**
	 * Méthode d'arrêt de l'application
	 */
	public static void stop() {
		if (ac != null) {
			SpringApplication.exit(ac);
		}
	}

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(ADMIN_PAR_DEFAUT_LOGIN_MDP).password(ADMIN_PAR_DEFAUT_LOGIN_MDP).roles(ADMIN_PAR_DEFAUT_ROLE);
	}

	/**
	 * Configuration des pages HTML du répertoire src/main/resources/templates.
	 *
	 * @return
	 */
	@Bean
	public WebMvcConfigurerAdapter configurerPagesHtml() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addViewControllers(final ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("index");
			}
		};
	}
}
