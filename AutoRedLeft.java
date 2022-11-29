package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class AutoRedLeft extends LinearOpMode{
	
	RobotMap robot = new RobotMap();
	private ElapsedTime runtime = new ElapsedTime();

	@Override
	public void runOpMode() {
		// Initialize the hardware variables
		robot.init(hardwareMap);
		Methods methods = new Methods(robot);
		// Wait for driver to hit PLAY
		waitForStart();
		//drive to high junction
		methods.drive(12, 537);
		methods.strafe(6, 537);
		//place cone on high junction
		// methods.claw(4);
		//parks robot in alliance terminal
		methods.strafe(-30, 537);
		methods.drive(-12, 537);
		
		//strafes into alliance terminal
		// methods.strafe(-24);
		runtime.reset();
		
		
		
 		robot.leftFrontDrive.setPower(0);
 		robot.leftBackDrive.setPower(0);
 		robot.rightFrontDrive.setPower(0);
 		robot.rightBackDrive.setPower(0);
	}
}
