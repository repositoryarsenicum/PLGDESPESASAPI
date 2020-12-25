package br.com.plataformalancamento.controller;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoDespesaEnumeration;
import br.com.plataformalancamento.enumeration.TipoFontePagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoFormaPagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoProdutoServicoEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;
import br.com.plataformalancamento.model.DespesaModel;
import br.com.plataformalancamento.service.DespesaService;

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
	public ResponseEntity<Void> persist() {
		DespesaModel despesaModel = new DespesaModel();
			despesaModel.setCodigo(null);
			despesaModel.setTipoDespesaEnumeration(TipoDespesaEnumeration.DESPESA_FIXA);
			despesaModel.setTipoProdutoServicoEnumeration(TipoProdutoServicoEnumeration.FATURA);
			despesaModel.setTipoFormaPagamentoEnumeration(TipoFormaPagamentoEnumeration.BOLETO_BANCARIO);
			despesaModel.setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration.PENDENTE);
			despesaModel.setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration.INTERNET_BANCKING);
			despesaModel.setTipoFontePagamentoEnumeration(TipoFontePagamentoEnumeration.BANCO_SANTANDER);
			despesaModel.setDataPagamento(new Date());
			despesaModel.setDataVencimento(new Date());
			despesaModel.setNumeroParcela(12);
			despesaModel.setObservacao(null);
			despesaModel.setValorAdicional(0D);
			despesaModel.setValorDesconto(0D);
			despesaModel.setValorFinal(5000D);
			despesaModel.setValorInicial(5000D);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cliente/findone/{codigo}").buildAndExpand(despesaModel.getCodigo()).toUri();
		this.despesaService.persist(despesaModel);
		return ResponseEntity.created(uri).build();
	}

}
