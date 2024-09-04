package dariocecchinato.s17l3_spring_tests_project;


import dariocecchinato.s17l3_spring_tests_project.Enum.Stato;
import dariocecchinato.s17l3_spring_tests_project.Enum.StatoOrdine;
import dariocecchinato.s17l3_spring_tests_project.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(S17l3SpringTestsProjectApplication.class);

        Menu menu= context.getBean(Menu.class);

        System.out.println(menu);

        Tavolo tavolo1= new Tavolo(1, 6, Stato.OCCUPATO);

        List<MenuData> ordineList = new ArrayList<>();

        Pizza margherita = (Pizza) context.getBean("margherita");
        Pizza hawaianPizza = (Pizza) context.getBean("hawaianPizza");
        Pizza salamiPizza = (Pizza) context.getBean("salamiPizza");
        Bevanda lemonade = (Bevanda) context.getBean("lemonade");
        Bevanda water = (Bevanda) context.getBean("water");
        Bevanda wine = (Bevanda) context.getBean("wine");
        Topping tomato = (Topping) context.getBean("tomato");
        Topping cheese = (Topping) context.getBean("cheese");
        Topping ham = (Topping) context.getBean("ham");
        Topping onions = (Topping) context.getBean("onions");
        Topping pineapple = (Topping) context.getBean("pineapple");
        Topping salami = (Topping) context.getBean("salami");
        Ordine order1 = new Ordine(tavolo1, ordineList, 1, StatoOrdine.IN_CORSO, 4);

        ordineList.add(margherita);
        ordineList.add(hawaianPizza);
        ordineList.add(margherita);
        ordineList.add(salamiPizza);
        ordineList.add(lemonade);
        ordineList.add(wine);
        ordineList.add(salamiPizza);
        ordineList.add(water);
        ordineList.add(wine);
        ordineList.add(wine);
        ordineList.add(water);

        Ordine ordine = new Ordine(tavolo1,ordineList,1, StatoOrdine.IN_CORSO,5);



        System.out.println(order1);
    }
}
