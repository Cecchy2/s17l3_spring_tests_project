package dariocecchinato.s17l3_spring_tests_project;

import dariocecchinato.s17l3_spring_tests_project.entities.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class MenuConfig {

    @Bean
    public Topping tomato() {
        return new Topping("tomato", 0.0, 0);
    }
    @Bean
    public Topping cheese(){
        return new Topping("cheese",0.69,92);
    }
    @Bean
    public Topping ham(){
        return new Topping("ham",0.99, 35);
    }
    @Bean
    public Topping onions(){
        return new Topping("onions",0.69, 22);
    }
    @Bean
    public Topping pineapple(){
        return new Topping("pineapple",0.79, 24);
    }
    @Bean
    public Topping salami(){
        return new Topping("salami",0.99, 86);
    }
    @Bean
    public Pizza margherita(){
        Pizza margherita = new Pizza("Margherita", 4.99, 1104);
        margherita.addTopping(tomato());
        margherita.addTopping(cheese());
        return margherita;
    }
    @Bean
    public Pizza hawaianPizza(){
        Pizza hawaianPizza = new Pizza("Hawaian Pizza", 6.49, 1024);
        hawaianPizza.addTopping(tomato());
        hawaianPizza.addTopping(cheese());
        hawaianPizza.addTopping(ham());
        hawaianPizza.addTopping(pineapple());
        return hawaianPizza;
    }
    @Bean
    public Pizza salamiPizza(){
        Pizza salamiPizza = new Pizza("Salami Pizza", 5.99, 1160);
        salamiPizza.addTopping(tomato());
        salamiPizza.addTopping(cheese());
        salamiPizza.addTopping(salami());
        return salamiPizza;
    }
    @Bean
    public Bevanda lemonade(){
        return new Bevanda("Lemonade", 1.29, 128);
    }
    @Bean
    public Bevanda water(){
        return new Bevanda("Water", 1.29, 0);
    }
    @Bean
    public Bevanda wine(){
        return new Bevanda("Wine", 7.49, 607);
    }
    @Bean
    public Menu menu(){
        Menu menu = new Menu();
        menu.addData(margherita());
        menu.addData(hawaianPizza());
        menu.addData(salamiPizza());
        menu.addData(lemonade());
        menu.addData(water());
        menu.addData(wine());
        return menu;
    }


}
