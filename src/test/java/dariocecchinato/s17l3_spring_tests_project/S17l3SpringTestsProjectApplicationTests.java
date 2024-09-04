package dariocecchinato.s17l3_spring_tests_project;

import dariocecchinato.s17l3_spring_tests_project.Enum.Stato;
import dariocecchinato.s17l3_spring_tests_project.Enum.StatoOrdine;
import dariocecchinato.s17l3_spring_tests_project.entities.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class S17l3SpringTestsProjectApplicationTests {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(S17l3SpringTestsProjectApplication.class);

	Menu menu= context.getBean(Menu.class);



	@Test
	void pizzaContext(){
		Pizza salamiPizza = (Pizza) context.getBean("salamiPizza");
		assertNotNull(salamiPizza);

		List<Topping> toppings = salamiPizza.getToppings();

		assertTrue(toppings.contains(context.getBean("tomato")));
		assertTrue(toppings.contains(context.getBean("cheese")));
		assertTrue(toppings.contains(context.getBean("salami")));

		assertEquals(3, toppings.size());
	}

	@Test
	void testContext (){
		Menu menu= context.getBean(Menu.class);
		Pizza pizzaTest = new Pizza("pizzaTest",5.00,200);
		menu.addData(pizzaTest);
		assertNotNull(menu);
		assertEquals(pizzaTest,menu.getDatas().getLast());
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testOrdineConstructor(){
		Tavolo tavolo1= new Tavolo(1, 6, Stato.OCCUPATO);
		List<MenuData> ordineList = new ArrayList<>();

		Ordine ordine = new Ordine(tavolo1,ordineList,1, StatoOrdine.IN_CORSO,5);

		assertEquals(1,ordine.getNumeroOrdine());
		assertEquals(StatoOrdine.IN_CORSO,ordine.getStatoOrdine());
		assertEquals(5,ordine.getNumeroCoperti());
		assertEquals(tavolo1, ordine.getTavolo());
	}

	@Test
	public void testCalcolaTotale() {

		Tavolo tavolo = new Tavolo(1, 4, Stato.OCCUPATO);
		List<MenuData>datas = new ArrayList<>();
		MenuData pizza = new Pizza("Margherita", 4.99, 1104);
		datas.add(pizza);
		Ordine ordine = new Ordine(tavolo, datas, 1, StatoOrdine.IN_CORSO, 2);
		ordine.setCostoCoperto(2.5);

		double expectedTotal = 2 * 2.5 + 4.99;
		assertEquals(expectedTotal, ordine.calcolaTotale());
		assertTrue(ordine.calcolaTotale()>0);
		assertNotNull(ordine.getOraAcquisizione());
	}

	@ParameterizedTest
	@CsvSource({"testPizza, 7.00,700", "testPizza2, 8.00, 800"})
	void testNewPizzaMaker(String nome,double prezzo,int nutritionalInfo){
		Pizza pizza = new Pizza(nome,prezzo,nutritionalInfo);
		assertNotNull(pizza);
		assertTrue(pizza.getPrezzo()>0);
		assertFalse(pizza.getValoriNutrizionali()<0);
		assertAll(
				()->assertEquals(nome, pizza.getNome()),
				()->assertTrue(pizza.getPrezzo()>0),
				()->assertEquals(nutritionalInfo, pizza.getValoriNutrizionali())
		);
	}


}
