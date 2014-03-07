package ru.mipt.cs.olimpics.discipline.shortrack;

import ru.mipt.cs.olimpics.discipline.SportDiscipline;
import ru.mipt.cs.olimpics.human.sportsman.Sportsman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 1 on 27.02.14.
 */
public class ShortTrack extends SportDiscipline {
    private int distance;
    private String stage;
    public ShortTrack(int distance, String stage){
        //super();
        this.distance=distance;
        this.stage=stage;
        sportsmen=new ArrayList<Sportsman>();
    }
    public void Compete(){
        super.Compete();
        Collections.sort(sportsmen);
        int max=sportsmen.size();
        for (int i=0; i<max; i++){
            ((Sportsman) (sportsmen.get(i))).SetPlace(i+1);
        }
    }
    public void Print(){
        System.out.println(distance+"m "+stage);
        int max=sportsmen.size();
        for (int i=0; i<max; i++){
            ((Sportsman)sportsmen.get(i)).Print();
        }
    }
}
