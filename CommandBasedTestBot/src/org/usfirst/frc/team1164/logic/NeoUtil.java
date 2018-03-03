package org.usfirst.frc.team1164.logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NeoUtil{
	public static double VoltsToDegrees(double volts) {
		//potentiometer returns a voltage from 0 to 5, and the range of motion is 300 degrees. 
		//This works out to 60 degrees per volt.
		return volts*60;
	}
	
	public static void record(double EncoderValue, double PotValue, String filename)
		throws IOException{
			String data = String.valueOf(EncoderValue) + "\t" + String.valueOf(PotValue) + "\n";
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.append(data);
			writer.close();
	}
}