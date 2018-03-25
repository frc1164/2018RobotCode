package org.usfirst.frc.team1164.logic.motionProfiler;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PosCounter implements PIDSource {
	
	/* this class is mainly used for just finding how much
	 * farther the motion profiler has to go, if it needs
	 * to go further it returns a 1, back is -1 and stay still
	 * is 0
	 */
	
	
	
	
	private int endPoint;
	private int curPosition;
	private int itrNum;
	private int lastItrPos;
	private int lastItrNeg;
	private int gap;
	
	public PosCounter(int gap) {
		this.gap = gap;
		itrNum = 0;
		endPoint = 0;
		lastItrPos = -gap - 1;
		lastItrNeg = -gap - 1;
	}
	
	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {}

	@Override
	public PIDSourceType getPIDSourceType() {
		return null;
	}

	@Override
	public double pidGet() {
		double output;
		itrNum++;
		if (curPosition < endPoint) {
			if (itrNum - lastItrNeg >= gap) {
				curPosition++;
				lastItrPos = itrNum;
				output = 1;
			}
			else {
				output = 0;
			}
		}
		else if (curPosition == endPoint) {
			output = 0;
		}
		else {
			if (itrNum - lastItrPos >= gap) {
				curPosition--;
				lastItrNeg = itrNum;
				output = -1;
			}
			else {
				output = 0;
			}
		}
		
		return output;
	}
	
	// getGap
	// output the given gap.
	public int getGap() { return gap; }
}