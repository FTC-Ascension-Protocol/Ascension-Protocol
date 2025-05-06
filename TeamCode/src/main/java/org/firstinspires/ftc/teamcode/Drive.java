package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Drive", group="Linear OpMode")
public class Drive extends LinearOpMode {
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;

    @Override
    public void runOpMode() {

        frontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "frontRightMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "backRightMotor");

        waitForStart();

        while (opModeIsActive()) {
            double forwardSpeed = -gamepad1.left_stick_y;
            double turnSpeed = gamepad1.left_stick_x;
            double strafeSpeed = gamepad1.right_stick_x;

            double frontLeftSpeed = forwardSpeed + turnSpeed + strafeSpeed;
            double backLeftSpeed = forwardSpeed + turnSpeed - strafeSpeed;
            double frontRightSpeed = forwardSpeed - turnSpeed - strafeSpeed;
            double backRightSpeed = forwardSpeed - turnSpeed + strafeSpeed;

            double max1 = Math.max(Math.abs(frontLeftSpeed), Math.abs(backLeftSpeed));
            double max2 = Math.max(Math.abs(frontRightSpeed), Math.abs(backRightSpeed));
            double max3 = Math.max(max1, max2);

            frontLeftMotor.setPower(frontLeftSpeed / max3);
            backLeftMotor.setPower(backLeftSpeed / max3);
            frontRightMotor.setPower(frontRightSpeed / max3);
            backRightMotor.setPower(backRightSpeed / max3);
        }
    }
}