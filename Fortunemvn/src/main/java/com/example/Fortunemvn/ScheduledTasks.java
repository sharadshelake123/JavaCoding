package com.example.Fortunemvn;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		 Date date = new Date();
		long msec = date.getTime()-100000;
	      Query query = entityManager.createQuery("UPDATE OTP SET otp_status = 'Expired' "
	                + "WHERE otp_status = 'Active' AND updated_date_time < :updated_date_time");
	        query.setParameter("updated_date_time", msec);
	        int rowsUpdated = query.executeUpdate();
	        log.info("UpadatedCount: "+rowsUpdated);
		
	}
}
