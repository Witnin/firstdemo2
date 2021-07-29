package com.wsy.firstdemo.util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//这是监听类
public class CouterListener implements ActionListener {
    private JTextArea JF;
    public int x = 0;
    public int flag = 1;
    public Double resulte = 0.0, temp;
    public String num[] = new String[3];
    public String count;

    public void setJText(JTextArea F) {// 接受文本框，用于监听输出
        JF = F;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "+" || e.getActionCommand() == "-"
                || e.getActionCommand() == "*" || e.getActionCommand() == "/") {
            JF.setText(JF.getText() + e.getActionCommand() + "\n");
            if (flag == 1)
                resulte = temp;
            count = e.getActionCommand();
            flag = 0;
        } else if (e.getActionCommand() == "=") {
            if (count == "+") {
                resulte = resulte + temp;
                JF.setText(resulte + "");
            } else if (count == "-") {
                resulte = resulte - temp;
                JF.setText(resulte + "");
            } else if (count == "*") {
                resulte = resulte * temp;
                JF.setText(resulte + "");
            } else if (count == "/") {
                resulte = resulte / temp;
                JF.setText(resulte + "");
            }
        } else {// 如果输入非数字输出到文本框并换行
            JF.setText(JF.getText() + e.getActionCommand());
            if (flag == 0) {
                num = JF.getText().split("\\n");
                temp = Double.parseDouble(num[1]);
            } else {
                temp = Double.parseDouble(JF.getText());
            }
        }
    }
}
