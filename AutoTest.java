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

@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode{
	
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
		/* LIFT TESTING
		robot.extender.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		robot.extender.setTargetPosition(600);
		robot.extender.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		robot.extender.setVelocity(150);
		runtime.reset();
		while(runtime.seconds()<8) {
			
		}
		robot.extender.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		robot.extender.setTargetPosition(-600);
		robot.extender.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
		robot.extender.setVelocity(150);
		runtime.reset();
		while(runtime.seconds()<8) {
			
		}
		*/
		/* SERVO TESTING
		robot.servo1.setPosition(0.3);
		robot.servo2.setPosition(0.2);
		runtime.reset();
		while(runtime.seconds() < 5) {
			telemetry.addData("Seconds:", runtime.seconds());
		}
		robot.servo1.setPosition(0);
		robot.servo2.setPosition(0.5);
		runtime.reset();
		while(runtime.seconds() < 5) {
			telemetry.addData("Seconds:", runtime.seconds());
		}
		*/
		//METHOD TESTING
		// methods.claw(true);
		// runtime.reset();
		// while(runtime.seconds() < 3) {
			
		// }
		// methods.claw(false);
		// methods.claw(false);
		// while(runtime.seconds() < 5) {
			
		// }
		methods.strafe(100, 500);
		
			
	}
}
