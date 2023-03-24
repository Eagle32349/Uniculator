package mainPart.Extras;

import javax.swing.JTextField;

public class SUVATextension {
	
	private double Distance;
	private double Time;
	private double Velocity;
	
	private double DistanceKM = 0;
	private double DistanceM = 0;

	private double TimeKM = 0;
	private double TimeM = 0;

	private double VelocityKM = 0;
	private double VelocityM = 0;
	
	private JTextField sUnits;
	private JTextField tUnits;
	private JTextField vUnits;
	
	private JTextField consoleLog;
	
	private int d;
	
	
	public SUVATextension(double Distance, double Time, double Velocity, JTextField sUnits, JTextField tUnits, JTextField vUnits, int d, JTextField consoleLog) {
		this.consoleLog = consoleLog;
		
		this.sUnits = sUnits;
		this.tUnits = tUnits;
		this.vUnits = vUnits;
		
		if(getValues("sUnits").equals("km")) {
			setValues("DistanceKM", Distance);
		}else {
			setValues("DistanceM", Distance);
		}
		
		if(getValues("tUnits").equals("h")) {
			setValues("TimeKM", Time);
		}else {
			setValues("TimeM", Time);
		}
		
		if(getValues("vUnits").equals("km/h")) {
			setValues("VelocityKM", Velocity);
		}else {
			setValues("VelocityM", Velocity);
		}
		
		this.sUnits.setName("sUnits");
		this.tUnits.setName("tUnits");
		this.vUnits.setName("vUnits");
		
		setValues("d", d);
	}
	
	

	public String getConsoleLogText() {
		return consoleLog.getText();
	}

	private void setConsoleLogText(String log) {
		if(getConsoleLogText().equals("")) {
			this.consoleLog.setText(log);
		}else {
			this.consoleLog.setText(getConsoleLogText() + ", " + log);
		}
	}
	
	
	String getValues(String type) {
		String n = null;
		if(type.equals("DistanceKM")) {
			n = DistanceKM + "";
		}else if(type.equals("DistanceM")) {
			n = DistanceM + "";
		}else if(type.equals("TimeKM")) {
			n = TimeKM + "";
		}else if(type.equals("TimeM")) {
			n = TimeM + "";
		}else if(type.equals("VelocityKM")) {
			n = VelocityKM + "";
		}else if(type.equals("VelocityM")) {
			n = VelocityM + "";
		}else if(type.equals("sUnits")) {
			n = sUnits.getText() + "";
		}else if(type.equals("tUnits")) {
			n = tUnits.getText()  + "";
		}else if(type.equals("vUnits")) {
			n = vUnits.getText()  + "";
		}else if(type.equals("d")) {
			n = d + "";
		}else {
			setConsoleLogText("Couldn't get Value");
			System.out.println(getConsoleLogText());
		}
		return n;
	}
	
	private void setValues(String type, double Value) {
		if(type.equals("DistanceKM")) {
			if((int) Value == Value) { Value = (int) Value;}
			DistanceKM = (int) Value;
		}else if(type.equals("DistanceM")) {
			if((int) Value == Value) { Value = (int) Value;}
			DistanceM = (int) Value;
		}else if(type.equals("TimeKM")) {
			if((int) Value == Value) { Value = (int) Value;}
			TimeKM = (int) Value;
		}else if(type.equals("TimeM")) {
			if((int) Value == Value) { Value = (int) Value;}
			TimeM = (int) Value;
		}else if(type.equals("VelocityKM")) {
			if((int) Value == Value) { Value = (int) Value;}
			VelocityKM = (int) Value;
		}else if(type.equals("VelocityM")) {
			if((int) Value == Value) { Value = (int) Value;}
			VelocityM = (int) Value;
		}else if(type.equals("d")) {
			if((int) Value == Value) { Value = (int) Value;}
			d = (int) Value;
		}else {
			setConsoleLogText("Couldn't set Value");
			System.out.println(getConsoleLogText());
		}
	}
	
	
	private void setUnits() {
		if(getValues("vUnits").toLowerCase().equals("km") ) {
			setValues("DistanceKM", Distance);
		}else if(getValues("vUnits").toLowerCase().equals("m") ) {
			setValues("DistanceM", Distance);
		}
		
		if(getValues("vUnits").toLowerCase().equals("h") ) {
			setValues("TimeKM", Time);
		}else if(getValues("vUnits").toLowerCase().equals("s") ) {
			setValues("TimeM", Time);
		}
		
		if(getValues("vUnits").toLowerCase().equals("km") ) {
			setValues("VelocityKM", Velocity);
		}else if(getValues("vUnits").toLowerCase().equals("m") ) {
			setValues("VelocityM", Velocity);
		}
	}
	
	
	
	
	
	
	private void setValues(String type, String Value) {
		if(type.equals("sUnits")) {
			sUnits.setText("" + Value);
		}else if(type.equals("tUnits")) {
			tUnits.setText("" + Value);
		}else if(type.equals("vUnits")) {
			vUnits.setText("" + Value);
		}
		
	}



