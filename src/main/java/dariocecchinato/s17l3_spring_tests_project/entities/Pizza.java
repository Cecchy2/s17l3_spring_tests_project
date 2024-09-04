package dariocecchinato.s17l3_spring_tests_project.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Pizza extends MenuData {
private List<Topping> toppings;

    public Pizza(String nome, double prezzo, int nutritionalInfo) {
        super(nome, prezzo, nutritionalInfo);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }

    @Override
    public String toString() {
        return "• Pizza: " + getNome() +
                 toppings +
                " , Prezzo " + getPrezzo() +
                " , Valori Nutrizionali "+ getValoriNutrizionali();
    }
}
