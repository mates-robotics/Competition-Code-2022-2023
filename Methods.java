package org.firstinspires.ftc.teamcode;

// Imports all necessary packages
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.hardware.rev.Rev2mDistanceSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

// Initializes the class
public class Methods {
	
	// Establishes the "robot" object from the "RobotMap" class
	
	// Establishes the "runtime" object from the "ElapsedTime" class
	private ElapsedTime runtime = new ElapsedTime();
	
	private DcMotorEx leftFrontDrive;
	private DcMotorEx rightFrontDrive;
	private DcMotorEx leftBackDrive;
	private DcMotorEx rightBackDrive;
	
	public Methods (RobotMap robot) {
		leftFrontDrive = robot.leftFrontDrive;
		rightFrontDrive = robot.rightFrontDrive;
		leftBackDrive = robot.leftBackDrive;
		rightBackDrive = robot.rightBackDrive;
	}
	
// 	private static final double wheelDiameter = 10.16; //wheel diameter in cm
// 	private static final double wheelCircumference = wheelDiameter*Math.PI; //wheel circumference
 	private static final double ticksPerRevolution = 537.7; //encoder ticks per revolution
 	private static final double distancePerTick = 30.16/537.7;
 	private static final int millisecondsPerDegree = (int)(1000/90); //Need time conversion
	
	public void turn(int degrees, int speed){
		
		leftBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		leftFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		
		//tell the robot where we are driving to
		//target position is in Ticks
		double targetPosition = (degrees * 2.54) * (537.7 / 114.608);
		if (degrees > 0) {
			leftBackDrive.setTargetPosition(-(int)(targetPosition)); 
			rightBackDrive.setTargetPosition((int)(targetPosition)); 
			rightFrontDrive.setTargetPosition((int)(targetPosition));
			leftFrontDrive.setTargetPosition(-(int)(targetPosition));
		}
		else if (degrees < 0) {
			leftBackDrive.setTargetPosition((int)(targetPosition)); 
			rightBackDrive.setTargetPosition(-(int)(targetPosition)); 
			rightFrontDrive.setTargetPosition(-(int)(targetPosition));
			leftFrontDrive.setTargetPosition((int)(targetPosition));
		}
		else {
			leftBackDrive.setTargetPosition(0);
			rightBackDrive.setTargetPosition(0);
			rightFrontDrive.setTargetPosition(0);
			leftFrontDrive.setTargetPosition(0);
		}
		
		//tell the robot to drive to where we need to
		leftFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		leftBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		
		// use getCurrentPosition method to keep robot at the velocity while it isn't at the location
		while (leftFrontDrive.getCurrentPosition() != targetPosition){
		//Sets speed of wheels
			leftFrontDrive.setVelocity(speed);
			rightFrontDrive.setVelocity(speed);
			leftBackDrive.setVelocity(speed);
			rightBackDrive.setVelocity(speed);
		}
		// set velocity to 0 when it reaches location
		leftFrontDrive.setVelocity(0);
		rightFrontDrive.setVelocity(0);
		leftBackDrive.setVelocity(0);
		rightBackDrive.setVelocity(0);
		
	}
	
