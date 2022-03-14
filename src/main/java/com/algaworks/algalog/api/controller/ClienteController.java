package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;

//@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@PersistenceContext//Injeta
//	private EntityManager em;
//	@GetMapping
//	public List<Cliente> listar() {
//		return em.createQuery("FROM Cliente",Cliente.class)
//				.getResultList();
//		
//		 
//		
//	}

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CatalogoClienteService catalogoClienteService;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
//	
//	@GetMapping("/{nome}")
//	public List<Cliente> listarPorNome(@PathVariable String nome) {
//		return clienteRepository.findByNome(nome);
//	}
	@GetMapping("/{pedacoNome}/{repetidoPedacoNome}")
	public List<Cliente> listarPorNomeContido(@PathVariable String pedacoNome, @PathVariable String repetidoPedacoNome) {
		return clienteRepository.findByNomeContaining(repetidoPedacoNome);
	}

//	private ClienteRepository clienteRepository;
//	
//	public ClienteController(ClienteRepository clienteRepository) {
//		super();
//		this.clienteRepository = clienteRepository;
//	}
//	
//	@GetMapping
//	public List<Cliente> listar() {
//		return clienteRepository.findAll();

	//Assim está com criando o construtor com o Lombok @AllArgsConstructor, com a assinatura na classe, mas não funcionou
//	private ClienteRepository clienteRepository;
//
//	@GetMapping
//	public List<Cliente> listar() {
//		return clienteRepository.findAll();
//
//	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> buscarComId(@PathVariable Long clienteId) {
		
//		Optional<Cliente> cliente =  clienteRepository.findById(clienteId);
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok().body(cliente.get());
//		}
//		return ResponseEntity.notFound().build();
		
		
		
//		return clienteRepository.findById(clienteId)
//				.map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());
		
		return clienteRepository.findById(clienteId)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente){
		
		if(clienteRepository.existsById(clienteId) == false) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = catalogoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {
		if(clienteRepository.existsById(clienteId) == false) {
			return ResponseEntity.notFound().build();
		}
		catalogoClienteService.excluir(clienteId);
		return ResponseEntity.noContent().build();
	}
	
}
