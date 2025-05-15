package org.firstinspires.ftc.teamcode.lib.subsystems.drivebase;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
public class MotorController {
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    public void initialiseDrivebaseMotors(DcMotor FL, DcMotor BL, DcMotor FR, DcMotor BR) {
        //Initialise the motors
        frontLeftMotor = FL;
        backLeftMotor = BL;
        frontRightMotor = FR;
        backRightMotor = BR;
    }

    public void setMotorSpeeds(double forwardSpeed, double turnSpeed, double strafeSpeed){

        //Control the motors with X, Y and rotate.
        double frontLeftSpeed = forwardSpeed + turnSpeed + strafeSpeed;
        double backLeftSpeed = forwardSpeed + turnSpeed - strafeSpeed;
        double frontRightSpeed = forwardSpeed - turnSpeed - strafeSpeed;
        double backRightSpeed = forwardSpeed - turnSpeed + strafeSpeed;

        //Find max to prevent value saturation.
        double max1 = Math.max(Math.abs(frontLeftSpeed), Math.abs(backLeftSpeed));
        double max2 = Math.max(Math.abs(frontRightSpeed), Math.abs(backRightSpeed));
        double max3 = Math.max(max1, max2);

        //Make sure no motor speeds are over 1.
        frontLeftMotor.setPower(frontLeftSpeed/max3);
        backLeftMotor.setPower(backLeftSpeed/max3);
        frontRightMotor.setPower(frontRightSpeed/max3);
        backRightMotor.setPower(backRightSpeed/max3);
    }
    public void drive(Gamepad gamepad1){
        setMotorSpeeds(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
