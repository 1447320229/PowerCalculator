package com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLinstener implements ActionListener {
    private CalculatorGUI frame;
    private boolean flag = true;
    private int count = 0;

    public MyLinstener(CalculatorGUI frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "0":

                flag = frame.IntButten("0", flag);
                break;
            case "1":
                flag = frame.IntButten("1", flag);
                break;
            case "2":
                flag = frame.IntButten("2", flag);
                break;
            case "3":
                flag = frame.IntButten("3", flag);
                break;
            case "4":
                flag = frame.IntButten("4", flag);
                break;
            case "5":
                flag = frame.IntButten("5", flag);
                break;
            case "6":
                flag = frame.IntButten("6", flag);
                break;
            case "7":
                flag = frame.IntButten("7", flag);
                break;
            case "8":
                flag = frame.IntButten("8", flag);
                break;
            case "9":
                flag = frame.IntButten("9", flag);
                break;
            case "+":
                flag = frame.OperButten("+", flag);
                break;
            case "-":
                flag = frame.OperButten("-", flag);
                break;
            case "*":
                flag = frame.OperButten("*", flag);
                break;
            case "/":
                flag = frame.OperButten("/", flag);
                break;
            case "=":
                frame.Ans();
                break;
            case ".":
                flag = frame.Dot(flag);
                break;
            case "CE":
                frame.CE();
                break;
            case "Del":
                flag = frame.Del(flag);
                break;
            case "(":
                count = frame.Left(count, flag);
                break;
            case ")":
                count = frame.Right(count, flag);
                break;

        }
    }

}
