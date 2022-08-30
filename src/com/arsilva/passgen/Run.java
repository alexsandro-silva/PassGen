package com.arsilva.passgen;

import com.arsilva.passgen.views.MainForm;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Run {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setContentPane(new MainForm().getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
