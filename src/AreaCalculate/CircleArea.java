package AreaCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fatel on 2016/5/14.
 */
public class CircleArea extends JFrame implements ActionListener {
    String area;

    JPanel[] p = new JPanel[4];
    Color[] c = {Color.red, Color.yellow, Color.green, Color.pink};
    LayoutManager[] lm = {new BorderLayout(5, 5),
            new FlowLayout(FlowLayout.CENTER, 5, 5),
            new GridLayout(2, 2, 5, 5),
            new FlowLayout(FlowLayout.CENTER, 5, 5)};
    String[] str = {"圆面积计算系统", "请输入圆的半径：", "圆的面积是："};

    JLabel[] l = new JLabel[3];

    JTextField[] t = new JTextField[2];

    String[] str1 = {"计算", "清空"};

    JButton[] b = new JButton[2];

    public CircleArea() {
        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel(lm[i]);
            p[i].setBackground(c[i]);
        }

        for (int i = 0; i < l.length; i++) {
            l[i] = new JLabel(str[i], JLabel.CENTER);
        }

        for (int i = 0; i < t.length; i++) {
            t[i] = new JTextField(10);
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton(str1[i]);
            b[i].addActionListener(this);
            p[3].add(b[i]);
        }

        p[1].add(l[0]);

        p[2].add(l[1]);
        p[2].add(t[0]);
        p[2].add(l[2]);
        t[1].setEditable(false);
        p[2].add(t[1]);

        p[0].add("North", p[1]);
        p[0].add("Center", p[2]);
        p[0].add("South", p[3]);

        this.setContentPane(p[0]);
    }

    public void actionPerformed(ActionEvent ae) throws NumberFormatException {
        try {
            if (ae.getSource() == b[0]) {
                if (t[0].getText().equals("")){
                    throw new MyException("半径不能为空，请重新输入！！！");
                }else {
                    area = String.format("%5f", 3.1415926 * Double.parseDouble(t[0].getText()) * Double.parseDouble(t[0].getText()));
                    t[1].setText(area);
                }
            } else {
                t[0].setText("");
                t[1].setText("");
            }
        } catch (MyException me) {
            JOptionPane.showMessageDialog(null,
                    me.outExceMessage(), "异常消息", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,
                    "输入不能为非数字，请重新输入", "异常消息", JOptionPane.ERROR_MESSAGE);
            t[0].setText("");
            t[1].setText("");
        }
    }

    public static void main(String[] args) {
        CircleArea ca = new CircleArea();
        ca.setTitle("圆面积的计算");
        ca.setBounds(400, 300, 280, 180);
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setVisible(true);
    }


    class MyException extends NumberFormatException {
        private String str;

        public MyException(String s) {
            str = s;
        }

        public String outExceMessage() {
            return str;
        }
    }//类中类
}
