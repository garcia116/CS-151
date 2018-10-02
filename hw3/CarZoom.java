import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;



public class CarZoom extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	float width, height;
	
	public CarZoom() {
		width = height = 1;
	}
	
	public CarZoom(Image img) {
		this.img = new ImageIcon(img).getImage();
		width = height = 1;
	}
	
	public CarZoom(ImageIcon icon) {
		this(icon.getImage());
	}
	
	public void setImage(Image img) {
		this.img = img;
		revalidate();
		repaint();
	}
	
	
	public void setDimensions(float width, float height) {
		this.height = height;
		this.width = width;
		revalidate();
		repaint();
	}
	
    @Override
    public void paintComponent(Graphics g) {	
        if(img == null)
            return;

        int w = (int) (img.getWidth(null) * width);
        int h = (int) (img.getHeight(null) * height);

        int x = (getWidth()-w)/2;
        int y = (getHeight()-h)/2;

        g.drawImage(img,x,y,w,h, null);
    }

	public static void main(String[] args) {
		
		    JFrame frame = new JFrame();
		    final CarZoom label = new CarZoom();
			
			try {
				Image car = ImageIO.read(new File("C:/Users/Gerardo/Desktop/object oriented design/Car.png"));
			    label.setImage(car);

			} catch (IOException e) {
				System.err.println("Couldn't load image.");
				e.printStackTrace();
			}   

	        final JButton zoomInButton = new JButton ("Zoom In");
	        final JButton zoomOutButton = new JButton ("Zoom Out");
	        
	        ActionListener listener = new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	int i = 50;
	            	int x = 50;
	            	
	                 	if (event.getSource() == zoomInButton){
	                	 label.setDimensions(i*.01f,x*.01f);
	                 } else {
	                	 label.setDimensions(i*.01f, x*.01f);
	                 }
	            }
	        };
	        
	        zoomInButton.addActionListener(listener);
	        zoomOutButton.addActionListener(listener);
	        
	        frame.add(zoomInButton, BorderLayout.SOUTH);
	        frame.add(zoomOutButton, BorderLayout.PAGE_START);
	        frame.add(label, BorderLayout.CENTER);
	        frame.setSize(500,500);
	        frame.setLocationRelativeTo(null);

	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);

	}

	

	

}
