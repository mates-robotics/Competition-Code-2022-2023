package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
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

@Autonomous(name = "AutoBlueLeft")
public class AutoBlueLeft extends LinearOpMode{
	
	RobotMap robot = new RobotMap();
	
	//Right side of robot starts on third line from start
	// Establishes the "runtime" object from the "ElapsedTime" class
	private ElapsedTime runtime = new ElapsedTime();
	
	
	
	
	@Override
	public void runOpMode() {
		
		// Initialize the hardware variables
		robot.init(hardwareMap);
		Methods methods = new Methods(robot);
		// Wait for driver to hit PLAY
		waitForStart();
		
		
		//drive to high junction
		// methods.drive(12, 537); // works
		
		// testing
		methods.turn(-90, 537);
		
		
		//place cone on high junction
		// methods.claw(4);
		//parks robot in alliance terminal
		//methods.strafe(30);
		// methods.drive(-12, 537);
		
 		//strafes into alliance terminal (from start)
 		// methods.strafe(36);
 		runtime.reset();
		
 		robot.leftFrontDrive.setPower(0);
 		robot.leftBackDrive.setPower(0);
 		robot.rightFrontDrive.setPower(0);
 		robot.rightBackDrive.setPower(0);
 	}
	
 }
