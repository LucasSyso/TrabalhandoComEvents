package com.lucas.business;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.lucas.model.Estado;
import com.lucas.model.Regiao;

public class RegioesProvider {
	
	private static final Map<String, Regiao> regioesMap = new TreeMap<>();
	
	static {
		Regiao regiao = null;
		Estado estado = null;
		
		regiao = new Regiao("Sul", "S");
		regioesMap.put("S", regiao);
		
		estado = new Estado("RS", "Rio Grande do Sul", regiao);
		regiao.getEstados().add(estado);
		
		estado = new Estado("SC", "Santa Catarina", regiao);
		regiao.getEstados().add(estado);
		
		estado = new Estado("PR", "Paraná", regiao);
		regiao.getEstados().add(estado);
		
		
		regiao = new Regiao("Sudeste", "SE");
		regioesMap.put("SE", regiao);
		
		estado = new Estado("SP", "São Paulo", regiao);
		regiao.getEstados().add(estado);
		
		estado = new Estado("MG", "Minas Gerais", regiao);
		regiao.getEstados().add(estado);
		
		estado = new Estado("RJ", "Rio de Janeiro", regiao);
		regiao.getEstados().add(estado);
		
		
		regiao = new Regiao("Nordeste", "NE");
		regioesMap.put("NE", regiao);
		
		estado = new Estado("BA", "Bahia", regiao);
		regiao.getEstados().add(estado);
		
		estado = new Estado("SE", "Sergipe", regiao);
		regiao.getEstados().add(estado);
	}
	
	public static Collection<Regiao> getRegioes(){
		return regioesMap.values();
	}
	
	public static Collection<Estado> getEstadosByRegiao(String siglaRegiao){
		Regiao regiao = regioesMap.get(siglaRegiao);
		if(regiao == null) {
			return Collections.emptyList();
		}
		return regiao.getEstados();
	}
	
}
