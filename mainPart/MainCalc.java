package mainPart;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import mainPart.Extras.StringPixelLegnths;

public class MainCalc {
	//if 8 billion people jumped and landed at the same time the force that this would make would be 305,760,000,000 Newtons
	//numbers = 10/70 (7) pixels horizontal, empty spaces = 20/70 (3.5) pixels horizontal, letters = 15/2 (7.5)
	//Average human hieght 165.25 cm, weight is 60 kg, jump hieght is about 63.5 cm & terminal human velocity is 200 km/h
	//this screen is 1545 horizontal and 875 vertical
	
    private static JFrame frame;
    private static GridBagConstraints c;
	private static int[] framePosition = {569, 569};
	
	@SuppressWarnings("unused")
	private static StringPixelLegnths sPL = new StringPixelLegnths();
	private static JTextField localisation = new JTextField("Europe");
    
    /**
     * Default buttons on menu
     */
        public static void addComponentsToFrame(Container frame) {
        	c = new GridBagConstraints();
		    c.weightx = 0;
		    c.gridx = 0;
		    c.gridwidth = 3;
		    c.gridheight = 10;
		    
		    

    	    c.insets = new Insets(0, 10, 10, 395);
        	makeButton("Binery Decoder & Encoder", () -> {
    			Binery binery = new Binery();
    			binery.framing();
    		    c.gridy = 0;
        	});

    	    c.insets = new Insets(0, 10, 10, 435);
    		makeButton("Calculator & SUVAT", () -> {
		   		frame.setVisible(false);
		   		CalculatorSUVAT calcAndSUVAT = new CalculatorSUVAT();
		   		calcAndSUVAT.framing();
    		    c.gridy = 1;
    		});

    	    c.insets = new Insets(0, 10, 299, 450);
    		makeButton("Mileage & Rivers", () -> {
    			frame.setVisible(false);
    			MileageAndRivers mileageAndRivers = new MileageAndRivers();
    			mileageAndRivers.framing();
    		    c.gridy = 2;
    		});
//
//    	    c.insets = new Insets(0, 10, 289, 490);
//    		makeButton("Intervals", () -> {
//    			frame.setVisible(false);
//    			Intervals intervals = new Intervals();
//    			intervals.framing();
//    		    c.gridy = 2;
//    		});
//    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		

//    		JTextField localisation = new JTextField("Europe");
//    		frame.add(localisation, c);
//    		JTextField consoleLog = new JTextField("");
//    		consoleLog.setEditable(false);
//    		consoleLog.setVisible(false);
//    		frame.add(consoleLog, c);
        }
        
        public static JButton makeButton(String text, Runnable runnable) {////////////////////////
    	    JButton button = new JButton();
    	    button.setText(text);
    	    frame.add(button, c);

    	    button.addActionListener(event -> {
    	    	if(!text.equals("")) {
    	    		frame.setVisible(false);
    	    		runnable.run();
    	    	}else {
    	    		
    	    	}
    	    });

    	    return button;
    	}
        
        /**
         * Sets the default for the frame.
         */
    	public static void framing() {
    	    frame.setLayout(new GridBagLayout());
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds((int)(1545*(1 - 0.39))/2, (int)Math.round((875 - 455)*0.4), 605, 455);
     		frame.setResizable(false);
     		frame.setVisible(true);
    	}
        
        public static void main(String[] args) {
            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                	frame = new JFrame("Menu");
                    framing();
                    addComponentsToFrame(frame.getContentPane());
                }
            });
        }

		public JTextField getLocalisation() {
			return localisation;
		}

		public void setLocalisation(JTextField localisation) {
			MainCalc.localisation = localisation;
		}

		public static int[] getFramePosition() {
			return framePosition;
		}

		public static void setFramePosition(int[] framePosition) {
			MainCalc.framePosition = framePosition;
		}
        
//    		button = new JButton("Button 5");
//    	    constraints.fill = GridBagConstraints.HORIZONTAL;
//    	    constraints.ipady = 0;       //reset to default
//    	    constraints.weighty = 1;   //request any extra vertical space
//    	    constraints.anchor = GridBagConstraints.PAGE_END; //bottom of space
//    	    
//    	    constraints.insets = new Insets(10,0,0,0);  //top padding
//    	    constraints.gridx = 1;       //aligned with button 2
//    	    constraints.gridwidth = 2;   //2 columns wide
//    	    constraints.gridy = 2;       //third row
//    	    frame.add(button, constraints);
        
}
