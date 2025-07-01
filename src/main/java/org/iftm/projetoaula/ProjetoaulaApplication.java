package org.iftm.projetoaula;

import java.time.Instant;

import org.iftm.projetoaula.entities.Address;
import org.iftm.projetoaula.entities.Category;
import org.iftm.projetoaula.entities.Client;
import org.iftm.projetoaula.repositories.AddressRepository;
import org.iftm.projetoaula.repositories.CategoryRepository;
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
	// injeção de dependencia da classe ClientService.
	// permite ao SpringBoot instanciar objetos dessa classe.
	//@Autowired
	//private ClientService servicos;

	@Autowired
	private ClientRepository repositoryClient;

	@Autowired
	private AddressRepository repositoryAddress;

	@Autowired
	private CategoryRepository repositoryCategory;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoaulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciar um objeto da classe Client
		Client cliente = new Client();
		cliente.setName("1. Ed");
		cliente.setCpf("000111222-22");
		cliente.setIncome(10000.00);
		cliente.setChildren(3);
		cliente.setBirthDate(Instant.parse("1978-10-09T04:30:00.00Z"));
		Address address = new Address(null, "Av Liberdade", "Uberlândia", "MG", "38400000");
		cliente.setAddress(address);
		Category category = new Category(null, "Comum");
		cliente.setCategory(category);
		repositoryAddress.save(address);
		repositoryCategory.save(category);
		repositoryClient.save(cliente);
		
		/*
		try{
			servicos.insert(cliente);
		}catch(IllegalArgumentException e){
			System.out.println("\n"+e.getMessage()+"\n");
		}
			*/
		/*

		Client cliente2 = new Client(null, "Jose", "11111", 12000.00, Instant.parse("1978-10-09T04:30:00.00Z"), 2);
		repositorio.save(cliente2);

		cliente2.setName("Maria");
		repositorio.save(cliente2);

		// repositorio.deleteAll();
		// repositorio.deleteById(2L);
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

		// Query Methods
		// find by atributos - similar ao select de BD
		// queryMethods retorna uma lista de clientes
		// findBy indica que é uma consulta, children indica qual campo será buscado.
		ArrayList<Client> listaClientes = repositorio.findByChildren(2);
		System.out.println("-------- Saída ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName());
		}
		System.out.println("-------- Saída ----------");

		// findBy indica que é uma consulta, children indica qual campo será buscado.
		listaClientes = repositorio.findByName("João Silva");
		System.out.println("-------- Saída Name ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName());
		}
		System.out.println("-------- Saída ----------");

		// findBy indica que é uma consulta, name e children indica quais campo serão
		// buscados.
		listaClientes = repositorio.findByNameOrChildrenOrderByName("João Silva", 0);
		System.out.println("-------- Saída Name e Children ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName());
		}
		System.out.println("-------- Saída ----------");

		listaClientes = repositorio.findByChildrenGreaterThanEqual(2);
		System.out.println("-------- Saída Quantidade de filhos ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName() + " - " + listaClientes.get(i).getChildren());
		}
		System.out.println("-------- Saída ----------");

		System.out.println("-------- Saída ----------");

		listaClientes = repositorio.findByChildrenBetweenOrderByName(1, 3);
		System.out.println("-------- Saída Quantidade de filhos ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName() + " - " + listaClientes.get(i).getChildren());
		}
		System.out.println("-------- Saída ----------");

		System.out.println("-------- Saída ----------");

		listaClientes = repositorio.findByNameContainingOrderByChildrenDesc("Maria");
		System.out.println("-------- Saída Quantidade de filhos ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName() + " - " + listaClientes.get(i).getChildren());
		}
		System.out.println("-------- Saída ----------");

		System.out.println("-------- Saída ----------");
		ArrayList<Integer> qtdFilhos = new ArrayList<>();
		qtdFilhos.add(1);
		qtdFilhos.add(3);
		listaClientes = repositorio.findByChildrenIn(qtdFilhos);
		System.out.println("-------- Saída Quantidade de filhos ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName() + " - " + listaClientes.get(i).getChildren());
		}
		System.out.println("-------- Saída ----------");

		System.out.println("-------- Saída ----------");
		qtdFilhos.add(2);
		listaClientes = repositorio.findByChildrenInAndIncomeGreaterThanEqualOrderByNameDesc(qtdFilhos, 5000.00);
		System.out.println("-------- Saída Quantidade de filhos e salaŕio minimo ----------");
		System.out.println(listaClientes.size());// imprimir quantidade de clientes com dois filhos
		System.out.println("Relatório:::::");
		for (int i = 0; i < listaClientes.size(); i++) {
			System.out.println(listaClientes.get(i).getName() + " - " + listaClientes.get(i).getChildren() + " - R$ " + listaClientes.get(i).getIncome());
		}
		System.out.println("-------- Saída ----------");
*/
	}

}
