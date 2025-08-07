package org.firstinspires.ftc.teamcode.lib.subsystems.opModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.lib.subsystems.robot.Robot;

@TeleOp(name="SubsystemsV2", group="Linear OpMode")
public class SubsystemsV2 extends LinearOpMode {
    Robot robot = new Robot();

    @Override
    public void runOpMode(){

        robot.initialise(hardwareMap);
        waitForStart();


        while(opModeIsActive()){
            robot.drive(gamepad1);
            robot.toggleClaw();
        }
    }
}
