package dariocecchinato.s17l3_spring_tests_project;

import dariocecchinato.s17l3_spring_tests_project.Enum.Stato;
import dariocecchinato.s17l3_spring_tests_project.Enum.StatoOrdine;
import dariocecchinato.s17l3_spring_tests_project.entities.MenuData;
import dariocecchinato.s17l3_spring_tests_project.entities.Ordine;
import dariocecchinato.s17l3_spring_tests_project.entities.Pizza;
import dariocecchinato.s17l3_spring_tests_project.entities.Tavolo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class S17l3SpringTestsProjectApplicationTests {

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
