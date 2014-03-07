package ru.mipt.cs.olimpics.human.sportsman; /**
 * Created by 1 on 22.02.14.
 */
import ru.mipt.cs.olimpics.human.Human;

import java.util.Collections;
import java.util.ArrayList;
public abstract class Sportsman extends Human implements Comparable{
    protected int place;
    protected double forces;
    protected double result;
    public Sportsman (String name, int age){
        super(name,age);
    }
    public Sportsman (String name){
        super(name);
    }
    public void SetForces(double force){
        forces=force;
    }
    public void SetPlace(int place){
        this.place=place;
    }
    public int GetPlace() {
        return place;
    }
    public abstract void Perform();
    public double GetResult (){
        return result;
    }
    public void Print(){
        System.out.println(place+" "+name+" "+result);
    }

}
