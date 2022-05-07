package com.example.BookShopApi;

import com.example.BookShopApi.bo.Book;
import com.example.BookShopApi.bo.Customer;
import com.example.BookShopApi.bo.Order;
import com.example.BookShopApi.repository.BookRepository;
import com.example.BookShopApi.repository.CustomerRepository;
import com.example.BookShopApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class BookShopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShopApiApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner demo(BookRepository bookRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {

		return (args) -> {
			var Bob = new Customer();
			var Chuck = new Customer();
			Bob.setEncryptedPassword("Bob123");
			Bob.setFirstName("bob");
			Bob.setLastName("bob");
			Bob.setEmailAddress("bob@mail.com");
			Bob.setAddress("56 rue de la weed");
			Bob.setZipCode("55555");
			Bob.setCity("Weedy");
			Bob.setPhoneNumber("05555555555555");

			Chuck.setEncryptedPassword("ChuckNorrisNaPasDeMotDePass");
			Chuck.setFirstName("Chuck");
			Chuck.setLastName("Norris");
			Chuck.setEmailAddress("cn@mail.com");
			Chuck.setAddress("56 de toutes les rue");
			Chuck.setZipCode("99999");
			Chuck.setCity("Partout");
			Chuck.setPhoneNumber("0000000000000001");
			customerRepository.save(Bob);
			customerRepository.save(Chuck);


			var cmd1 = new Order();

			cmd1.setCustomer(Bob);
			cmd1.setOrderDate(new Date(04/05/2022));
			cmd1.setOrderDate(new Date(15/05/2022));
			cmd1.setAmountOrdered(50);

			var cmd2 = new Order();

			cmd2.setCustomer(Bob);
			cmd2.setOrderDate(new Date(01/01/2022));
			cmd2.setOrderDate(new Date(15/01/2022));
			cmd2.setAmountOrdered(30);

			orderRepository.save(cmd1);
			orderRepository.save(cmd2);

			var book1 = new Book();
			book1.setIsbn(10001);
			book1.setTitle("book1");
			book1.setNumberCopiesInStock(10);
			book1.setOrder(cmd1);
			book1.setOrder(cmd2);

			var book2 = new Book();
			book2.setIsbn(10002);
			book2.setTitle("book2");
			book2.setNumberCopiesInStock(10);
			book2.setOrder(cmd1);

			var book3 = new Book();
			book3.setIsbn(10003);
			book3.setTitle("book3");
			book3.setNumberCopiesInStock(10);
			book3.setOrder(cmd2);


			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);




			/*
			Incident incident = new Incident();
			incident.setId("Incident10");
			incident.setMotif("probleme eau");
			incident.setEtudiant(Bob);
			Incident incident1 = new Incident();
			incident1.setId("Incident11");
			incident1.setMotif("probleme");
			incident1.setEtudiant(Bob);
			incidentRepository.save(incident);
			incidentRepository.save(incident1);
			var a = new Agent();
			var b = new Agent();
			var c = new Agent();
			var d = new Agent();
			var e = new Agent();
			var f = new Agent();
			var g = new Agent();
			agentRepository.save(a);
			agentRepository.save(b);
			agentRepository.save(c);
			agentRepository.save(d);
			agentRepository.save(e);
			agentRepository.save(f);
			agentRepository.save(g);
			RendezVous rdv = new RendezVous();
			rdv.setId("rdv1");
			rdv.setMotif("problemepayement");
			rdv.setEtudiant(Bob);
			rdv.setAgent(a);
			rendezVousRepository.save(rdv);
			//ajouter des évenements
			Evenement evenement1 = new Evenement();
			evenement1.setTitre("Soirée dance");
			Evenement evenement2 = new Evenement();
			evenement2.setTitre("Youga");
			*/

		};
	}


}
