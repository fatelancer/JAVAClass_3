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

    public void main(String [] args){

    }

}

```

## 2. 主界面
```java
        CircleArea ca = new CircleArea();
        ca.setTitle("圆面积的计算");
        ca.setBounds(400,300,280,150);
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