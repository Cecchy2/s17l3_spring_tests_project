package dariocecchinato.s17l3_spring_tests_project.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class MenuData {
    private String nome;
    private double prezzo;
    private int valoriNutrizionali;

    @Override
    public String toString() {
        return
                " nome " + nome +
                " prezzo " + prezzo +
                " valoriNutrizionali " + valoriNutrizionali;
    }
}
