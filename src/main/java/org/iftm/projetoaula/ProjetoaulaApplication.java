package org.iftm.projetoaula;

import java.time.Instant;
import java.util.List;

import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*  modifiquei a classe incluindo a implementação da interface
 commandLineRunner que permite inserir código a ser executado na
 inicialização do servidor.
*/
@SpringBootApplication
public class ProjetoaulaApplication implements CommandLineRunner {
	//injeção de dependencia da classe ClientRepository.
	//permite ao SpringBoot instanciar objetos dessa classe.
	@Autowired
	private ClientRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoaulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		//Instanciar um objeto da classe Client
		Client cliente = new Client();		
		cliente.setName("Ana");
		cliente.setCpf("000111222-22");
		cliente.setIncome(10000.00);
		cliente.setChildren(3);
		cliente.setBirthDate(Instant.parse("1978-10-09T04:30:00.00Z"));
		repositorio.save(cliente);

		Client cliente2 = new Client(Instant.parse("1978-10-09T04:30:00.00Z"), 2, "11111", null, 12000.00, "Jose");
		repositorio.save(cliente2);

		cliente2.setName("Maria");
		repositorio.save(cliente2);

		//repositorio.deleteAll();
		//repositorio.deleteById(2L);
		List<Client> clientes = repositorio.findAll();
		System.out.println("Relatório:::::");
		for (int i = 0; i < clientes.size(); i++) {
			System.out.println(clientes.get(i).getName());
		}

		// utilizando o método de busca por id, que é a chave primaria, ou seja,
		// retorna apenas um elemento
		// ele retorna um objeto Optional, o metodo get() retorna o Client
		Client busca = repositorio.findById(2L).get();
		System.out.println("Busca individual:");
		System.out.println(busca.getName());
	}

}
