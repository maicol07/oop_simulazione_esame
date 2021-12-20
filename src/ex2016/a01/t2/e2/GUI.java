package ex2016.a01.t2.e2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class GUI {
	private Controller controller;
    
    public GUI(String fileName){
        JFrame jf = new JFrame();
        JButton jb1 = new JButton("INCINC");
        JButton jb2 = new JButton("RAND");
        JButton jb3 = new JButton("UNO");
        JButton jbOK = new JButton("OK");
        
        JPanel jp = new JPanel();
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jbOK);
        jf.getContentPane().add(jp);
        jf.pack();
        jf.setVisible(true);
        
        controller = new Controller(fileName);
        
        jb1.addActionListener(event -> controller.handleIncInc());
        jb2.addActionListener(event -> controller.handleRandom());
        jb3.addActionListener(event -> controller.handleUno());
        
        jbOK.addActionListener(e -> controller.handleOk());
    }

}
