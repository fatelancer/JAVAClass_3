package AreaCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fatel on 2016/5/14.
 */
public class CircleArea extends JFrame implements ActionListener{

    JPanel p0 = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    JLabel l0 = new JLabel("圆面积计算系统", JLabel.CENTER);
    JLabel l1 = new JLabel("请输入圆的半径：", JLabel.CENTER);
    JLabel l2 = new JLabel("圆的面积是：", JLabel.CENTER);

    JTextField t1 = new JTextField(10);
    JTextField t2 = new JTextField(10);

    JButton b1 = new JButton("计算");
    JButton b2 = new JButton("清空");

    FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 5, 5);
    public CircleArea(){
        p1.setLayout(fl);
        p1.setBackground(Color.yellow);
        p1.add(l0);

        p2.setLayout(new GridLayout(2,2,5,5));
        p2.setBackground(Color.green);
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        t2.setEditable(false);
        p2.add(t2);

        p3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        p3.setBackground(Color.pink);
        b1.addActionListener(this);
        b2.addActionListener(this);
        p3.add(b1);
        p3.add(b2);

        p0.add("North", p1);
        p0.add("Center", p2);
        p0.add("South", p3);

        this.setContentPane(p0);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            t2.setText(""+3.1415926*Double.parseDouble(t1.getText())*Double.parseDouble(t1.getText()));
        }else{
            t1.setText("");
            t2.setText("");
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
