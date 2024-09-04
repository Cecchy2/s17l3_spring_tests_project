package dariocecchinato.s17l3_spring_tests_project;

import dariocecchinato.s17l3_spring_tests_project.Enum.Stato;
import dariocecchinato.s17l3_spring_tests_project.Enum.StatoOrdine;
import dariocecchinato.s17l3_spring_tests_project.entities.MenuData;
import dariocecchinato.s17l3_spring_tests_project.entities.Ordine;
import dariocecchinato.s17l3_spring_tests_project.entities.Tavolo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
