package mainPart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mainPart.Extras.StringPixelLegnths;

public class Binery {
	
	private JFrame frame;
	private int[] framePosition = {350, 350};
	private StringPixelLegnths sPL = new StringPixelLegnths();

	public Binery() {
		frame = new JFrame("Binary");
		
		JTextField consoleLog = new JTextField("");
		consoleLog.setEditable(false);
		consoleLog.setVisible(false);
		int horizontalC = 180;
		int verticalC = 25;
		consoleLog.setBounds(framePosition[0] - (100 + horizontalC + 10), framePosition[1] - (verticalC + 45), horizontalC, verticalC);
		frame.add(consoleLog);
		
		
		
		JLabel binaryLabel = new JLabel("Binary Input:");
		binaryLabel.setBounds(10, 10, 100, 25);
		frame.add(binaryLabel);
		
		JTextField binary = new JTextField("110110");
		binary.setBounds(105, 10, (int) (50 - sPL.getDigitSpace()), 25);
		frame.add(binary);
		
		JLabel tenthLabel = new JLabel("Result:");
		tenthLabel.setBounds(10, 40, 100, 25);
		frame.add(tenthLabel);
		
		JTextField result = new JTextField();
		result.setEditable(false);
		result.setBounds(105, 40, 28, 25);
		frame.add(result);
		
		JLabel resultLabel = new JLabel();
		resultLabel.setBounds(105 + 35, 40, framePosition[0] - (100 + 100), 25);
		frame.add(resultLabel);
         
		
        JButton decodeButton = new JButton();
		decodeButton.setText("Decode");
		frame.add(decodeButton);
		decodeButton.setBounds(10, 70, 80, 25);
		decodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleLog.setVisible(false);
				result.setText("");
				resultLabel.setText("");
				
				String bitt = binary.getText();
				
				if(bitt.matches("[0-1]+")) {
					consoleLog.setText("");
					char[] bit = bitt.toCharArray();
					
					int[] bits = new int[bit.length];
					
					bits[0] = Character.getNumericValue(bit[0]);
					
		            for(int i = 1; i < bits.length; i++) {
	            		bits[i] = Character.getNumericValue(bit[i]);
		            }
		            
					if(!consoleLog.getText().contains("Case")) {
						int m = bit.length - 1;
				        int sum = 0;
				        String a = "";
				        if(bit.length != 1) {
					        for(int i: bits) {
					        	int part = (int) (i * Math.pow(2, m)); //decoded result = bits[0] * 2^m + bits[1] * 2^m ...
					        	sum += part;
					        	if(a.equals("") && part != 0) {
					        		a += " " + part;
					        	}else if(part != 0){
					        		a += " + " + part;
					        	}
					        	m--;
							}
				        	a = "=" + a;
				        }

		                double b = ((sum + "").toString().length()) * sPL.getDigitSpace() + 5;
				        
				        if(sum == 0) {
				        	a = " - zero is equal to zero (lol)";
				        	b = 12;
				        }
				        
				        
				        result.setBounds(105, 40,(int) b, 25);
		                binary.setBounds(105, 10, Integer.parseInt(((int)(bitt.length() * sPL.getDigitSpace()) + 5) + ""), 25);
		                resultLabel.setBounds(105 + (int) b, 40, framePosition[0] - (100 + 95), 25);
				        result.setText(sum + "");
				        resultLabel.setText(a);
			        }
				}else {
					consoleLog.setVisible(true);
            		if(bitt.equals("")) {
            			consoleLog.setText("Case - empty");
            		}else if(bitt.matches("[2-9]+")){
            			consoleLog.setText("Case - Invalid number");
            		}else {
            			consoleLog.setText("Case - NAN (Not A Number)");
            		}
            		int g = 0;
            		for(char c: consoleLog.getText().toCharArray()) {
            			if((c + "").equals(" ")) {
            				g += sPL.getEmptySpace();
            			}else {
            				g += sPL.getLetterSpace();
            			}
            		}
            		consoleLog.setBounds(framePosition[0] - (100 + g + 10), framePosition[1] - (verticalC + 45), g, verticalC);
    				binary.setBounds(105, 10, 70, 25);
    				result.setBounds(105, 40, 28, 25);
				}
			}
		});
		
		
		
		JButton encodeButton = new JButton();
		encodeButton.setText("Encode");
		frame.add(encodeButton);
		encodeButton.setBounds(10, 100, 80, 25);
		encodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleLog.setVisible(false);
				result.setText("");
				resultLabel.setText("");
				
				String inp = binary.getText();
				
				if((inp + "").matches("[0-9]+")) {
					int input = Integer.parseInt(binary.getText());
					consoleLog.setText("");
						
					if(!consoleLog.getText().contains("Case")) {
						ArrayList<Integer> bits = new ArrayList<Integer>();
						
						 int n = 0;
		                for (int a = input; a > 0; a /= 2)
		                {
		                    if (a % 2 == 1)
		                    {
		                        a--;
		                    }
		                    n++;
		                }
	
		                for (int i = 0; i < n; i++){
		                    if(input % 2 == 0){
		                        input /= 2;
		                        bits.add(i, 0);
		                    }else if(input % 2 == 1){
		                        input--;
		                        input /= 2;
		                        bits.add(i, 1);
		                    }
		                }
		                
		                String num = "";
		                String a = "";
		                int b = bits.size() * 7 + 5;
		                
		                for(int i = bits.size() - 1; i >= 0; i--) {
		                	num += bits.get(i);
		                }
	
	
				        if(num.equals("")) {
				        	a = " - zero is equal to zero (lol)";
				        	num = "0";
				        	b = 12;
				        }
				        
				        
				        
		                result.setBounds(105, 40, b, 25);
		                binary.setBounds(105, 10, binary.getText().length() * 7 + 5, 25);
		                resultLabel.setBounds(105 + (bits.size() + 1) * 7 + 5, 40, framePosition[0] - (100 + 95), 25);
				        result.setText(num);
				        resultLabel.setText(a);
					}
				}else {
					consoleLog.setVisible(true);
            		if(inp.equals("")) {
            			consoleLog.setText("Case - empty");
            		}else {
            			consoleLog.setText("Case - NAN (Not A Number)");
            		}
            		int g = 0;
            		for(char c: consoleLog.getText().toCharArray()) {
            			if((c + "").equals(" ")) {
            				g += sPL.getEmptySpace();
            			}else {
            				g += sPL.getLetterSpace();
            			}
            		}
            		consoleLog.setBounds(framePosition[0] - (100 + g + 10), framePosition[1] - (verticalC + 45), g, verticalC);
    				binary.setBounds(105, 10, 70, 25);
    				result.setBounds(105, 40, 28, 25);
				}
			}
		});
		
		
		
		JButton clearButton = new JButton();
		clearButton.setText("Clear");
		frame.add(clearButton);
		clearButton.setBounds(105, 70, 70, 25);
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consoleLog.setVisible(false);
				binary.setText("");
				result.setText("");
				resultLabel.setText("");
				binary.setBounds(105, 10, 70, 25);
				result.setBounds(105, 40, 28, 25);
			}
		});
		
		

		
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
