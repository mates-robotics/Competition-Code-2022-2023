package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Autonomous(name = "AutoRedRight")

public class AutoRedRight extends LinearOpMode{
    
    RobotMap robot = new RobotMap();
    
    // Establishes the "runtime" object from the "ElapsedTime" class
    private ElapsedTime runtime = new ElapsedTime();
    
    @Override
    public void runOpMode() {
        // Initialize the hardware variables
        robot.init(hardwareMap);
        Methods methods = new Methods(robot);
        // Wait for driver to hit PLAY
        waitForStart();
        
        // johns progrmaming test DOES NOT WORK
        // methods.strafe(-21, 1000);
        // methods.drive(27, 1000);
        // methods.strafe(-12, 1000);
        // methods.extend(4);
        // methods.drive(5, 1000);
        // methods.claw(true); //first cone dropped
        // methods.drive(-5, 1000);
        // methods.extend(1);
        // methods.strafe(12, 1000);
        // methods.drive(24, 1000);
        // methods.turn(90, 1000);
        // methods.drive(48, 1000);
        // methods.extend_precise(86);
        // methods.claw(false); //second cone picked up
        // methods.drive(-2, 1000);
        // methods.turn(90, 1000);
        // methods.strafe(10, 1000);
        // methods.extend(2);
        // methods.drive(4, 1000);
        // methods.claw(true); //second cone dropped
        // methods.drive(-4, 1000);
        // methods.strafe(12, 1000);
        // methods.drive(50, 100);
        // methods.strafe(36, 1000); //parked
        
        
        // methods.extend(1);
        // methods.strafe(-21, 1000);
        // methods.drive(25, 1000);
        // methods.strafe(-14, 1000);
        // methods.extend(4);
        // methods.drive(2, 1000);
        // methods.claw(true);
        // methods.drive(-2, 1000);
        // methods.extend(1);
        // methods.strafe(12, 1000);
        // methods.drive(24, 1000);
        // //
        // methods.turn(90, 1000);
        // methods.drive(46, 1000);
        // methods.extend_precise(86);
        // methods.drive(3, 1000);
        // methods.claw(false); // grab stack
        // methods.extend(2);
        // methods.drive(-12, 1000);
        // methods.turn(90, 1000);
        // methods.drive(4, 1000);
        // methods.claw(true);
        // methods.drive(-4, 1000);
        // methods.strafe(-12, 1000);
        // methods.claw(false);
        // methods.drive(52, 1000);
        // methods.strafe(60, 1000);
        
        methods.claw(false);
        methods.extend_precise(50);
        methods.strafe(-21, 537);
        methods.drive(26, 537);
        methods.strafe(-14, 537);
        methods.extend(4);
        methods.drive(5, 537);
        methods.extend_precise(-400);
        methods.claw(true);
        methods.drive(-5, 537);
        methods.strafe(14, 537);
        methods.drive(-26, 537);
        methods.strafe(-15, 537);
        methods.extend(0);
        
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
    }
}
