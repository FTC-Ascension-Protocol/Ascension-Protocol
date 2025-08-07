package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private Servo claw;

    public void grab() {
        claw.setPosition(20);
    }
    public void release() {
        claw.setPosition(100);
    }
    public void setPosition(double position) {
        claw.setPosition(position);
    }
}
