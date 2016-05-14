package StudentManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;

/**
 * Created by fatel on 2016/5/14.
 */
public class Student extends JFrame implements ActionListener{
    private Double [] marks = new Double[4];
    private String name;
    private Double summark;
    private Double avrmark;


    JPanel [] p = new JPanel[6];
    JLabel [] l = new JLabel[11];
    JTextField [] t = new JTextField[5];
    JButton [] b = new JButton[2];

    LayoutManager [] lm = {new BorderLayout(5, 5),
            new FlowLayout(FlowLayout.CENTER,5,5),
            new FlowLayout(FlowLayout.LEFT,5,5),
            new GridLayout(3,4,5,5),
            new FlowLayout(FlowLayout.LEFT,5,5),
            new FlowLayout(FlowLayout.LEFT,5,5)};

    String [] lstr = {"学生成绩表",
                    "姓名：",
                    "语文：",
                    "数学：",
                    "英语：",
                    "政治：",
                    "总分：",
                    " ",
                    "平均分：",
                    " ",
                    " "};

    String [] bstr = {"计算总分","计算平均分"};

    public Student(){
        for (int i = 0; i < p.length; i++) {
            p[i] = new JPanel(lm[i]);
        }
        for (int i = 0; i < l.length; i++) {
            l[i] = new JLabel(lstr[i]);
        }
        for (int i = 0; i < t.length; i++) {
            t[i] = new JTextField(10);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton(bstr[i]);
            b[i].addActionListener(this);
        }

        p[1].add(l[0]);

        p[2].add(l[1]);
        p[2].add(t[0]);

        p[3].add(l[2]);
        p[3].add(t[1]);
        p[3].add(l[3]);
        p[3].add(t[2]);

        p[3].add(l[4]);
        p[3].add(t[3]);
        p[3].add(l[5]);
        p[3].add(t[4]);

        p[3].add(l[6]);
        p[3].add(l[7]);
        p[3].add(l[8]);
        p[3].add(l[9]);

        p[4].add(b[0]);
        p[4].add(b[1]);
        p[4].add(l[10]);

        p[0].add("North", p[1]);
        p[5].add("North", p[2]);
        p[5].add("South", p[3]);
        p[0].add("Center", p[5]);
        p[0].add("South", p[4]);

        this.setContentPane(p[0]);
    }

    public void actionPerformed(ActionEvent ae)throws MyException{
        try{
            if (t[0].getText().equals("")) throw new MyException("姓名不能为空，请重新输入！！");
            if (t[1].getText().equals("")) throw new MyException("语文分数不能为空，请重新输入！！");
            if (t[2].getText().equals("")) throw new MyException("数学分数不能为空，请重新输入！！");
            if (t[3].getText().equals("")) throw new MyException("英语分数不能为空，请重新输入！！");
            if (t[4].getText().equals("")) throw new MyException("政治分数不能为空，请重新输入！！");
            if (Double.parseDouble(t[0].getText())*Double.parseDouble(t[0].getText())>=0) throw new MyException("姓名不能是数字，请重新输入！！");
            if (Double.parseDouble(t[1].getText()) < 0) throw new MyException("语文分数不能为负，请重新输入！！");
            if (Double.parseDouble(t[2].getText()) < 0) throw new MyException("数学分数不能为负，请重新输入！！");
            if (Double.parseDouble(t[3].getText()) < 0) throw new MyException("英语分数不能为负，请重新输入！！");
            if (Double.parseDouble(t[4].getText()) < 0) throw new MyException("政治分数不能为负，请重新输入！！");
            name = t[0].getText();
            marks[0] = Double.parseDouble(t[1].getText());
            marks[1] = Double.parseDouble(t[2].getText());
            marks[2] = Double.parseDouble(t[3].getText());
            marks[3] = Double.parseDouble(t[4].getText());
            if (ae.getSource()==b[0]){
                l[7].setText(dispmark(calsum()));
                l[10].setText(judge(calavr()));
            }else{
                l[9].setText(dispmark(calavr()));
                l[10].setText(judge(calavr()));
            }
        }catch(MyException e){
            JOptionPane.showMessageDialog(null,
                    e.outExceMessage(), "异常消息", JOptionPane.ERROR_MESSAGE);
        }catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null,
                    "分数不能为字符", "异常消息", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String dispmark(Double d){
        return ""+d;
    }

    public String judge(Double d){
        if (d < 60)
            return name+"同学的成绩不合格！！";
        else if (d<80) return  name+"同学的成绩良好！！";
        else return name+"同学的成绩优秀！！";
    }

    public Double calsum(){
        summark = marks[0] + marks [1] + marks [2] + marks [3];
        return summark;
    }

    public Double calavr(){
        avrmark = (marks[0] + marks [1] + marks [2] + marks [3])/4;
        return avrmark;
    }

    public static void main(String [] args){
        Student s = new Student();
        s.setTitle("学生成绩表");
        s.setBounds(400,300,500,250);
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
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
