package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plataformalancamento.model.DespesaModel;
import br.com.plataformalancamento.service.DespesaService;
import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/despesa")
public class DespesaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private DespesaService despesaService;
	
	@GetMapping()
	public ResponseEntity<List<DespesaModel>> findAll() {
		List<DespesaModel> despesaModelList = this.despesaService.findAll();
		return ResponseEntity.ok().body(despesaModelList);
	}
	
	@PostMapping("persist")
	public ResponseEntity<Void> persist(@RequestBody DespesaModel despesaModel) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/despesa/persist").buildAndExpand(despesaModel.getCodigo()).toUri();
		this.despesaService.persist(despesaModel);
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("{codigo}")
	public ResponseEntity<DespesaModel> findOne(@PathVariable Long codigo) throws ObjectNotFoundException {
		DespesaModel despesaModel = this.despesaService.findOne(codigo);
		return ResponseEntity.ok().body(despesaModel);
	}
	
	@DeleteMapping("{codigo}")
	public ResponseEntity<Void> remove(@PathVariable Long codigo) {
		this.despesaService.remove(codigo);
		return ResponseEntity.noContent().build();
	}

}
