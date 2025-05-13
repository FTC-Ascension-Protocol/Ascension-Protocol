package org.firstinspires.ftc.teamcode.subsystems.extendo;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BoxSlideController {
    double kP;
    double kI;
    double kD;
    double kF;
    PIDFController pidf = new PIDFController(kP,kI,kD,kF);
    DcMotor slides;
    public void initialise(DcMotor s){
        slides = s;
    }
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

    public void setSlidesPosition(double setpoint){
        //Set PID Setpoint
        pidf.setSetPoint(setpoint);
        while(!pidf.atSetPoint()) {
            double output = pidf.calculate(
                    slides.getCurrentPosition()
            );
            slides.setPower(output);
        }
        slides.setPower(0);
    }
}
