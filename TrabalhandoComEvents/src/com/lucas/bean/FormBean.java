package com.lucas.bean;

import java.io.Serializable;
import java.util.Collection;

//import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
//import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucas.business.RegioesProvider;
import com.lucas.model.Estado;
import com.lucas.model.Regiao;

@SuppressWarnings("serial")
@Named("form")
@SessionScoped
public class FormBean implements Serializable{
	
	Collection<Regiao> regioes;
	Collection<Estado> estados;
	private String siglaRegiao;
	private String siglaEstado;
	private String cidade;
	
	@Inject
	FacesContext context;
	
	/*
	 * 
	 * Método que é chamado após a construção deste bean
	 * 
	 * */
//	@PostConstruct
//	public void init() {
//		regioes = RegioesProvider.getRegioes();
//	}
	
//	public void carregarEstados(ActionEvent event) {
//		this.estados = RegioesProvider.getEstadosByRegiao(siglaRegiao);
//	}
	
	//Como o evento ValueChangeEvent não consegue pegar as propriedades do bean ainda populadas, temos que usar seu método chamado getNewValue() para obter o novo valor 
	public void carregarEstados(ValueChangeEvent event) {
		this.estados = RegioesProvider.getEstadosByRegiao(event.getNewValue().toString());

		context.renderResponse();//Faz com que o Render Response seja processada pulando as outras fases.
	}
	
	
	//É um método que possui o mesmo efeito do init() que é anotado com o @PostConstruct
	public void carregarRegioes(ComponentSystemEvent event) {
		regioes = RegioesProvider.getRegioes();
	}
	
	
	public Collection<Regiao> getRegioes() {
		return regioes;
	}
	public void setRegioes(Collection<Regiao> regioes) {
		this.regioes = regioes;
	}
	
	public Collection<Estado> getEstados() {
		return estados;
	}
	public void setEstados(Collection<Estado> estados) {
		this.estados = estados;
	}
	
	public String getSiglaRegiao() {
		return siglaRegiao;
	}
	public void setSiglaRegiao(String siglaRegiao) {
		this.siglaRegiao = siglaRegiao;
	}
	
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	
}
