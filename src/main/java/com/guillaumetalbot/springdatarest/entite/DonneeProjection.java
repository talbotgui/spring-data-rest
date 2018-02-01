package com.guillaumetalbot.springdatarest.entite;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

/**
 * Pour utiliser cette visualisation, ajouter ?projection=donneeProjection
 */
@Projection(name = "donneeProjection", types = { Donnee.class })
public interface DonneeProjection {

	/** Cette méthode peut passer outre la directive @JsonIgnore. */
	String getDescription();

	// Id masqué
	// Long getId();

	@Value("#{target.description}|#{target.description}")
	String getDescriptionDoublee();
}
