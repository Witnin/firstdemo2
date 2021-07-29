package com.wsy.firstdemo.util;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JPanel {
        public ImageIcon im;
        public Image img;
        public Graphics g;


    public static void main(String[] args) {
            Counter counter = new Counter();
            counter.run();
        }

        public void run() {

            CouterListener couterListener = new CouterListener();
            // 窗体属性
            JFrame frame = new JFrame("计算器");
            FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);// 上下左右间距为10
            frame.setLayout(fl);
            frame.setSize(270, 400);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(3);
            frame.setResizable(false);// 固定窗体的大小
            // 背景
//            im = new ImageIcon("plane\\cat_500_500.jpg");
//            JLabel label = new JLabel(im);
//            label.setPreferredSize(new Dimension(250, 200));// 非顶级容器大小设置方法
//            frame.add(label);
            // 文本域
            JTextArea field = new JTextArea();// 多行文本域
            field.setPreferredSize(new Dimension(250, 50));
            field.setRows(3);// 设置文本域的行数
            frame.add(field);
            couterListener.setJText(field);
            // 按钮
            String btArray[] = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8",
                    "9", "*", ".", "0", "=", "/" };

            this.setLayout(new GridLayout(4, 4, 10, 10));
            frame.add(this);
            for (int i = 0; i < btArray.length; i++) {
                JButton button = new JButton(btArray[i]);
                button.setFont(new Font("宋体", Font.PLAIN, 30));// 设置按钮字体、大小、颜色
                button.setForeground(Color.BLACK);
                button.setPreferredSize(new Dimension(50, 50));
                // button.setOpaque(false);//设置按钮透明度
                // button.setBackground(new Color(255, 255, 255));
                button.setContentAreaFilled(false); // 设置按钮透明度(方法二)， 只须加上此句
                this.add(button);
                button.addActionListener(couterListener);// 给按钮加监听
            }

            frame.setVisible(true);
            g = frame.getGraphics();
        }
    }

    //这是监听类


