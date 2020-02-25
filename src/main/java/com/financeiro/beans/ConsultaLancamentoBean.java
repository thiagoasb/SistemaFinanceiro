package com.financeiro.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.financeiro.domain.Lancamento;
import com.financeiro.repository.Lancamentos;
import com.project.financeiro.Financeiro.JpaUtil;

@ManagedBean(name = "consultaLancamentoBean")
@ViewScoped
public class ConsultaLancamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos;
	
	@PostConstruct
	public void consultar() {
		EntityManager manager = JpaUtil.getEntityManager();
		Lancamentos lancamentos = new Lancamentos(manager);
		
		this.lancamentos = lancamentos.todos();
		
		manager.close();
	}
	
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	

}
