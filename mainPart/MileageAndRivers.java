package mainPart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import mainPart.Extras.StringPixelLegnths;

public class MileageAndRivers {
	
	private JFrame frame;
	private int[] framePosition = {600, 450};
	@SuppressWarnings("unused")
	private StringPixelLegnths sPL = new StringPixelLegnths();
	
	
	public MileageAndRivers() {
		frame = new JFrame("Mileage & Rivers");
		
		JTextField consoleLog = new JTextField("");
		consoleLog.setEditable(false);
		consoleLog.setVisible(false);
		int horizontalC = 150;
		int verticalC = 25;
		consoleLog.setBounds(framePosition[0] - (100 + horizontalC + 10), framePosition[1] - (verticalC + 45), horizontalC, verticalC);
		frame.add(consoleLog);
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void framing() {
		JButton backToMenuButton = new JButton();
		backToMenuButton.setText("Back");
		frame.add(backToMenuButton);
		backToMenuButton.setBounds(framePosition[0] - 100, framePosition[1] - 70, 75, 25);
		backToMenuButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MainCalc();
				MainCalc.main(null);
			}
		});
		
		frame.setLayout(null);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		frame.setSize(framePosition[0], framePosition[1]);
 		frame.setResizable(false);
 		frame.setVisible(true);
	}
	
}
