package mainPart;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mainPart.Extras.SUVATextension;
import mainPart.Extras.StringPixelLegnths;

public class CalculatorSUVAT {
	
	private JFrame frame;
	private int[] framePosition = {910, 600};
	@SuppressWarnings("unused")
	private StringPixelLegnths sPL = new StringPixelLegnths();
	private int consoleH = 100;
	private int consoleV = 25;
	private JTextField consoleLog;
		
		public CalculatorSUVAT() {
			
			ArrayList<JTextField> textFields = new ArrayList<JTextField>();

			frame = new JFrame("Calculator & SUVAT");


			
			JLabel label1 = new JLabel("Number 1:");
			label1.setBounds(10, 10, 100, 25);
			frame.add(label1);
			JTextField number1 = new JTextField();								
			number1.setBounds(80, 10, 50, 25);		
			frame.add(number1);
			textFields.add(number1);

			
			JLabel label2 = new JLabel("Number 2:");
			label2.setBounds(10, 40, 100, 25);
			frame.add(label2);
			JTextField number2 = new JTextField();
			number2.setBounds(80, 40, 50, 25);
			frame.add(number2);
			textFields.add(number2);

			
			JLabel label3 = new JLabel("Result:");
			label3.setBounds(10, 70, 100, 25);
			frame.add(label3);
			JTextField result = new JTextField();
			result.setEditable(false);
			result.setBounds(80, 70, 50, 25);
			frame.add(result);
			textFields.add(result);
			
			
			JLabel label4 = new JLabel("Remainder:");
			label4.setBounds(135, 70, 100, 25);
			frame.add(label4);
			JTextField remainder = new JTextField();
			remainder.setEditable(false);
			remainder.setBounds(215, 70, 125, 25);
			frame.add(remainder);
			textFields.add(remainder);
			
			
			JButton clearButton = new JButton("Clear");
			frame.add(clearButton);
			clearButton.setBounds(135, 10, 130/2, 25);
			clearButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(JTextField t: textFields) {
						t.setText("");
					}
				}
			});
			
			//---------------------------------------------------------------------------------------------------------------------------------

			JLabel memorylabel = new JLabel("Previous calculations:");
			memorylabel.setBounds(345, 10, 400/3, 25);
			frame.add(memorylabel);
			
			JTextField memory = new JTextField("");
			memory.setEditable(false);
			memory.setBounds(355+(400/3), 10, 400, 25);
			frame.add(memory);
			
			JButton clearMemory = new JButton("Clear Memory");
			frame.add(clearMemory);
			clearMemory.setBounds(345, 40, 120, 25);
			clearMemory.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					memory.setText("");
				}
			});
			
			//---------------------------------------------------------------------------------------------------------------------------------

			
			
			
			JButton plusButton = new JButton("+");
			frame.add(plusButton);
			plusButton.setBounds(10, 110, 45, 25);
			plusButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					consoleLog.setText("");
					result.setText("");
					if(isInputValid(number1, number2)){
						consoleLog.setVisible(false);
						frame.remove(consoleLog);
						double n1 = Double.parseDouble(number1.getText());
						double n2 = Double.parseDouble(number2.getText());
						result.setText("" + (n1 + n2));
						if(memory.getText().equals("")) {
							memory.setText("" + (n1 + n2) + " = " + n1 + " + " + n2);
						}else {
							memory.setText(memory.getText() + " | " + (n1 + n2) + " = " + n1 + " + " + n2);
						}
					}
					consoleLog.setBounds(framePosition[0] - (100 + consoleLog.getText().length() * 8 + 10)
							 , framePosition[1] - (consoleV + 45), consoleLog.getText().length() * 8, consoleV);
				}
			});
			
			
			JButton minusButton = new JButton("-");
			frame.add(minusButton);
			minusButton.setBounds(60, 110, 45, 25);
			minusButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					consoleLog.setText("");
					result.setText("");
					if(isInputValid(number1, number2)){
						consoleLog.setVisible(false);
						frame.remove(consoleLog);
						double n1 = Double.parseDouble(number1.getText());
						double n2 = Double.parseDouble(number2.getText());
						result.setText("" + (n1 - n2));
						if(memory.getText().equals("")) {
							memory.setText("" + (n1 - n2) + " = " + n1 + " - " + n2);
						}else {
							memory.setText(memory.getText() + " | " + (n1 - n2) + " = " + n1 + " - " + n2);
						}
					}
					consoleLog.setBounds(framePosition[0] - (100 + consoleLog.getText().length() * 8 + 10)
							 , framePosition[1] - (consoleV + 45), consoleLog.getText().length() * 8, consoleV);
				}
			});
			
			JButton mulButton = new JButton("*");
			frame.add(mulButton);
			mulButton.setBounds(110, 110, 45, 25);
			mulButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					consoleLog.setText("");
					result.setText("");
					if(isInputValid(number1, number2)){
						consoleLog.setVisible(false);
						frame.remove(consoleLog);
						double n1 = Double.parseDouble(number1.getText());
						double n2 = Double.parseDouble(number2.getText());
						result.setText("" + (n1 * n2));
						if(memory.getText().equals("")) {
							memory.setText("" + (n1 * n2) + " = " + n1 + " * " + n2);
						}else {
							memory.setText(memory.getText() + " | " + (n1 * n2) + " = " + n1 + " * " + n2);
						}
					}
					consoleLog.setBounds(framePosition[0] - (100 + consoleLog.getText().length() * 8 + 10)
							 , framePosition[1] - (consoleV + 45), consoleLog.getText().length() * 8, consoleV);
				}
			});
			
			JButton divisionButton = new JButton("/");
			frame.add(divisionButton);
			divisionButton.setBounds(160, 110, 45, 25);
			
			JLabel label5 = new JLabel("Accuracy(Decimals):");
			label5.setBounds(framePosition[0] - (50 + 130), framePosition[1] - (70 + 30), 120, 25);
			frame.add(label5);
			JTextField decimals = new JTextField("2");
			decimals.setEditable(true);
			decimals.setBounds(framePosition[0] - 50, framePosition[1] - (70 + 30), 25, 25);
			frame.add(decimals);
			
			divisionButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int d = Integer.parseInt(decimals.getText());
					consoleLog.setText("");
					result.setText("");
					if(isInputValid(number1, number2)){
						consoleLog.setVisible(false);
						frame.remove(consoleLog);
						if(d >= 0) {
							double n1 = Double.parseDouble(number1.getText());
							double n2 = Double.parseDouble(number2.getText());
							if(n2 != 0) {
								int r = (int) (n1 % n2);
								double n3 = ((double)Math.round((n1/n2)* Math.pow(10, d)))/Math.pow(10, d);
								result.setText("" + n3);
								if(r != 0) {
									remainder.setText(r + " | " + ((int) (n1 / n2) + " + " + r + "/" + (int)(n2)));
								}
	
								if(memory.getText().equals("")) {
									memory.setText("" + n3 + " = " + n1 + " / " + n2);
								}else {
									memory.setText(memory.getText() + " | " + n3 + " = " + n1 + " / " + n2);
								}
							}
						}else {
							frame.add(consoleLog);
							consoleLog.setText("Digits can't be negative");
						}
						
					}
					consoleLog.setBounds(framePosition[0] - (100 + consoleLog.getText().length() * 8 + 10)
							 , framePosition[1] - (consoleV + 45), consoleLog.getText().length() * 8, consoleV);
				}
			});
			
			//-----------------------------------------------------------------------------------------------------
			
			
			JLabel SVT = new JLabel();
			SVT.setText("Value         | Units");
			SVT.setBounds(138, 150, 130, 25);
			frame.add(SVT);

			JLabel label6 = new JLabel();
			label6.setText("'S' (Distance) =");
			label6.setBounds(10, 180, 100, 25);
			frame.add(label6);
			JTextField S = new JTextField("");
			S.setBounds(105, 180, 50+40, 25);			
			frame.add(S);

			JLabel label7 = new JLabel();
			label7.setText("'t' (Time) =");
			label7.setBounds(10, 210, 100, 25);
			frame.add(label7);
			JTextField T = new JTextField("");
			T.setBounds(105, 210, 50+40, 25);			
			frame.add(T);

			JLabel label8 = new JLabel();
			label8.setText("'V' (Velocity) =");
			label8.setBounds(10, 240, 100, 25);
			frame.add(label8);
			JTextField V = new JTextField("");
			V.setBounds(105, 240, 50+40, 25);			
			frame.add(V);
			
			JTextField sUnits = new JTextField("km");
			sUnits.setBounds(160+40, 180, 70/2, 25);
			frame.add(sUnits);
			
			JTextField vUnits = new JTextField("km/h");
			vUnits.setBounds(160+40, 240, 70/2, 25);			
			frame.add(vUnits);
			
			JTextField tUnits = new JTextField("h");
			tUnits.setBounds(160+40, 210, 70/2, 25);			
			frame.add(tUnits);
			
			
			
			JButton calculateButton = new JButton("Calculate");
			frame.add(calculateButton);
			calculateButton.setBounds(10, 275, 110, 25);
			calculateButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int d = Integer.parseInt(decimals.getText());
					consoleLog.setVisible(false);
					consoleLog.setText("");
					
					if(d >= 0) {
						SUVATextension suvat;
						if(S.getText().equals("")) {
							if(V.getText().equals("") && T.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 2");
							}else if(V.getText().equals("") || T.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 1");
							}else {
								Double Time = Double.parseDouble(T.getText());
								Double Velocity = Double.parseDouble(V.getText());
								suvat = new SUVATextension((double)(Time * Velocity), Time, Velocity, sUnits, tUnits, vUnits, d, consoleLog);
								

								S.setEditable(false);
								S.setText(suvat.extension("s"));
								consoleLog.setText(suvat.getConsoleLogText());
								
//								if(suvat.extension("s")[1].equals("sUnits")) {
//									sUnits.setText(suvat.getValues("sUnits"));
//								}else if(suvat.extension("t")[1].equals("tUnits")) {
//									tUnits.setText(suvat.getValues("tUnits"));
//								}else if(suvat.extension("v")[1].equals("vUnits")) {
//									vUnits.setText(suvat.getValues("vUnits"));
//								}
								
							}
						}else if(T.getText().equals("")) {
							if(V.getText().equals("") && S.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 2");
							}else if(V.getText().equals("") || S.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 1");
							}else {
								Double Velocity = Double.parseDouble(V.getText());
								Double Distance = Double.parseDouble(S.getText());
								suvat = new SUVATextension(Distance, ((double)Math.round
										(Distance / Velocity * Math.pow(10, d)) / Math.pow(10, d)), Velocity, sUnits, tUnits, vUnits, d, consoleLog);
								
								T.setEditable(false);
								T.setText(suvat.extension("t"));
								consoleLog.setText(suvat.getConsoleLogText());
								
//								if(suvat.extension("s")[1].equals("sUnits")) {
//									sUnits.setText(suvat.getValues("sUnits"));
//								}else if(suvat.extension("t")[1].equals("tUnits")) {
//									tUnits.setText(suvat.getValues("tUnits"));
//								}else if(suvat.extension("v")[1].equals("vUnits")) {
//									vUnits.setText(suvat.getValues("vUnits"));
//								}


							}
						}else if(V.getText().equals("")) {
							if(S.getText().equals("") && T.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 2");
							}else if(S.getText().equals("") || T.getText().equals("")) {
								consoleLog.setVisible(true);
								consoleLog.setText("Missing Inputs - 1");
							}else {
								Double Time = Double.parseDouble(T.getText());
								Double Distance = Double.parseDouble(S.getText());
								suvat = new SUVATextension(Distance, Time, ((double)Math.round
										(Distance / Time * Math.pow(10, d)) / Math.pow(10, d)), sUnits, tUnits, vUnits, d, consoleLog);
								
								V.setEditable(false);
								V.setText(suvat.extension("v"));
								consoleLog.setText(suvat.getConsoleLogText());
								
//								if(suvat.extension("s")[1].equals("sUnits")) {
//									sUnits.setText(suvat.getValues("sUnits"));
//								}else if(suvat.extension("t")[1].equals("tUnits")) {
//									tUnits.setText(suvat.getValues("tUnits"));
//								}else if(suvat.extension("v")[1].equals("vUnits")) {
//									vUnits.setText(suvat.getValues("vUnits"));
//								}

								
							}
						}else {
							consoleLog.setVisible(true);
							consoleLog.setText("Incorrect Inputs");
						}
						

						if(!consoleLog.getText().equals("")) {
							consoleLog.setBounds(framePosition[0] - (100 + (consoleLog.getText().length() * 12) + 10), framePosition[1] - (consoleV + 45), (consoleLog.getText().length() * 12), consoleV);
						}else {
							consoleLog.setVisible(true);
							if(sUnits.getText().length() > 2) {//do if more
								sUnits.setBounds(200, 180, sUnits.getText().length() * 10, 25);
							}else if(tUnits.getText().length() > 1) {
								tUnits.setBounds(200, 210, tUnits.getText().length() * 8, 25);
							}else if(vUnits.getText().length() > 4) {
								vUnits.setBounds(200, 240, vUnits.getText().length() * 12, 25);
							}
							
							if(memory.getText().equals("")) {
								memory.setText(S.getText() + " " + sUnits.getText() + " = " 
							    + V.getText() + " " + vUnits.getText() + " * " + T.getText() + " " + tUnits.getText());
							}else {
								memory.setText(memory.getText() + " | " + S.getText() + " " + sUnits.getText() + " = " 
									    + V.getText() + " " + vUnits.getText() + " * " + T.getText() + " " + tUnits.getText());
							}
						}
					}
				}
			});
			
			
			JButton clearSVTUnitsButton = new JButton("Clear Units");
			frame.add(clearSVTUnitsButton);
			clearSVTUnitsButton.setBounds(130, 305, 110, 25);
			clearSVTUnitsButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					sUnits.setText("");
					vUnits.setText("");
					tUnits.setText("");
					sUnits.setBounds(160+40, 180, 70/2, 25);
					tUnits.setBounds(160+40, 210, 70/2, 25);
					vUnits.setBounds(160+40, 240, 70/2, 25);
					consoleLog.setText("");
					frame.remove(consoleLog);
				}
			});

			JButton clearSVTButton = new JButton("Clear Values");
			frame.add(clearSVTButton);
			clearSVTButton.setBounds(130, 275, 110, 25);
			clearSVTButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					S.setText("");
					S.setEditable(true);
					V.setText("");
					V.setEditable(true);
					T.setText("");
					T.setEditable(true);
					consoleLog.setText("");
					consoleLog.setVisible(false);
				}
			});
			
			JButton clearAllButton = new JButton("Clear All");
			frame.add(clearAllButton);
			clearAllButton.setBounds(10, 305, 110, 25);
			clearAllButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					for(JTextField t: textFields) {
						t.setText("");
					}
					S.setText("");
					S.setEditable(true);
					V.setText("");
					V.setEditable(true);
					T.setText("");
					T.setEditable(true);
					sUnits.setText("");
					vUnits.setText("");
					tUnits.setText("");
					sUnits.setBounds(160+40, 180, 70/2, 25);
					tUnits.setBounds(160+40, 210, 70/2, 25);
					vUnits.setBounds(160+40, 240, 70/2, 25);
					consoleLog.setText("");
					consoleLog.setVisible(false);
					
				}
			});
			
		}
		
		public boolean checkIfStringIsNumber(String h) {
			boolean g = false;
			if(h.matches(".*\\d.*")) {
				g = true;
			}
			return g;
		}
		
		public boolean isTextFieldEmpty(JTextField tf) {
			boolean g = false;
			if(tf.getText().equals("")) {
				g = true;
			}
			return g;
		}
		
		public int getConsoleH() {
			return consoleH;
		}
		
		public void setConsoleH(int consoleH) {
			this.consoleH = consoleH;
		}
		
		public int getConsoleV() {
			return consoleV;
		}
		
		public void setConsoleV(int consoleV) {
			this.consoleV = consoleV;
		}
		
		public boolean isInputValid(JTextField number1, JTextField number2) {
			boolean y = true;
			frame.add(consoleLog);
			consoleLog.setVisible(true);
			
			int MissingInputs = 0;
			int noneNumbers = 0;
			
			if(isTextFieldEmpty(number1)) {
				MissingInputs++;
			}
			if(!checkIfStringIsNumber(number1.getText()) && !isTextFieldEmpty(number1)) {
				noneNumbers++;
			}
			if(isTextFieldEmpty(number2)) {
				MissingInputs++;
			}
			if(!checkIfStringIsNumber(number2.getText()) && !isTextFieldEmpty(number2)) {
				noneNumbers++;
			}
			
			if(MissingInputs != 0) {
				if(isTextFieldEmpty(consoleLog)) {
					consoleLog.setText("Missing Inputs - " + MissingInputs);
				}else {
					consoleLog.setText(consoleLog.getText() + ", Missing Inputs - " + MissingInputs);
				}
				y = false;
			}
			if(noneNumbers != 0) {
				if(isTextFieldEmpty(consoleLog)) {
					consoleLog.setText("NAN - Not A Number - " + noneNumbers);
				}else {
					consoleLog.setText(consoleLog.getText() + ", NAN - Not A Number - " + noneNumbers);
				}
				y = false;
			}
			return y;
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
			
			consoleLog = new JTextField("");
			consoleLog.setEditable(false);
			consoleLog.setVisible(false);
			consoleLog.setBounds(framePosition[0] - (100 + consoleH + 10), framePosition[1] - (consoleV + 45), consoleH, consoleV);
			frame.add(consoleLog);
			
			frame.setLayout(null);
	 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		frame.setSize(framePosition[0], framePosition[1]);
	 		frame.setResizable(false);
	 		frame.setVisible(true);
		}
		
	}