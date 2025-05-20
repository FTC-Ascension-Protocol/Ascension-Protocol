package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class BoxSlideController {
//    double kP;
//    double kI;
//    double kD;
//    double kF;
    private PIDFController pidf;
    private DcMotor slides;
    public void initialise(DcMotor s, double kp, double ki, double kd, double kf){
        slides = s;
        pidf = new PIDFController(kp, ki, kd, kf);
        slides.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void setGains(double kp, double ki, double kd, double kf) {
        // Set PIDF gains
        pidf.setPIDF(kp, ki, kd, kf);
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
