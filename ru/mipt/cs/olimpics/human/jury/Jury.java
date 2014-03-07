package ru.mipt.cs.olimpics.human.jury;

import ru.mipt.cs.olimpics.discipline.SportDiscipline;
import ru.mipt.cs.olimpics.human.Human;
import ru.mipt.cs.olimpics.human.sportsman.Sportsman;

/**
 * Created by 1 on 22.02.14.
 */
public class Jury extends Human {
    protected SportDiscipline sport;
    public Jury(String name, int age){
        super(name,age);
    }
    public Jury(String name){
        super(name);
    }
    public void SetDiscipline(SportDiscipline sport){
        this.sport=sport;
    }
    public void StartCompetition(){
        sport.Compete();
    }
    public void TotalCompetition(){
        sport.Print();
        CmpWR ( ((Sportsman)(sport.GetSportsmen().get(0))).GetResult() );
        System.out.println("the main jury member is "+name);
    }
    public void CmpWR (double res){
        if (res<sport.GetWorldRecord()){
            sport.SetWorldRecord(res);
            System.out.println("New WR is "+res);
        }
    }
}
