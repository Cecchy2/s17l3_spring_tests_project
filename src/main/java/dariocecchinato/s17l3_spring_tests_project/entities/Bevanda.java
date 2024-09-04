package dariocecchinato.s17l3_spring_tests_project.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bevanda extends MenuData {

    public Bevanda(String nome, double prezzo, int valoriNutrizionali) {
        super(nome, prezzo, valoriNutrizionali);
    }

    @Override
    public String toString() {
        return "• Drink: " + getNome()+ " prezzo "+ getPrezzo() + "  " + getValoriNutrizionali()+ " Cal";
    }
}
