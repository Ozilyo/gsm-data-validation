package com.interfaceco.validationtool.actiontracker.revision;

import org.hibernate.envers.RevisionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.interfaceco.validationtool.config.AuditorAwareImp;
import com.interfaceco.validationtool.usermanagement.service.AccountService;
import com.interfaceco.validationtool.usermanagement.service.AccountServiceImpl;

//@Component
public class UserRevisionListener implements RevisionListener {

//	@Autowired
//	private AccountService accountService = new AccountServiceImpl();
	
//	@Autowired
	private AuditorAware<String> auditorAware = new AuditorAwareImp<String>();
	
	@Override
	public void newRevision(Object revisionEntity) {
		((UserRevisionEntity) revisionEntity).setUsername(auditorAware.getCurrentAuditor());
//		((UserRevisionEntity) revisionEntity).setUsername("Ali");
		
	}

}
