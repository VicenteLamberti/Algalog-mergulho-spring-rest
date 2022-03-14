package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.StatusEntrega;


public class EntregaModel {

	private Long id;
	private ClienteResumoModel cliente;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
	
	private DestinatarioModel destinatario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteResumoModel getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteResumoModel cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal frete) {
		this.taxa = frete;
	}

	public StatusEntrega getStatus() {
		return status;
	}

	public void setStatus(StatusEntrega status) {
		this.status = status;
	}

	public OffsetDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(OffsetDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public DestinatarioModel getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioModel destinatario) {
		this.destinatario = destinatario;
	}
	
	
	
}
