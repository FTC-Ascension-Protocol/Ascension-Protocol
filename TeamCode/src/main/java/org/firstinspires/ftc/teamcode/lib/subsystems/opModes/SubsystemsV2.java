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
        //do hardware map
        robot.initialise(hardwareMap);
        waitForStart();

        while(opModeIsActive()){
            robot.drive(gamepad1);
            if(gamepad2.a){
                robot.toggleClaw();
            }
            robot.setSlidePower(-1 * gamepad2.left_trigger);
            robot.setSlidePower(gamepad2.right_trigger);
            robot.setPivotPower(gamepad2.left_stick_y);
        }
    }
}
