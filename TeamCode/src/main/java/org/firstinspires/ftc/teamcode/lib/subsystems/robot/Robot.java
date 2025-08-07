package org.firstinspires.ftc.teamcode.lib.subsystems.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.lib.subsystems.drivebase.MotorController;
import org.firstinspires.ftc.teamcode.lib.subsystems.extendo.BoxSlideController;
import org.firstinspires.ftc.teamcode.lib.subsystems.extendo.ClawController;

public class Robot {
    MotorController drivebase = new MotorController();
    BoxSlideController slides = new BoxSlideController();
    ClawController claw = new ClawController();

    public void initialise(HardwareMap hardwareMap) {
        drivebase.initialiseDrivebaseMotors(
                hardwareMap.get(DcMotor.class, "frontLeftMotor"),
                hardwareMap.get(DcMotor.class, "backLeftMotor"),
                hardwareMap.get(DcMotor.class, "frontRightMotor"),
                hardwareMap.get(DcMotor.class, "backRightMotor"),
                2
        );
        slides.initialise(
                hardwareMap.get(DcMotor.class, "boxSlide"),
                hardwareMap.get(DcMotor.class, "boxSlidePivot"),
                0.7, 0.7, 0.7, 0.7);
        //slides.setGains(0.7, 0.7, 0.7, 0.7);

    }
    public void drive(Gamepad gamepad) {
        drivebase.drive(gamepad);
    }

    public void setDrivebaseSpeeds(double frontLeftSpeed, double backLeftSpeed, double frontRightSpeed, double backRightSpeed){
        drivebase.setMotorSpeeds(frontLeftSpeed, backLeftSpeed, frontRightSpeed, backRightSpeed);
    }

    public void driveToPosition() {
        //heavy lifting
    }

    public void setSlidesPosition(double setpoint) {
        slides.setSlidesPosition(setpoint);
    }
    public void setSlidesPivot(double setpoint) {
        slides.setSlidesPivot(setpoint);
    }
    public void toggleClaw(){toggleClaw();};



    public void setSlidePower(double power){
        slides.slideExtend(power);
    }
}