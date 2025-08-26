package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private Servo claw;

    public void initialise(Servo clawServo){
        claw = clawServo;
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
}
