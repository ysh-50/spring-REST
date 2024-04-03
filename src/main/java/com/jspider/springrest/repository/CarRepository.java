package com.jspider.springrest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspider.springrest.pojo.Car;

@Repository
public class CarRepository {
	
	private EntityManagerFactory eMF;
	private EntityManager eM;
	private EntityTransaction eT;
	
	//open
	private void openConnection() {
		eMF = Persistence.createEntityManagerFactory("car");
		eM  = eMF.createEntityManager();
		eT  = eM.getTransaction();
	}
	
	//close
	private void closeConnection() {
		if (eMF!=null) {
			eMF.close();
		}
		if (eM!=null) {
			eM.close();
		}
		if (eT!=null) {
			if (eT.isActive()) {
				eT.rollback();
			}
		}
	}
	
	//ADD CAR
	public Car addCar(Car car) {
		openConnection();
		eT.begin();
		eM.persist(car);
		eT.commit();
		closeConnection();
		return car;
	}

}
