package org.firstinspires.ftc.teamcode.subsystems.extendo;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;

public class BoxSlideController {

    public void setExtendoPosition(PIDFController pidf){
        // set our gains to some value
        pidf.setP(0.37);
        pidf.setI(0.05);
        pidf.setD(1.02);

        // get our gain constants
        kP = pidf.getP();
        kI = pidf.getI();
        kD = pidf.getD();

        // set all gains
        pidf.setPIDF(kP, KI, kD, 0.7);

        // get all gain coefficients
        double[] coeffs = pidf.getCoefficients();
        kP = coeffs[0];
        kI = coeffs[1];
        kD = coeffs[2];
        kF = coeffs[3];
    }
}
