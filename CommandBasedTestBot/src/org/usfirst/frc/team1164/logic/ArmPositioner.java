package org.usfirst.frc.team1164.logic;

public class ArmPositioner {
	
    //----------------------------------------------
    // DO NOT CHANGE MANUALLY

    private static float range = 122.222221f;

    private static float[][] angles = 
        //  angle         cm. height
        {{  0.000000f,    23.495001f     },
         {  244.444443f,  45.084999f     },
         {  488.888885f,  66.040001f     },
         {  733.333313f,  111.760010f    },
         {  977.777771f,  139.382507f    },
         {  1222.222168f, 155.151672f    },
         {  1466.666626f, 168.910004f    },
         {  1711.111084f, 182.985840f    },
         {  1955.555542f, 197.167511f    },
         {  2200.000000f, 207.010010f    }};
    //----------------------------------------------
    
	public static Float getAngle(float cm) {
		for (int i = 0; i < angles.length - 1; i++) {
			if (cm >= angles[i][1] && cm < angles[i + 1][1]) {
				float slope = (angles[i + 1][0] - angles[i][0])/(angles[i + 1][1] - angles[i][1]);
				return slope*cm - slope * angles[i][1] + angles[i][0];
			}
		}
		return null;
	}
}
