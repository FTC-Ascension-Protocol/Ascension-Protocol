package org.firstinspires.ftc.teamcode.subsystems.extendo;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;

public class BoxSlideController {

    public void setExtendoPosition(PIDFController PIDF){
        PIDF.setSetPoint(10);
        PIDF.atSetPoint();
    }
}
