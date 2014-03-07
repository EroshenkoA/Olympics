package ru.mipt.cs.olimpics.main;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

import ru.mipt.cs.olimpics.discipline.shortrack.ShortTrack;
import ru.mipt.cs.olimpics.human.jury.Jury;
import ru.mipt.cs.olimpics.human.sportsman.sub.SportsmanShortTrack;
/**
 * Created by 1 on 22.02.14.
 */

public class Competition extends JFrame{ //Short-track

    public Competition(){
        super("Competition");
        try  {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {
        }

        setSize(400, 250);
        final JLabel namelabel[] = new JLabel[7];
        final JLabel timelabel[] = new JLabel[7];
        final JLabel placelabel[] = new JLabel[7];

        final SportsmanShortTrack S[]={new SportsmanShortTrack("Vladimir Grigoriev"),new SportsmanShortTrack("Victor An"),
                new SportsmanShortTrack("Shinke Knegt"), new SportsmanShortTrack("Dazin U"),
                new SportsmanShortTrack("Davun Sin"),new SportsmanShortTrack("Tyanu Han"), new SportsmanShortTrack("Semen Elistratov")};

        S[1].SetForces(1.24102);
        S[0].SetForces(1.24868);
        S[2].SetForces(1.25611);
        S[3].SetForces(1.24239);
        S[5].SetForces(1.24490);
        S[6].SetForces(1.24239);
        S[4].SetForces(1.24215);
        final Jury J=new Jury("Peter Worte");//final is used inside the inner button listener class
        ShortTrack ST=new ShortTrack(1000,"final");
        ST.SetWorldRecord(1.25);

        for (int i=0; i<S.length; i++){
            ST.AddSportsmen(S[i]);
            namelabel[i]=new JLabel(S[i].GetName());
            /*timelabel[i]=new JLabel(Double.toString(S[i].GetResult()));
            placelabel[i]=new JLabel(Integer.toString(S[i].GetPlace()));*/
            timelabel[i]=new JLabel(Double.toString(0));
            placelabel[i]=new JLabel(Integer.toString(0));
        }
        J.SetDiscipline(ST);

        Container c = getContentPane();

        JPanel centerPanel = new JPanel(new GridLayout(1,3));
        JPanel panels[]=new JPanel[3];
        centerPanel.setBorder(BorderFactory.createEtchedBorder());
        c.add(centerPanel, BorderLayout.CENTER);
        panels[0]=new JPanel(new GridLayout(7,1));
        panels[1]=new JPanel(new GridLayout(7,1));
        panels[2]=new JPanel(new GridLayout(7,1));
        for (int i=0; i<7; i++){
            panels[0].add(placelabel[i]);
            panels[1].add(namelabel[i]);
            panels[2].add(timelabel[i]);
        }
        centerPanel.add(panels[0]);
        centerPanel.add(panels[1]);
        centerPanel.add(panels[2]);
        JButton btn = new JButton("start");
        c.add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                J.StartCompetition();
                J.TotalCompetition();
                Arrays.sort(S);//necessary
                for (int i=0; i<S.length; i++){
                    namelabel[i].setText(S[i].GetName());
                    timelabel[i].setText(Double.toString(S[i].GetResult()));
                    placelabel[i].setText(Integer.toString(S[i].GetPlace()));
                }
            }
        });
        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);

        setVisible(true);
    }

    public static void main (String args[]){

        new Competition();
    }
}
