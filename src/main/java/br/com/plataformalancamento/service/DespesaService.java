package br.com.plataformalancamento.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
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
	public DespesaModel findOne(Long codigo) {
		Optional<DespesaModel> despesaModelOptional = this.despesaRepository.findById(codigo);
		if(despesaModelOptional.isPresent()) {
			DespesaModel despesaModel = despesaModelOptional.get();
			return despesaModel;
		} else {
			throw new RuntimeErrorException(null, "Despesa não encontrada!");
		}
	}
	
	@Transactional
	public void persist(DespesaModel despesaModel) {
		this.despesaRepository.save(despesaModel);
		
	}
	
	@Transactional
	public void remove(Long codigo) {
		DespesaModel despesaModel = this.findOne(codigo);
		this.despesaRepository.deleteById(despesaModel.getCodigo());
	}

}
