package org.firstinspires.ftc.teamcode.lib.subsystems;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.lib.subsystems.drivebase.MotorController;
import org.firstinspires.ftc.teamcode.lib.subsystems.extendo.BoxSlideController;

@TeleOp(name="SubsystemsV1", group="Linear OpMode")
public class SubsystemsV1 extends LinearOpMode {
    MotorController drivebase = new MotorController();
    BoxSlideController slides = new BoxSlideController();
    Gamepad gamepad1;
    @Override
    public void runOpMode(){
        drivebase.initialiseDrivebaseMotors(
                hardwareMap.get(DcMotor.class, "frontLeftMotor"),
                hardwareMap.get(DcMotor.class, "backLeftMotor"),
                hardwareMap.get(DcMotor.class, "frontRightMotor"),
                hardwareMap.get(DcMotor.class, "backRightMotor")
        );
        slides.initialise(
                hardwareMap.get(DcMotor.class, "boxSlides"),
                0.7,0.7,0.7,0.7);
        slides.setGains(0.7,0.7,0.7,0.7);

        waitForStart();

        while(opModeIsActive()){
            drivebase.drive(gamepad1);
            slides.setSlidesPosition(gamepad1.left_trigger * 100);
        }
    }



}