	public double KM1(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		
		if(mode.equals("s")) {
			k = ((double)Math.round(( TimeKM * VelocityKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( DistanceKM / VelocityKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( DistanceKM / TimeKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		
		return k;
	}
	
	public double KM2(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		
		if(mode.equals("s")) {
			k = ((double)Math.round(( TimeKM * VelocityKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( DistanceKM / (VelocityM / 3.6) ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( DistanceKM / TimeM / 3600 ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		
		return k;
	}
	
	public double KM3(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		
		if(mode.equals("s")) {
			k = ((double)Math.round(( VelocityKM * 3600 * TimeM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( DistanceM * 1000 / VelocityKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( (DistanceM / TimeM) * 1000 ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		
		return k;
	}
	
	//===============================================================================================
	
	public double M1(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		if(mode.equals("s")) {
			k = ((double)Math.round(( TimeM * VelocityM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( DistanceM / VelocityM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( DistanceM / TimeM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		return k;
	}
	
	public double M2(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		if(mode.equals("s")) {
			k = ((double)Math.round(( VelocityKM * 3.6 * TimeM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( (DistanceM / VelocityKM) * 3.6 ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( (DistanceM / TimeKM) * 3600 ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		return k;
	}
	
	public double M3(double TimeKM, double VelocityKM, String mode) {
		double k = 0;
		if(mode.equals("s")) {
			k = ((double)Math.round(( (VelocityM / 3600) * TimeKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("t")) {
			k = ((double)Math.round(( DistanceM * 1000 / VelocityKM ) * Math.pow(10, d)) / Math.pow(10, d));
		}else if(mode.equals("v")) {
			k = ((double)Math.round(( (DistanceKM / TimeM) / 1000 ) * Math.pow(10, d)) / Math.pow(10, d));
		}else {
			setConsoleLogText("KM1");
		}
		return k;
	}
	
	
	
	public String extension(String type) {
		setUnits();
		String a = null;
		
		String firstKM = null;
		String secondKM = null;
		String thirdKM = null;
		
		String firstM = null;
		String secondM = null;
		String thirdM = null;
		
		String first = null;
		String second = null;
		JTextField third = null;
		JTextField third2 = null;
		
		String mode = null;
		
		if(type.toLowerCase().equals("s")) {
			firstKM = "h";
			secondKM = "km/h";
			thirdKM = "km";
			mode = "s";
			firstM = "s";
			secondM = "m/s";
			thirdM = "m";
			
			first = tUnits.getText();
			second = vUnits.getText();
			third = sUnits;
			third2 = vUnits;
		}else if(type.toLowerCase().equals("t")) {
			firstKM = "km/h";
			secondKM = "km";
			thirdKM = "h";
			mode = "t";
			firstM = "m/s";
			secondM = "m";
			thirdM = "s";
			
			first = vUnits.getText();
			second = sUnits.getText();
			third = tUnits;
			third2 = sUnits;
		}else if(type.toLowerCase().equals("v")) {
			firstKM = "km";
			secondKM = "h";
			thirdKM = "km/h";
			mode = "v";
			firstM = "s";
			secondM = "m";
			thirdM = "m/s";
			
			first = sUnits.getText();
			second = tUnits.getText();
			third = vUnits;
			third2 = tUnits;
		}
		
		if(first.equals(firstKM)) {/////////////////////////////////////////////////////////////////////////
			if(second.equals(secondKM)) {
				setValues(third.getName(), thirdKM);
				a = "" + KM1(TimeKM, VelocityKM, mode);
			}else if(second.equals(secondM)) {
				setValues(third.getName(), thirdKM + " | " + thirdM);
				a = "" + (KM2(TimeKM, VelocityM, mode)) + " | " + (M3(TimeKM, VelocityM, mode));
			}else if(second.equals("") && third.getText().equals(thirdKM)) {
				setValues(third2.getName(), secondKM);
				a = "" + M1(TimeKM, VelocityKM, mode);
			}else if(second.equals("") && third.getText().equals(thirdM)) {
				setValues(third2.getName(), secondKM + " | " + secondM);
				a = "" + (KM2(TimeKM, VelocityM, mode)) + " | " + (M3(TimeKM, VelocityM, mode));
			}else {
				setConsoleLogText("firstKM");
			}
		}else if(first.equals(firstM)) {////////////////////////////////////////////////////////////////////
			if(second.equals(secondM)) {
				setValues(third.getName(), thirdM);
				a = "" + (M1(TimeM, VelocityM, mode));
			}else if(second.equals(secondKM)) {
				setValues(third.getName(), thirdKM + " | " + thirdM);
				a = "" + (M2(TimeM, VelocityKM, mode)) + " | " + (KM3(TimeM, VelocityKM, mode));
			}
			else if(second.equals("") && third.getText().equals(thirdM)) {
				setValues(third2.getName(), secondKM);
				a = "" + (M1(TimeM, VelocityM, mode));
			}
			else if(second.equals("") && third.getText().equals(thirdKM)) {
				setValues(third2.getName(), secondKM + " | " + secondM);
				a = "" + (M2(TimeM, VelocityKM, mode)) + " | " + (KM3(TimeM, VelocityKM, mode));
			}
			else {
				setConsoleLogText("firstM");
			}
		}else if(second.equals(secondKM)) {///////////////////////////////////////////////////////////////////
			if(first.equals(firstKM)) {
				setValues(third.getName(), thirdKM);
				a = "" + KM1(TimeKM, VelocityKM, mode);
			}else if(first.equals(firstM)) {
				setValues(third.getName(), thirdKM + " | " + thirdM);
				a = "" + (KM2(TimeKM, VelocityM, mode)) + " | " + (M3(TimeKM, VelocityM, mode));
			}else if(first.equals("") && third.getText().equals(thirdKM)) {
				setValues(third2.getName(), secondKM);
				a = "" + KM1(TimeKM, VelocityKM, mode);
			}else if(first.equals("") && third.getText().equals(thirdM)) {
				setValues(third2.getName(), secondKM + " | " + secondM);
				a = "" + (KM2(TimeKM, VelocityM, mode)) + " | " + (M3(TimeKM, VelocityM, mode));
			}else {
				setConsoleLogText("secondKM");
			}
		}else if(second.equals(secondM)) {////////////////////////////////////////////////////////////////////
			if(first.equals(firstM)) {
				sUnits.setText(thirdM);
				setValues(third.getName(), thirdM);
				a = "" + (M1(TimeM, VelocityM, mode));
			}else if(first.equals(secondKM)) {
				sUnits.setText(thirdKM + " | " + thirdM);
				setValues(third.getName(), thirdKM + " | " + thirdM);
				a = "" + (M2(TimeM, VelocityKM, mode)) + " | " + (KM3(TimeM, VelocityKM, mode));
			}
			else if(first.equals("") && third.getText().equals(thirdM)) {
				vUnits.setText(secondKM);
				setValues(third2.getName(), secondKM);
				a = "" + (M1(TimeM, VelocityM, mode));
			}
			else if(first.equals("") && third.getText().equals(thirdKM)) {
				vUnits.setText(secondKM + " | " + secondM);
				setValues(third2.getName(), secondKM + " | " + secondM);
				a = "" + (M2(TimeM, VelocityKM, mode)) + " | " + (KM3(TimeM, VelocityKM, mode));
			}
			else {
				setConsoleLogText("secondM");
			}
		}else {
			setConsoleLogText("Extension");
		}
		
		
		return a;
	}
	

	

}
