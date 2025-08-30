package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private Servo claw;
    private Servo clawPivot;

    public void initialise(Servo clawServo, Servo pivotServo){
        claw = clawServo;
        clawPivot = pivotServo;
    }
    public void grab() {
        claw.setPosition(0.2);
    }
    public void release() {
        claw.setPosition(1);
    }
    public void setPosition(double position) {
        claw.setPosition(position);
    }
    public void setPivot(double position) {
        clawPivot.setPosition(position);
    }
}
