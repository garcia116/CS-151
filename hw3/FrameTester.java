
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.*;


public class FrameTester implements Icon {   

    public static void main(String[] args) {
    	
        JFrame frame = new JFrame();
        FrameTester circle = new FrameTester();
        final JLabel label = new JLabel(circle);

        final int FIELD_WIDTH = 20;

        JTextField textField = new JTextField(FIELD_WIDTH);
        textField.setText("Click a button!");

        final JButton redButton = new JButton ("Red");
        final JButton greenButton = new JButton ("Green");
        final JButton blueButton = new JButton ("Blue");
        
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
            	 Color color;
                 if (event.getSource() == redButton){
                     color = Color.red;
                     circle.setColor(color);
                 } else if (event.getSource() == greenButton){
                     color = Color.green;
                     circle.setColor(color);
                 } else {
                     color = Color.blue;
                     circle.setColor(color);
 
                 }
                 label.repaint();
            }
        };

        redButton.addActionListener(listener);
        blueButton.addActionListener(listener);
        greenButton.addActionListener(listener);
        
        frame.add(blueButton);
        frame.add(greenButton);
        frame.add(redButton);	
        frame.add(textField);
        frame.add(label);
        frame.setVisible(true);
        
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
    
    private Color color;

    public FrameTester() {
        color = Color.red;
    }

    @Override
    public int getIconWidth() {
        return 10;
    }

    @Override
    public int getIconHeight() {
        return 10;
    }

    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 10, 10);
        g2.setColor(color);
        g2.fill(circle);
    } 
}
