package dariocecchinato.s17l3_spring_tests_project.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class Menu {
    private final List<MenuData> datas;

    public Menu() {
        this.datas = new ArrayList<>();
    }

    public void addData(MenuData data){
        this.datas.add(data);
    }


    @Override
    public String toString() {
        return "Menu" + datas;
    }
}
