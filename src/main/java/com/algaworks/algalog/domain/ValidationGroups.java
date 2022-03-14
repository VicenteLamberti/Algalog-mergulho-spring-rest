package com.algaworks.algalog.domain;

//Isso foi necessário, porque se eu disser que o Id do cliente não pode ser null, quando eu for criar um cliente vai dar problema
public interface ValidationGroups {
	public interface ClienteId {}
}
