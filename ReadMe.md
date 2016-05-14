# JAVA 第三次课

# GUI设计

## 1. 框架

```java
package AreaCalculate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by fatel on 2016/5/14.
 */
public class CircleArea extends JFrame implements ActionListener{

    public CircleArea(){

    }

    public void actionPerformed(ActionEvent ae){

    }

    public static void main(String [] args){

    }

}

```

## 2. 主界面
```java
        CircleArea ca = new CircleArea();
        ca.setTitle("圆面积的计算");
        ca.setBounds(400,300,280,180);
        ca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ca.setVisible(true);
```
## 3. 搭建面板
```java
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
```
## 4. 面板布局
```java
    p1.setLayout(fl);
    p1.setBackground(Color.yellow);
    p1.add(l0);

    p2.setLayout(new GridLayout(2,2,5,5));
    p2.setBackground(Color.green);
    p2.add(l1);
    p2.add(t1);
    p2.add(l2);
    t2.setEditable(false);//t2不可编辑
    p2.add(t2);

    p3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    p3.setBackground(Color.pink);
    b1.addActionListener(this);
    b2.addActionListener(this);//添加监听器
    p3.add(b1);
    p3.add(b2);

    p0.add("North", p1);
    p0.add("Center", p2);
    p0.add("South", p3);

    this.setContentPane(p0);
```
## 5. 事件处理
```java
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b1){
            t2.setText(""+3.1415926*Double.parseDouble(t1.getText())*Double.parseDouble(t1.getText()));
        }else{
            t1.setText("");
            t2.setText("");
        }
    }
```

## 6. 代码优化
```java
    JPanel []p = new JPanel[4];
    Color [] c = {Color.red, Color.yellow, Color.green, Color.pink};
    LayoutManager [] lm = { new BorderLayout(5,5),
                            new FlowLayout(FlowLayout.CENTER, 5, 5),
                            new GridLayout(2,2,5,5),
                            new FlowLayout(FlowLayout.CENTER, 5, 5)};
    String [] str = {"圆面积计算系统", "请输入圆的半径：", "圆的面积是："};

    JLabel [] l = new JLabel[3];

    JTextField [] t = new JTextField [2];

    String [] str1 = {"计算", "清空"};

    JButton [] b = new JButton[2];

    public CircleArea(){
        for (int i = 0;i < p.length;i++){
            p[i] = new JPanel(lm[i]);
            p[i].setBackground(c[i]);
        }

        for (int i = 0;i < l.length;i++){
            l[i] = new JLabel(str[i], JLabel.CENTER);
        }

        for (int i = 0;i < t.length;i++){
            t[i] = new JTextField(10);
        }

        for (int i = 0;i < b.length;i++){
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
```