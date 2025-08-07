package org.firstinspires.ftc.teamcode.lib.subsystems.extendo;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ArmController {
    BoxSlideController slides = new BoxSlideController();
    ClawController claw = new ClawController();
    private boolean IsOpen;

    public void setPosition(Gamepad gamepad2) {
        slides.setSlidesPosition(gamepad2.right_trigger - gamepad2.left_trigger);
    }

    public void toggleClaw() {
        if (IsOpen) {
            claw.grab();
        } else {
            claw.release();
        }

    }
}

