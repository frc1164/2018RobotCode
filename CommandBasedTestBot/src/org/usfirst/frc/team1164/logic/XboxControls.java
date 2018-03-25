package org.usfirst.frc.team1164.logic;

/**
 * This class is used to easily get the controls for
 * an xbox controller so user doesn't have to go and
 * find the control on the driver station
 */

public enum XboxControls {
	A(1), 		// button
	B(2), 		// button
	X(3), 		// button
	Y(4), 		// button
	LB(5), 		// button
	RB(6),		// button
	BACK(7),	// button
	START(8),	// button
	LS(9),		// button
	LS_X(0),	// axis
	LS_Y(1),	// axis
	RS(10),		// button
	RS_X(4),	// axis
	RS_Y(5),	// axis
	LT(2),		// axis
	RT(3);		// axis
	
	private int controlNumber;
	
	XboxControls(int controlNumber) {
		this.controlNumber = controlNumber;
	}
	
	public int toInt() {
		return this.controlNumber;
	}
	
	
}
