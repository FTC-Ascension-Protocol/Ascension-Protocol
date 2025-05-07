package org.firstinspires.ftc.teamcode.Subsystems.drivebase;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
public class motorController {
    DcMotor FrontLeftMotor;
    DcMotor FrontRightMotor;
    DcMotor BackLeftMotor;
    DcMotor BackRightMotor;
    static void setMotorSpeeds(double FL, double BL, double FR, double BR){
        FrontLeftMotor.setSpeed(FL);
        BackLeftMotor.setSpeed(BL);
        FrontRightMotor.setSpeed(FR);
        BackRightMotor.setSpeed(BR);
    }
}
