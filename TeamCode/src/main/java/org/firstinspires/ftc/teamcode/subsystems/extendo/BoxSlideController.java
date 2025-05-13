package org.firstinspires.ftc.teamcode.subsystems.extendo;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;

public class BoxSlideController {
    double kP;
    double kI;
    double kD;
    double kF;
    PIDFController pidf = new PIDFController(kP,kI,kD,kF);
    public void setGains(double kp, double ki, double kd, double kf) {
        // set our gains to some value
        pidf.setP(kp);
        pidf.setI(ki);
        pidf.setD(kd);

        // get our gain constants
        kP = pidf.getP();
        kI = pidf.getI();
        kD = pidf.getD();
        // set all gains
        pidf.setPIDF(kP, kI, kD, 0.7);

        // get all gain coefficients
        double[] coeffs = pidf.getCoefficients();
        kP = coeffs[0];
        kI = coeffs[1];
        kD = coeffs[2];
        kF = coeffs[3];
    }

    public void setSlidesPosition(PIDFController pidf){

    }
}
