package org.firstinspires.ftc.teamcode.lib.subsystems.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.lib.subsystems.robot.Robot;


@Autonomous(name="AUTONOMOUS V1")
public class AutonomousV1 extends LinearOpMode {


    @Override
    public void runOpMode() {
        Robot robot = new Robot();
        robot.initialise(hardwareMap);

        waitForStart();

        sleep(10000);

        robot.setDrivebaseSpeeds(0.4,0.4,0.4,0.4);
    }


}
