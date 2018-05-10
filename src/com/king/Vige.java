package com.king;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class Vige extends JFrame{
    public Vige() {
        Container container = getContentPane();
        getContentPane().setLayout(new FlowLayout(1, 20, 15));//居中对齐，横纵间距30
        setTitle("维吉尼亚算法加解密");

        JLabel jtile = new JLabel("维吉尼亚算法加解密器");
        JLabel jl1 = new JLabel("密钥：");
        JLabel jl2 = new JLabel("密文：");
        JLabel jl3 = new JLabel("明文：");
        JLabel jlanswer = new JLabel();
        jlanswer.setFont(new   java.awt.Font("Dialog",   1,   20));

        JTextField jt1 = new JTextField(30);
        JTextField jt2 = new JTextField(30);
        JTextField jt3 = new JTextField(30);

        JButton jb1 = new JButton("加密");
        JButton jb2 = new JButton("解密");

        add(jtile);
        add(Box.createHorizontalStrut(30000));
        add(jl1);
        add(jt1);
        add(Box.createHorizontalStrut(30000));
        add(jl2);
        add(jt2);
        add(Box.createHorizontalStrut(30000));
        add(jl3);
        add(jt3);
        add(Box.createHorizontalStrut(30000));
        add(jb1);
        add(jb2);
        add(Box.createHorizontalStrut(30000));

        jb1.addActionListener(//明文+密钥-'a'=密文
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str1, str2,str_answer;
                        char c;
                        int len;
                        str1 = jt1.getText().toString();
                        str2 = jt3.getText().toString();

                        str1=str1.replace(" ","");
                        str1=str1.toLowerCase();
                        str2=str2.replace(" ","");
                        str2=str2.toLowerCase();

                        len = str1.length();
                        str_answer=str1;
                        StringBuilder str_builder = new StringBuilder(str_answer);
                        if (len != 0 && len == str2.length()) {
                            for (int i = 0; i < len; i++) {
                                c = (char) (str1.charAt(i) + str2.charAt(i) - 'a');
                                if(c>'z')
                                    c-=26;
                                str_builder.setCharAt(i, c);
                            }
                            str_answer=str_builder.toString();
                            jlanswer.setText("加密结果为："+str_answer);
                            add(jlanswer);
                        } else
                            JOptionPane.showMessageDialog(null,  "请输入正确长度的密钥和明文！", "出错啦",JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        jb2.addActionListener(//明文=密文-密钥+'a'
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str1, str2,str_answer;
                        char c;
                        int len;
                        str1 = jt1.getText().toString();
                        str2 = jt2.getText().toString();

                        str1=str1.replace(" ","");
                        str1=str1.toLowerCase();
                        str2=str2.replace(" ","");
                        str2=str2.toLowerCase();

                        len = str1.length();
                        str_answer=str1;
                        StringBuilder str_builder = new StringBuilder(str_answer);
                        if (len != 0 && len == str2.length()) {
                            for (int i = 0; i < len; i++) {
                                c = (char) (str2.charAt(i) - str1.charAt(i) + 'a');
                                if(c<'a')
                                    c+=26;
                                str_builder.setCharAt(i, c);
                            }
                            str_answer=str_builder.toString();
                            jlanswer.setText("解密结果为："+str_answer);
                            add(jlanswer);
                        } else
                            JOptionPane.showMessageDialog(null, "请输入正确长度的密钥和密文！","出错啦",  JOptionPane.ERROR_MESSAGE);
                    }
                }
        );

        add(jlanswer);
        setVisible(true);
        setBackground(Color.white);
        setSize(700, 400);
        setLocationRelativeTo(null);//居中

    }

    public static void main(String args[])
    {
        new Vige();
    }
}