	//method that will be used to move the robot however much we need
	//Distance is in inches
	public void drive(int distance, int speed) {
		
		leftBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		leftFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		
		//tell the robot where we are driving to
		//target position is in Ticks
		double targetPosition = (distance * 2.54) * (537.7 / 30.16);
		leftBackDrive.setTargetPosition((int)(-targetPosition)); 
		rightBackDrive.setTargetPosition((int)(-targetPosition)); 
		rightFrontDrive.setTargetPosition((int)(-targetPosition));
		leftFrontDrive.setTargetPosition((int)(-targetPosition));
		
		//tell the robot to drive to where we need to
		leftFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		leftBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		
		// use getCurrentPosition method to keep robot at the velocity while it isn't at the location
		while (leftFrontDrive.getCurrentPosition() != targetPosition){
		//Sets speed of wheels
			leftFrontDrive.setVelocity(speed);
			rightFrontDrive.setVelocity(speed);
			leftBackDrive.setVelocity(speed);
			rightBackDrive.setVelocity(speed);
		}
		// set velocity to 0 when it reaches location
		leftFrontDrive.setVelocity(0);
		rightFrontDrive.setVelocity(0);
		leftBackDrive.setVelocity(0);
		rightBackDrive.setVelocity(0);
	}
		
		
	//Tatget position values: 0 = ground, 1 = floor, 2 = low, 3 = med, 4 = high 
	/*public void claw(int targetPosition) {
		
		robot.init(hardwareMap);
		
		runtime.reset();
		
		robot.extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
		robot.extender.setTargetPosition(0);
		
		//loop to set claw to bottom at start
		while (robot.extender.getCurrentPosition() != 0) {
			robot.extender.setVelocity(720); //temp
		}
		
		//run claw to ground terminal
		if (targetPosition == 1) {
			robot.extender.setTargetPosition(100); //temp
			while (robot.extender.getCurrentPosition() != robot.extender.getTargetPosition()) {
				robot.extender.setVelocity(720); //temp
			}
		}
		//run claw to low terminal
		else if (targetPosition == 2) {
			robot.extender.setTargetPosition(200); //temp
			while (robot.extender.getCurrentPosition() != robot.extender.getTargetPosition()) {
				robot.extender.setVelocity(720); //temp
			}
		}
		//run claw to med terminal
		else if (targetPosition == 3) {
			robot.extender.setTargetPosition(300); //temp
			while (robot.extender.getCurrentPosition() != robot.extender.getTargetPosition()) {
				robot.extender.setVelocity(720); //temp
			}
		}
		//run claw to high terminal
		else if (targetPosition == 4) {
			robot.extender.setTargetPosition(400); //temp
			while (robot.extender.getCurrentPosition() != robot.extender.getTargetPosition()) {
				robot.extender.setVelocity(720); //temp
			}
		}
		//reset velocity
		robot.extender.setVelocity(0);
		
	}*/
	
	public void strafe(int distance, int speed) { //negative is left, positive is right
		leftBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightBackDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		leftFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		rightFrontDrive.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		
		//tell the robot where we are driving to
		//target position is in Ticks
		double targetPosition = (distance * 2.54) * (537.7 / 29);
		if (distance > 0) {
			leftBackDrive.setTargetPosition((int)(targetPosition)); 
			rightBackDrive.setTargetPosition((int)(-targetPosition)); 
			rightFrontDrive.setTargetPosition((int)(targetPosition));
			leftFrontDrive.setTargetPosition((int)(-targetPosition));
		}
		else if (distance < 0) {
			leftBackDrive.setTargetPosition((int)(-targetPosition)); 
			rightBackDrive.setTargetPosition((int)(targetPosition)); 
			rightFrontDrive.setTargetPosition((int)(-targetPosition));
			leftFrontDrive.setTargetPosition((int)(targetPosition));
		}
		else {
			leftFrontDrive.setPower(0);
			leftBackDrive.setPower(0);
			rightFrontDrive.setPower(0);
			rightBackDrive.setPower(0);
		}
		
		//tell the robot to drive to where we need to
		leftFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightFrontDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		leftBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		rightBackDrive.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		
		// use getCurrentPosition method to keep robot at the velocity while it isn't at the location
		while (leftFrontDrive.getCurrentPosition() != targetPosition){
		//Sets speed of wheels
			leftFrontDrive.setVelocity(speed);
			rightFrontDrive.setVelocity(speed);
			leftBackDrive.setVelocity(speed);
			rightBackDrive.setVelocity(speed);
		}
		// set velocity to 0 when it reaches location
		leftFrontDrive.setVelocity(0);
		rightFrontDrive.setVelocity(0);
		leftBackDrive.setVelocity(0);
		rightBackDrive.setVelocity(0);
	}
}
