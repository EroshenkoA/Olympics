package ru.mipt.cs.olimpics.discipline;



import ru.mipt.cs.olimpics.human.sportsman.Sportsman;

import java.util.ArrayList;

/**
 * Created by 1 on 28.02.14.
 */
public abstract class SportDiscipline
{
    protected double worldRecord;
    protected ArrayList<Sportsman> sportsmen;

    public ArrayList GetSportsmen() {
        return sportsmen;
    }
    public void AddSportsmen(Sportsman s){
            sportsmen.add(s);
    }
    public double GetWorldRecord() {
        return worldRecord;
    }

    public void SetWorldRecord(double worldRecord) {
        this.worldRecord = worldRecord;
    }
    public void Compete(){
        int max=sportsmen.size();
        for (int i=0; i<max; i++){
            ((Sportsman)sportsmen.get(i)).Perform();
        }
    }
    public void Print(){

    }
}
