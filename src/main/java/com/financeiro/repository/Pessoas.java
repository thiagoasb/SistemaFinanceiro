package com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.financeiro.domain.Pessoa;

public class Pessoas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public Pessoas(EntityManager manager) {
		this.manager = manager;
	}
	
	public Pessoa porId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> todas(){
		TypedQuery<Pessoa> query = manager.createQuery("FROM Pessoa", Pessoa.class);
		
		return query.getResultList();
	}

}
