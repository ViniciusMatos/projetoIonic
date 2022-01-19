package br.com.oic.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.oic.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagemnto;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagemnto = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	@JsonFormat(pattern="dd/MM/yyy HH:mm")
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	@JsonFormat(pattern="dd/MM/yyy HH:mm")
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagemnto() {
		return dataPagemnto;
	}

	public void setDataPagemnto(Date dataPagemnto) {
		this.dataPagemnto = dataPagemnto;
	}
	
	

}
