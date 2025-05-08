package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.subsystems.drivebase.MotorController;

@TeleOp(name="SubsystemsV1", group="Linear OpMode")
public class SubsystemsV1 extends LinearOpMode {
    MotorController drivebase = new MotorController();
    Gamepad gamepad1;
    @Override
    public void runOpMode(){
        drivebase.initialiseDrivebaseMotors(
                hardwareMap.get(DcMotor.class, "frontLeftMotor"),
                hardwareMap.get(DcMotor.class, "backLeftMotor"),
                hardwareMap.get(DcMotor.class, "frontRightMotor"),
                hardwareMap.get(DcMotor.class, "backRightMotor")
        );

        waitForStart();

        while(opModeIsActive()){
            drivebase.drive(gamepad1);
        }
    }



}
