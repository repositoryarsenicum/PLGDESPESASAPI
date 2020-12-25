package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.plataformalancamento.model.DespesaModel;
import br.com.plataformalancamento.repository.DespesaRepository;

@Service
public class DespesaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Transactional
	public List<DespesaModel> findAll() {
		return this.despesaRepository.findAll();
	}
	
	@Transactional
	public void persist(DespesaModel despesaModel) {
		this.despesaRepository.save(despesaModel);
		
	}

}
