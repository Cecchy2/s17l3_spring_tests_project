package dariocecchinato.s17l3_spring_tests_project.entities;


import dariocecchinato.s17l3_spring_tests_project.Enum.StatoOrdine;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@PropertySource("application.properties")
public class Ordine {
    private final Tavolo tavolo;
    private final List<MenuData> datas;
    private final int numeroOrdine;
    private final StatoOrdine statoOrdine;
    private final int numeroCoperti;
    private LocalDate oraAcquisizione;
    private final double importoTotale;

    @Value("${costo.coperto}")
    private double costoCoperto;

    public Ordine(Tavolo tavolo, List<MenuData> datas, int numeroOrdine, StatoOrdine statoOrdine, int numeroCoperti) {
        this.tavolo = tavolo;
        this.datas = datas;
        this.numeroOrdine = numeroOrdine;
        this.statoOrdine = statoOrdine;
        this.numeroCoperti = numeroCoperti;
        this.oraAcquisizione = LocalDate.now();
        this.importoTotale = calcolaTotale();
    }

    public double calcolaTotale(){
        double totale = numeroCoperti* costoCoperto;
        for (MenuData data:datas){
            totale+= data.getPrezzo();
        }
        return totale;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "tavolo=" + tavolo.getNumeroTavolo() +
                ", numeroOrdine=" + numeroOrdine +
                ", statoOrdine=" + statoOrdine +
                ", numeroCoperti=" + numeroCoperti +
                ", oraAcquisiziope=" + oraAcquisizione +
                ", importoTotale=" + calcolaTotale() +
                " Pizze : " + datas;
    }


}
