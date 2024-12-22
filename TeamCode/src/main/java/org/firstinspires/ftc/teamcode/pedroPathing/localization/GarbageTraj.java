package org.firstinspires.ftc.teamcode.pedroPathing.localization;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.AccelConstraint;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.AngularVelConstraint;
import com.acmerobotics.roadrunner.MinVelConstraint;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ProfileAccelConstraint;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;

import java.util.Arrays;

@TeleOp(name = "Bakwaas", group = "newnewnew")
public class GarbageTraj extends LinearOpMode {
    MecanumDrive drive;
    private DcMotorEx angleMotor;
    private DcMotorEx slideMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        VelConstraint baseVelConstraint = new MinVelConstraint(Arrays.asList(
                new TranslationalVelConstraint(71.7170069070761),
                new AngularVelConstraint(6*Math.PI / 2)
        ));
        AccelConstraint baseAccelConstraint = new ProfileAccelConstraint(-55.0, 74.48291908330528);
        angleMotor = hardwareMap.get(DcMotorEx.class, "AM");
        slideMotor = hardwareMap.get(DcMotorEx.class, "SM");
        waitForStart();
        drive = new MecanumDrive(hardwareMap, new Pose2d(-70.35, 0, 0)); // Initialize in init()
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(-70.35, 0, 0))
                        //Step: 1
                        .strafeToConstantHeading(new Vector2d(-44.5, 4),baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)
                        .stopAndAdd(new deliver(slideMotor,angleMotor))

//                        //Step: 2
//                        .lineToX(-44.5,baseVelConstraint,baseAccelConstraint)
//                        .waitSeconds(.0)

                        //Step: 3
                        .strafeTo(new Vector2d(-44.5,-27.7),baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 4
                        .setTangent(0)
                        .splineToLinearHeading(new Pose2d(-15.8, -38.1, Math.PI), 3*Math.PI/2,baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 5

                        .lineToX(-56.6,baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 6

                        .lineToX(-20.65,baseVelConstraint,baseAccelConstraint)

                        //Step: 7

                        .strafeTo(new Vector2d(-20.65, -47.5),baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 8

                        .lineToX(-56.6,baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //                .setTangent(0)
                        //                .strafeTo(new Vector2d(-20.65, -47.07))
                        //                .waitSeconds(0)
                        //                        .setTangent(0)
                        //                        .strafeTo(new Vector2d(-20.65,-55.3) )
                        //                        .waitSeconds(0)
                        //                        .lineToX((-62))
                        //                        .waitSeconds(0)

                        //Step: 9
                        .strafeTo(new Vector2d(-62, -36.5),baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 10

                        .strafeToLinearHeading(new Vector2d(-44.5, 3),0,baseVelConstraint,baseAccelConstraint)
                        .stopAndAdd(new deliver(slideMotor,angleMotor))
                        .waitSeconds(0)

                        //Step: 11

                        .strafeToLinearHeading(new Vector2d(-62.55, -36.5),Math.PI,baseVelConstraint,baseAccelConstraint)
                        .waitSeconds(0)

                        //Step: 12
                        .strafeToLinearHeading(new Vector2d(-44.5, 4.5), 0,baseVelConstraint,baseAccelConstraint)
                        .stopAndAdd(new deliver(slideMotor,angleMotor))
                        .waitSeconds(0)

                        //                        .strafeToLinearHeading(new Vector2d(-62.550007, -36.5), Math.PI)
                        //                        .waitSeconds(0)
                        //                        .strafeToLinearHeading(new Vector2d(-39.75, 6), 0 )
                        //                        .waitSeconds(0)

                        //Step: 13
                        .strafeToLinearHeading(new Vector2d(-66, -44.575), Math.PI,baseVelConstraint,baseAccelConstraint)
                        .build());
    }
    public class deliver implements Action{
        DcMotorEx AM, SM;
        public deliver(DcMotorEx slideMotor, DcMotorEx angleMotor) {
            this.AM =angleMotor;
            this.SM =slideMotor;
        }
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            SM.setTargetPosition(-814);
            AM.setTargetPosition(-1390);
            AM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            SM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            sona(800);
            AM.setTargetPosition(-660);
            SM.setTargetPosition(-5);
            AM.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            SM.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            return false;
        }
    }
     void sona(int time) {
         try {
             Thread.sleep(time);
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     }
}