package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.qualcomm.robotcore.hardware.Servo;

public class ClawController {
    private Servo claw;
    private boolean isClosed;

    public void grab() {
        if (isClosed) {
            claw.setPosition(0);
        } else {
            claw.setPosition(100);
        }
    }
}
