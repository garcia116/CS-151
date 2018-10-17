


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BarChartTester {
	
	public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new BarChartTester().start();
            }
        });
    }
	
	private void start() {
		BarChart b = new BarChart();
		new DataModel(b);
	}
}
	
class BarChart extends JFrame implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<String> d = new ArrayList<String>();

	@Override
	public void update(Observable o, Object data) {
		
	d.addAll((ArrayList<String>) data);
		repaint();

	}
	
	
	BarChart() {
		
		
		JFrame frame = new JFrame("Bar Graph");
		  frame.getRootPane().setBorder(
		            BorderFactory.createEmptyBorder(20, 20, 20, 20));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setLocation(600, 200);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g)
	{
	super.paint(g);
	boolean b = true;
	if (b ==true)
	{
	
	int v1 = Integer.parseInt(d.get(0));
	int v2 = Integer.parseInt(d.get(1));
	int v3 = Integer.parseInt(d.get(2));
	int v4 = Integer.parseInt(d.get(3));
	int v5 = Integer.parseInt(d.get(4));

	int higher=returnHigher(v1,v2,v3,v4,v5);
	  
	int largo1=v1*400/higher;
	int largo2=v2*400/higher;
	int largo3=v3*400/higher;
	int largo4=v4*400/higher;
	int largo5=v5*400/higher;

	  
	g.setColor(new Color(255,0,0));
	g.fillRect(100,250,largo1,40);
	g.drawString("Number 1", 10, 270);

	g.setColor(new Color(0,128,0));
	g.fillRect(100,300,largo2,40);
	g.drawString("Number 2", 10, 320);

	g.setColor(new Color(0,0,255));
	g.fillRect(100,350,largo3,40);
	g.drawString("Number 3", 10, 370);
	
	g.setColor(new Color(255,0,0));
	g.fillRect(100,250,largo4,40);
	g.drawString("Number 4", 10, 270);
	
	g.setColor(new Color(255,0,0));
	g.fillRect(100,250,largo5,40);
	g.drawString("Number 5", 10, 270);
	}
	}
	
	private int returnHigher(int v1, int v2, int v3, int v4, int v5) {
		if (v1>v2 && v1>v3)
			return v1;
			else
			if (v2>v3)
			return v2;
			else
			return v3;
	}
}

class DataModel {
	
private JPanel contentPane;
private JTextField tf1,tf2,tf3,tf4,tf5;
	
	DataModel(BarChart barChart){
		
		final MessageObservable observable = new MessageObservable();
		observable.addObserver(barChart);
		
		JFrame model = new JFrame("Data Model");
		model.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        model.setLocation(200,200);
        model.setSize(300,300);
        model.setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        model.setContentPane(contentPane);
        contentPane.setLayout(null);
          
        JLabel lblNum1 = new JLabel("Number 1:");
        lblNum1.setBounds(46, 39, 61, 14);
        contentPane.add(lblNum1);
          
        JLabel lblNum2 = new JLabel("Number 2:");
        lblNum2.setBounds(46, 69, 61, 14);
        contentPane.add(lblNum2);
          
        JLabel lblNum3 = new JLabel("Number 3:");
        lblNum3.setBounds(46, 103, 61, 14);
        contentPane.add(lblNum3);
        
        JLabel lblNum4 = new JLabel("Number 4:");
        lblNum4.setBounds(46, 130, 61, 14);
        contentPane.add(lblNum4);
        
        JLabel lblNum5 = new JLabel("Number 5:");
        lblNum5.setBounds(46, 154, 61, 14);
        contentPane.add(lblNum5);
               
        tf1 = new JTextField();
        tf1.setBounds(117, 36, 86, 20);
        contentPane.add(tf1);
        tf1.setColumns(10);
          
        tf2 = new JTextField();
        tf2.setBounds(117, 66, 86, 20);
        contentPane.add(tf2);
        tf2.setColumns(10);
          
        tf3 = new JTextField();
        tf3.setBounds(117, 97, 86, 20);
        contentPane.add(tf3);
        tf3.setColumns(10);
        
        tf4 = new JTextField();
        tf4.setBounds(117,127, 86, 20);
        contentPane.add(tf4);
        tf4.setColumns(10);
        
        tf5 = new JTextField();
        tf5.setBounds(117, 157, 86, 20);
        contentPane.add(tf5);
        tf5.setColumns(10);
        
        String s1=tf1.getText();
		String s2=tf2.getText();
		String s3=tf3.getText();
		String s4=tf4.getText();
		String s5=tf5.getText();


                           
        JButton btnGraphics = new JButton("Graphing");
        btnGraphics.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		ArrayList<String> data = new ArrayList<String>();
        		data.add(s1);
        		data.add(s2);
        		data.add(s3);
        		data.add(s4);
        		data.add(s5);
        		observable.changeData(data);  		
        		       		
        	}
        	});
        btnGraphics.setBounds(45, 190, 107, 37);
        contentPane.add(btnGraphics);
    	
	}
	
}

class MessageObservable extends Observable {

    MessageObservable() {
	
        super();
    }
    void changeData(Object data) {
	
        setChanged(); // the two methods of Observable class
        notifyObservers(data);
        
    }
}




