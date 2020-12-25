package br.com.plataformalancamento.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.plataformalancamento.enumeration.TipoCanalPagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoDespesaEnumeration;
import br.com.plataformalancamento.enumeration.TipoFontePagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoFormaPagamentoEnumeration;
import br.com.plataformalancamento.enumeration.TipoProdutoServicoEnumeration;
import br.com.plataformalancamento.enumeration.TipoSituacaoPagamentoEnumeration;

@Entity
@Table(name = "TB_DESPESA")
public class DespesaModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@JsonProperty("tipoDespesa")
	@Column(name = "TIPO_DESPESA")
	@Enumerated(EnumType.STRING)
	private TipoDespesaEnumeration tipoDespesaEnumeration;
	
	@JsonProperty("tipoProdutoServico")
	@Column(name = "TIPO_PRODUTO_SERVICO")
	@Enumerated(EnumType.STRING)
	private TipoProdutoServicoEnumeration tipoProdutoServicoEnumeration;
	
	@JsonProperty("tipoFormaPagamento")
	@Column(name = "TIPO_FORMA_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private TipoFormaPagamentoEnumeration tipoFormaPagamentoEnumeration;
	
	@JsonProperty("tipoSituacaoPagamento")
	@Column(name = "TIPO_SITUACAO_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration;
	
	@JsonProperty("tipoCanalPagamento")
	@Column(name = "TIPO_CANAL_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration;
	
	@JsonProperty("tipoFontePagamento")
	@Column(name = "TIPO_FONTE_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private TipoFontePagamentoEnumeration tipoFontePagamentoEnumeration;
	
	private Double valorInicial;
	
	private Double valorAdicional;
	
	private Double valorDesconto;
	
	private Double valorFinal;
	
	private Integer numeroParcela;
	
	private Date dataVencimento;
	
	private Date dataPagamento;
	
	private String observacao;

	public DespesaModel() { }

	public DespesaModel(TipoDespesaEnumeration tipoDespesaEnumeration,
			TipoProdutoServicoEnumeration tipoProdutoServicoEnumeration,
			TipoFormaPagamentoEnumeration tipoFormaPagamentoEnumeration,
			TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration,
			TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration,
			TipoFontePagamentoEnumeration tipoFontePagamentoEnumeration, Double valorInicial, Double valorAdicional,
			Double valorDesconto, Double valorFinal, Integer numeroParcela, Date dataVencimento, Date dataPagamento,
			String observacao) {
		super();
		this.tipoDespesaEnumeration = tipoDespesaEnumeration;
		this.tipoProdutoServicoEnumeration = tipoProdutoServicoEnumeration;
		this.tipoFormaPagamentoEnumeration = tipoFormaPagamentoEnumeration;
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
		this.tipoCanalPagamentoEnumeration = tipoCanalPagamentoEnumeration;
		this.tipoFontePagamentoEnumeration = tipoFontePagamentoEnumeration;
		this.valorInicial = valorInicial;
		this.valorAdicional = valorAdicional;
		this.valorDesconto = valorDesconto;
		this.valorFinal = valorFinal;
		this.numeroParcela = numeroParcela;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.observacao = observacao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public TipoDespesaEnumeration getTipoDespesaEnumeration() {
		return tipoDespesaEnumeration;
	}

	public TipoProdutoServicoEnumeration getTipoProdutoServicoEnumeration() {
		return tipoProdutoServicoEnumeration;
	}

	public TipoFormaPagamentoEnumeration getTipoFormaPagamentoEnumeration() {
		return tipoFormaPagamentoEnumeration;
	}

	public TipoSituacaoPagamentoEnumeration getTipoSituacaoPagamentoEnumeration() {
		return tipoSituacaoPagamentoEnumeration;
	}

	public TipoCanalPagamentoEnumeration getTipoCanalPagamentoEnumeration() {
		return tipoCanalPagamentoEnumeration;
	}

	public TipoFontePagamentoEnumeration getTipoFontePagamentoEnumeration() {
		return tipoFontePagamentoEnumeration;
	}

	public Double getValorInicial() {
		return valorInicial;
	}

	public Double getValorAdicional() {
		return valorAdicional;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void setTipoDespesaEnumeration(TipoDespesaEnumeration tipoDespesaEnumeration) {
		this.tipoDespesaEnumeration = tipoDespesaEnumeration;
	}

	public void setTipoProdutoServicoEnumeration(TipoProdutoServicoEnumeration tipoProdutoServicoEnumeration) {
		this.tipoProdutoServicoEnumeration = tipoProdutoServicoEnumeration;
	}

	public void setTipoFormaPagamentoEnumeration(TipoFormaPagamentoEnumeration tipoFormaPagamentoEnumeration) {
		this.tipoFormaPagamentoEnumeration = tipoFormaPagamentoEnumeration;
	}

	public void setTipoSituacaoPagamentoEnumeration(TipoSituacaoPagamentoEnumeration tipoSituacaoPagamentoEnumeration) {
		this.tipoSituacaoPagamentoEnumeration = tipoSituacaoPagamentoEnumeration;
	}

	public void setTipoCanalPagamentoEnumeration(TipoCanalPagamentoEnumeration tipoCanalPagamentoEnumeration) {
		this.tipoCanalPagamentoEnumeration = tipoCanalPagamentoEnumeration;
	}

	public void setTipoFontePagamentoEnumeration(TipoFontePagamentoEnumeration tipoFontePagamentoEnumeration) {
		this.tipoFontePagamentoEnumeration = tipoFontePagamentoEnumeration;
	}

	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public void setValorAdicional(Double valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
