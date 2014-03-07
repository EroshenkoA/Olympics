package ru.mipt.cs.olimpics.human.sportsman.sub;

import ru.mipt.cs.olimpics.human.sportsman.Sportsman;

/**
 * Created by 1 on 28.02.14.
 */
public class SportsmanShortTrack extends Sportsman {
    private double time;
    public SportsmanShortTrack (String name){
        super(name);
    }
    public void Perform(){
        this.time=forces;
        this.result=forces;
    }
    public double GetResult () {
        return time;
    }
    public int compareTo (Object obj){
        int res=0;
        if (time > ( (SportsmanShortTrack) obj).time){
                res=1;
        }else{
            if (time < ( (SportsmanShortTrack) obj).time){
                res=-1;
            }
        }
        return res;
    }
}
