package org.firstinspires.ftc.teamcode.lib.subsystems.drivebase;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
public class MotorController {
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    double power;
    public void initialiseDrivebaseMotors(DcMotor FL, DcMotor BL, DcMotor FR, DcMotor BR, double Power) {
        //Initialise the motors
        frontLeftMotor = FL;
        backLeftMotor = BL;
        frontRightMotor = FR;
        backRightMotor = BR;
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        power = Power;
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
        if(max3 < 1){
            max3 = 1;
        }

        //Make sure no motor speeds are over 1.
        frontLeftMotor.setPower(frontLeftSpeed/max3/power);
        backLeftMotor.setPower(backLeftSpeed/max3/power);
        frontRightMotor.setPower(frontRightSpeed/max3/power);
        backRightMotor.setPower(backRightSpeed/max3/power);
    }
    public void drive(Gamepad gamepad1){
        setMotorSpeeds(-gamepad1.right_stick_x, -gamepad1.left_stick_x, -gamepad1.left_stick_y);
    }
}
