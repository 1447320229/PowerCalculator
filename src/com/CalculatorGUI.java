package com;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {
    private JFrame frame = new JFrame("PowerCalculator");
    private MyLinstener linstener = new MyLinstener(this);
    private JPanel buttenPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JTextField chiefText = new JTextField();
    private Font chiefFont = new Font("宋体", Font.PLAIN, 40);
    private JTextField deputyText = new JTextField();
    private Font deputyFont = new Font("黑体", Font.ITALIC, 20);
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonAdd = new JButton("+");
    private JButton buttonSub = new JButton("-");
    private JButton buttonMul = new JButton("*");
    private JButton buttonDiv = new JButton("/");
    private JButton buttonDot = new JButton(".");
    private JButton buttonCE = new JButton("CE");
    private JButton buttonDel = new JButton("Del");
    private JButton buttonLef = new JButton("(");
    private JButton buttonRig = new JButton(")");
    private JButton buttonEqu = new JButton("=");

    public void CreateGUI() {
        frame.setVisible(true);
        frame.setBounds(500, 100, 400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(buttenPanel);
        buttenPanel.setLayout(new GridLayout(5, 4));
        frame.add(textPanel, BorderLayout.BEFORE_FIRST_LINE);
        textPanel.setLayout(new BorderLayout());

        deputyText.setFont(deputyFont);
        chiefText.setFont(chiefFont);
        deputyText.setText("0");
        chiefText.setText("0");
        deputyText.setEditable(false);
        chiefText.setEditable(false);
        deputyText.setHorizontalAlignment(JTextField.RIGHT);
        chiefText.setHorizontalAlignment(JTextField.RIGHT);
        textPanel.add(deputyText, BorderLayout.BEFORE_FIRST_LINE);
        textPanel.add(chiefText);

        buttenPanel.add(buttonCE);
        buttenPanel.add(buttonLef);
        buttenPanel.add(buttonRig);
        buttenPanel.add(buttonDel);
        buttenPanel.add(button7);
        buttenPanel.add(button8);
        buttenPanel.add(button9);
        buttenPanel.add(buttonAdd);
        buttenPanel.add(button4);
        buttenPanel.add(button5);
        buttenPanel.add(button6);
        buttenPanel.add(buttonSub);
        buttenPanel.add(button1);
        buttenPanel.add(button2);
        buttenPanel.add(button3);
        buttenPanel.add(buttonMul);
        buttenPanel.add(buttonDot);
        buttenPanel.add(button0);
        buttenPanel.add(buttonEqu);
        buttenPanel.add(buttonDiv);

        button0.addActionListener(linstener);
        button1.addActionListener(linstener);
        button2.addActionListener(linstener);
        button3.addActionListener(linstener);
        button4.addActionListener(linstener);
        button5.addActionListener(linstener);
        button6.addActionListener(linstener);
        button7.addActionListener(linstener);
        button8.addActionListener(linstener);
        button9.addActionListener(linstener);
        buttonAdd.addActionListener(linstener);
        buttonSub.addActionListener(linstener);
        buttonMul.addActionListener(linstener);
        buttonDiv.addActionListener(linstener);
        buttonLef.addActionListener(linstener);
        buttonRig.addActionListener(linstener);
        buttonEqu.addActionListener(linstener);
        buttonDot.addActionListener(linstener);
        buttonCE.addActionListener(linstener);
        buttonDel.addActionListener(linstener);
    }

    public boolean IntButten(String s, boolean flag) {
        if (flag) {
            chiefText.setText("");
        }
        String text = chiefText.getText();
        if ("0".equals(text)) {
            chiefText.setText(s);
            deputyText.setText(s);
        } else {
            chiefText.setText(text + s);
            text = deputyText.getText();
            if ("0".equals(text)) deputyText.setText(s);
            else deputyText.setText(text + s);
        }
        return false;
    }

    public Boolean OperButten(String s, boolean flag) {
        if (flag) {
            return true;
        } else {
            String text = deputyText.getText();
            deputyText.setText(text + s);
            return true;
        }
    }

    public boolean Dot(boolean flag) {
        if (flag) return flag;
        String text = chiefText.getText();
        if (text.contains(".")) return flag;
        else {
            chiefText.setText(text + ".");
            text = deputyText.getText();
            deputyText.setText(text + ".");
            return false;
        }
    }

    public boolean Del(boolean flag) {
        if (flag) {
            String text = deputyText.getText();
            if ("0".equals(text)) return flag;
            else {
                char[] chars = text.toCharArray();
                text = new String(chars, 0, chars.length - 1);
                deputyText.setText(text);
                if (chars.length!=1 && Character.isDigit(chars[chars.length-2])) return false;
                else return true;
            }
        } else {
            String text = chiefText.getText();
            char[] chars = text.toCharArray();
            if (chars.length == 1) {
                chiefText.setText("0");
            } else {
                text = new String(chars, 0, chars.length - 1);
                chiefText.setText(text);
            }
            text = deputyText.getText();
            chars = text.toCharArray();
            if (chars.length == 1) {
                deputyText.setText("0");
                return true;
            } else {
                text = new String(chars, 0, chars.length - 1);
                deputyText.setText(text);
                return false;
            }
        }
    }

    public int Left(int count, boolean flag) {
        if (!flag) {
            return count;
        } else {
            String text = deputyText.getText();
            if ("0".equals(text)) deputyText.setText("(");
            else deputyText.setText(text + "(");
            return count + 1;
        }
    }

    public int Right(int count, boolean flag) {
        if (count == 0) return 0;
        if (flag) {
            return count;
        } else {
            String text = deputyText.getText();
            deputyText.setText(text + ")");
            return count - 1;
        }
    }

    public void Ans(){
        String text = deputyText.getText();
        text = new MyAlgorithm().Calculate(text);
        chiefText.setText(text);
    }

    public void CE() {
        chiefText.setText("0");
        deputyText.setText("0");
    }
}
