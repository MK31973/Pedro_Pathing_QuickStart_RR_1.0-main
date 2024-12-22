package org.firstinspires.ftc.teamcode.pedroPathing.localization;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.roadrunner.MecanumDrive;

@TeleOp(name = "Bakwaasbutside", group = "newnewnew")
public class anaychauhan extends LinearOpMode {
    MecanumDrive drive;


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        drive = new MecanumDrive(hardwareMap, new Pose2d(-70.35, 0, 0)); // Initialize in init()
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(-70.35, 0, 0))
                        //Step: 1
                        .splineToConstantHeading(new Vector2d(-39.75, -27.5), 0)
                        .waitSeconds(1.5)

                        //Step: 2
                        .lineToXConstantHeading(-45)
                        .waitSeconds(0.5)

                        //Step: 3
                        .strafeToLinearHeading(new Vector2d(-45,5.5),Math.toRadians(90))
                        .waitSeconds(0.5)

                        //Step: 4
                        .strafeToConstantHeading(new Vector2d(-28.75,5.5))
                        .waitSeconds(1)

                        //Step: 5
                        .strafeToLinearHeading(new Vector2d(-63.75,23.5),Math.toRadians(135))
                        .waitSeconds(1)

                        //Step: 6
                        .strafeToLinearHeading(new Vector2d(-28.75,12),Math.toRadians(90))
                        .strafeToConstantHeading(new Vector2d(-28.75,14.575))
                        .waitSeconds(1)

                        //Step: 7
                        .strafeToLinearHeading(new Vector2d(-63.75,23.5),Math.toRadians(135))
                        .waitSeconds(1)

                        //Step: 8
                        .strafeToLinearHeading(new Vector2d(-28.75,26.5-1),Math.toRadians(90))
                        .waitSeconds(1)

                        //Step: 9
                        .strafeToLinearHeading(new Vector2d(-63.75,23.5),Math.toRadians(135))
                        .waitSeconds(1)

                        //Step: ah yes odometry
                        .setTangent(2*Math.PI)
                        .splineToLinearHeading(new Pose2d(-16.75,-5.5,Math.toRadians(90)), Math.toRadians(270))
                        .build());
        //Ah yes Odometry
    }
}