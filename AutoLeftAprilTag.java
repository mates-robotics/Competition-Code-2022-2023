package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;
import java.util.ArrayList;
import android.content.Context;

@Autonomous(name="AutoLeftAprilTag")
public class AutoLeftAprilTag extends LinearOpMode
{
    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    RobotMap robot = new RobotMap();
 

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    double fx = 1078.03779;
    double fy = 1084.50988;
    double cx = 580.850545;
    double cy = 245.959325;

    // UNITS ARE METERS
    double tagsize = 0.0388;

    int ID_TAG_OF_INTEREST1 = 0; // Tag ID 0 from the 36h11 family
    int ID_TAG_OF_INTEREST2 = 1; // Tag ID 1 from the 36h11 family
    int ID_TAG_OF_INTEREST3 = 2; // Tag ID 2 from the 36h11 family

    AprilTagDetection tagOfInterest = null;

    @Override
    public void runOpMode()
    {
  //      HardwareMap hwMap = new HardwareMap();
        waitForStart();
        
        robot.init(hardwareMap);
        Methods methods = new Methods(robot);
        
        methods.claw(false);
        methods.drive(-3, 537);
        methods.extend_precise(300);
        
        // methods.strafe(21, 537);
        // methods.drive(28, 537);
        // methods.strafe(15, 537);
        // methods.extend(4);
        // methods.drive(2, 537);
        // methods.extend_precise(-400);
        // methods.claw(true);
        // methods.drive(-2, 537);
        // methods.extend(0);
        // methods.strafe(-36, 537);
        
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(1280,720, OpenCvCameraRotation.UPRIGHT);
            }
            
            @Override 
            public void onError (int errorCode){
                
            }
        });



        
         while (tagOfInterest == null && opModeIsActive())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == ID_TAG_OF_INTEREST1)
                    {
                        // methods.drive(-3, 537);
                        methods.strafe(3, 537);
                        methods.turn(-92, 300);
                        methods.strafe(-64, 750);
                        methods.extend(4);
                        methods.drive(3, 537);
                        methods.extend_precise(-300);
                        methods.claw(true);
                        methods.drive(-3, 537);
                        methods.strafe(14, 537);
                        methods.drive(-24, 537);
                        methods.extend(0);
                        tagFound = true;
                        break;
                    }
                    
                    else if(tag.id == ID_TAG_OF_INTEREST2)
                    {
                        // methods.drive(-3, 537);
                        methods.strafe(3, 537);
                        methods.turn(-92, 300);
                        methods.strafe(-64, 750);
                        methods.extend(4);
                        methods.drive(3, 537);
                        methods.extend_precise(-300);
                        methods.claw(true);
                        methods.drive(-3, 537);
                        methods.strafe(14, 537);
                        methods.extend(0);
                        tagFound = true;
                        break;
                    }
                    
                    else if(tag.id == ID_TAG_OF_INTEREST3)
                    {
                        // methods.drive(-3, 537);
                        methods.strafe(3, 537);
                        methods.turn(-92, 300);
                        methods.strafe(-64, 750);
                        methods.extend(4);
                        methods.drive(3, 537);
                        methods.extend_precise(-300);
                        methods.claw(true);
                        methods.drive(-3, 537);
                        methods.strafe(14, 537);
                        methods.drive(24, 537);
                        methods.extend(0);
                        tagFound = true;
                        break;
                    }
                    telemetry.addData("", "" + tag.id);
                }
        if (tagFound == false){
            methods.strafe(-24, 537);
            
        }      
        robot.leftFrontDrive.setPower(0);
        robot.leftBackDrive.setPower(0);
        robot.rightFrontDrive.setPower(0);
        robot.rightBackDrive.setPower(0);
        
            }
        }
        
    }
}
