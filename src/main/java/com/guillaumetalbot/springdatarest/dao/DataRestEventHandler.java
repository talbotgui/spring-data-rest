package com.guillaumetalbot.springdatarest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.guillaumetalbot.springdatarest.entite.Donnee;

@RepositoryEventHandler
public class DataRestEventHandler {

	private static final Logger LOG = LoggerFactory.getLogger(DataRestEventHandler.class);

	@HandleBeforeSave
	public void avantSauvegardeUtilisateur(final Donnee d) {
		LOG.info("avant la sauvegarde de la donnee '{}'", d.getId());
	}

	@HandleBeforeDelete
	public void avantSuppressionUtilisateur(final Donnee d) {
		LOG.info("avant la suppression de la donnee '{}'", d.getId());
	}
}
