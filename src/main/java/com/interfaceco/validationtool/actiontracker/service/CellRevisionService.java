package com.interfaceco.validationtool.actiontracker.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer.SessionFixationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.interfaceco.validationtool.actiontracker.revision.UserRevisionEntity;
import com.interfaceco.validationtool.gsmparams.model.Cell;

//@Service
@Component
public class CellRevisionService {

	// @PersistenceContext
	// private EntityManager entityManager;
	//
	// @Autowired
	// private EntityManagerFactory factory;

	//// @Autowired
	// private AuditReader auditReader =
	//// AuditReaderFactory.get(getSessionFactory().getCurrentSession());
	//
	// public AuditReader getAuditReader() {
	// return auditReader;
	// }

	@Autowired
//	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Bean
	public AuditReader getAuditReader() {
//		if (sessionFactory.) {
//			entityManager.getTransaction().commit();
//			entityManager.close();
//			System.err.println(sessionFactory.getCurrentSession().toString());
//			sessionFactory.getCurrentSession().close();
//			System.err.println(sessionFactory.getCurrentSession().toString());
//			System.err.println("in the if condition ....");
//			Session session = sessionFactory.openSession();
//			System.err.println(sessionFactory.getCurrentSession().toString());
//			return AuditReaderFactory.get(session);
//		}
		
		return AuditReaderFactory.get(entityManager);
	}

	// @Bean
	// public SessionFactory getSessionFactory() {
	// if (factory.unwrap(SessionFactory.class) == null) {
	// throw new NullPointerException("factory is not a hibernate factory");
	// }
	// return factory.unwrap(SessionFactory.class);
	// }
	
	public Collection<UserRevisionEntity> getAllRivisionForEntity(Integer id) {
		AuditReader reader = AuditReaderFactory.get(sessionFactory.openSession());
		Set<Number> allCellRevisions = new HashSet<Number>(reader.getRevisions(Cell.class, id));
//		Collections.sort((List<Number>) allCellRevisions);
		Map<Number, UserRevisionEntity> allCellRevEntities = reader.findRevisions(UserRevisionEntity.class,
				allCellRevisions);
		System.err.println(allCellRevisions);
		System.err.println(allCellRevEntities.values());
//		
		Collection<UserRevisionEntity> allCellRevEntitiesAsCollection = new ArrayList<>(allCellRevEntities.values());
		Collections.sort((List<UserRevisionEntity>) allCellRevEntitiesAsCollection);
		return allCellRevEntitiesAsCollection;
	}

	private Set<Number> getAllRevisionsForCell(Integer id) {
		Set<Number> allCellRevisions = new HashSet<Number>(getAuditReader().getRevisions(Cell.class, id));
		System.err.println(allCellRevisions);
		return allCellRevisions;
	}

	public List<Cell> getAllVersionsForCell(Integer revNum) {

		System.err.println(getAuditReader().toString());
		List<Cell> entities = new ArrayList<>();
		for (Number revId : getAllRevisionsForCell(revNum)) {
			entities.add(getAuditReader().find(Cell.class, revNum, revId));
		}
		System.err.println(entities);
		return entities;
	}


	public List<UserRevisionEntity> queryRevisionsWithUsername(String username) {
		AuditQuery query = getAuditReader().createQuery().forRevisionsOfEntity(UserRevisionEntity.class, false, true);
		List<UserRevisionEntity> revisionEntities = query.getResultList();
		
		return revisionEntities;
	}

	public Cell getCellEditedInRevision(Integer revNum, Integer cellId) {
		Cell cell = getAuditReader().find(Cell.class, cellId ,revNum);
		System.err.println("cell: "+cell);
		return cell;
	}
}
