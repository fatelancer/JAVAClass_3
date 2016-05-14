package AreaCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fatel on 2016/5/14.
 */
public class CircleArea extends JFrame implements ActionListener{
    String area;

    JPanel []p = new JPanel[4];
    LayoutManager [] lm = { new BorderLayout(5,5),
                            new FlowLayout(FlowLayout.CENTER, 5, 5),
                            new GridLayout(2,2,5,5),
                            new FlowLayout(FlowLayout.CENTER, 5, 5)};
    String [] str = {"圆面积计算系统", "请输入圆的半径：", "圆的面积是："};

    JLabel [] l = new JLabel[3];

    JTextField [] t = new JTextField [2];

    String [] str1 = {"计算", "清空"};

    JButton [] b = new JButton[2];

    //FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 5, 5);
    public CircleArea(){
        for (int i = 0;i < p.length;i++){
            p[i] = new JPanel(lm[i]);
        }

        for (int i = 0;i < l.length;i++){
            l[i] = new JLabel(str[i], JLabel.CENTER);
        }

        for (int i = 0;i < t.length;i++){
            t[i] = new JTextField(10);
        }

        for (int i = 0;i < b.length;i++){
            b[i] = new JButton(str1[i]);
        }

        p[1].setBackground(Color.yellow);
        p[1].add(l[0]);

        p[2].setBackground(Color.green);
        p[2].add(l[1]);
        p[2].add(t[0]);
        p[2].add(l[2]);
        t[1].setEditable(false);
        p[2].add(t[1]);

        p[3].setBackground(Color.pink);
        b[0].addActionListener(this);
        b[1].addActionListener(this);
        p[3].add(b[0]);
        p[3].add(b[1]);

        p[0].add("North", p[1]);
        p[0].add("Center", p[2]);
        p[0].add("South", p[3]);

        this.setContentPane(p[0]);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b[0]){
            area=String.format("%5f", 3.1415926*Double.parseDouble(t[0].getText())*Double.parseDouble(t[0].getText()));
            t[1].setText(area);
        }else{
            t[0].setText("");
            t[1].setText("");
        }
    }

    public static void main(String [] args){
        CircleArea ca = new CircleArea();
        ca.setTitle("圆面积的计算");
        ca.setBounds(400,300,280,180);
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setVisible(true);
    }

}
