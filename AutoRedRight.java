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
		
		methods.strafe(-33, 537);
		methods.drive(31, 537);
		methods.extend(4);
		methods.drive(2, 537);
		methods.extend(true, -1074);
		methods.claw(true);
		methods.extend(true, 1074);
		methods.drive(-33, 537);
		methods.extend(0);
		
		robot.leftFrontDrive.setPower(0);
		robot.leftBackDrive.setPower(0);
		robot.rightFrontDrive.setPower(0);
		robot.rightBackDrive.setPower(0);
	}
}
