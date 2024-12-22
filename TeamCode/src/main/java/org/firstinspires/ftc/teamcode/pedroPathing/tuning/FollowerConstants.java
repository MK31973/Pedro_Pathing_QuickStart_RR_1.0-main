package org.firstinspires.ftc.teamcode.pedroPathing.tuning;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.pedroPathing.util.CustomFilteredPIDFCoefficients;
import org.firstinspires.ftc.teamcode.pedroPathing.util.CustomPIDFCoefficients;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.MathFunctions;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Point;
import org.firstinspires.ftc.teamcode.pedroPathing.pathGeneration.Vector;
import org.firstinspires.ftc.teamcode.pedroPathing.util.KalmanFilterParameters;

/**
 * This is the FollowerConstants class. It holds many constants and parameters for various parts of
 * the Follower. This is here to allow for easier tuning of Pedro Pathing, as well as concentrate
 * everything tunable for the Paths themselves in one place.
 *
 * @author Anyi Lin - 10158 Scott's Bots
 * @author Aaron Yang - 10158 Scott's Bots
 * @author Harrison Womack - 10158 Scott's Bots
 * @version 1.0, 3/4/2024
 */
@Config
public class FollowerConstants {

    // This section is for setting the actual drive vector for the front left wheel, if the robot
    // is facing a heading of 0 radians with the wheel centered at (0,0)
    private static double xMovement = 70.0;
    private static double yMovement = 50.0;
    private static double[] convertToPolar = Point.cartesianToPolar(xMovement, -yMovement);
    public static Vector frontLeftVector = MathFunctions.normalizeVector(new Vector(convertToPolar[0],convertToPolar[1]));

    // Large heading error PIDF coefficients
    public static CustomPIDFCoefficients headingPIDFCoefficients = new CustomPIDFCoefficients(
            1.5,
            0,
            0,
            0);

    // Feed forward constant added on to the large heading PIDF
    public static double headingPIDFFeedForward = 0.01;
    // the limit at which the heading PIDF switches between the large and small heading PIDFs
    public static double headingPIDFSwitch = Math.PI/20;

    // Small heading error PIDF coefficients
    public static CustomPIDFCoefficients secondaryHeadingPIDFCoefficients = new CustomPIDFCoefficients(
            3.25,
            0,
            0.08,
            0);

    // Feed forward constant added on to the small heading PIDF
    public static double secondaryHeadingPIDFFeedForward = 0.01;

    // Large translational PIDF coefficients
    public static CustomPIDFCoefficients translationalPIDFCoefficients = new CustomPIDFCoefficients(
            0.15,
            0,
            0.005,
            0);

    // Feed forward constant added on to the large translational PIDF
    public static double translationalPIDFFeedForward = 0.01;

    // Large translational Integral
    public static CustomPIDFCoefficients translationalIntegral = new CustomPIDFCoefficients(
            0,
            0,
            0,
            0);

    // the limit at which the strafe PIDF switches between the large and Secondary translational PIDFs
    public static double translationalPIDFSwitch = 3;

    // Secondary translational PIDF coefficients
    public static CustomPIDFCoefficients secondaryTranslationalPIDFCoefficients = new CustomPIDFCoefficients(
            0.325,
            0,
            0.01,
            0);

    // Secondary translational Integral value
    public static CustomPIDFCoefficients secondaryTranslationalIntegral = new CustomPIDFCoefficients(
            0,
            0,
            0,
            0);


    // Feed forward constant added on to the Secondary translational PIDF
    public static double secondaryTranslationalPIDFFeedForward = 0.015;

    // Large drive PIDF coefficients
    public static CustomFilteredPIDFCoefficients drivePIDFCoefficients = new CustomFilteredPIDFCoefficients(
            0.015,
            0.0,
            0.0005,
            0.6,
            0.0);

    // Feed forward constant added on to the large drive PIDF
    public static double drivePIDFFeedForward = 0.01;

    // the limit at which the direction PIDF switches between the large and Secondary drive PIDFs
    public static double drivePIDFSwitch = 10;

    // Secondary drive PIDF coefficients
    public static CustomFilteredPIDFCoefficients secondaryDrivePIDFCoefficients = new CustomFilteredPIDFCoefficients(
            0.0225,
            0.0,
            0.0005,
            0.6,
            0.0);

    // Feed forward constant added on to the Secondary drive PIDF
    public static double secondaryDrivePIDFFeedForward = 0.01;

    // Kalman filter parameters for the drive error Kalman filter
    public static KalmanFilterParameters driveKalmanFilterParameters = new KalmanFilterParameters(
            6,
            1);

    // Mass of robot in kilograms
    public static double mass = 3; //10.65942;

    // Centripetal force to power scaling
    // todo: there are currently issues with the centripetal force correction, so just don't use it for now
    // i will fix these in another commit soon
    public static double centripetalScaling = 0.0002;

    // Acceleration of the drivetrain when power is cut in inches/second^2 (should be negative)
    // if not negative, then the robot thinks that its going to go faster under 0 power
    // this is for curves
    public static double forwardZeroPowerAcceleration = -30.0551;;//-30.4551;

    // Acceleration of the drivetrain when power is cut in inches/second^2 (should be negative)
    // if not negative, then the robot thinks that its going to go faster under 0 power
    // this is for curves
    public static double lateralZeroPowerAcceleration = -31.51952;//-91.51952;

    // A multiplier for the zero power acceleration to change the speed the robot decelerates at
    // the end of paths.
    // Increasing this will cause the robot to try to decelerate faster, at the risk of overshoots
    // or localization slippage.
    // Decreasing this will cause the deceleration at the end of the Path to be slower, making the
    // robot slower but reducing risk of end-of-path overshoots or localization slippage.
    // This can be set individually for each Path, but this is the default.
    public static double zeroPowerAccelerationMultiplier = 4;

    // When the robot is at the end of its current Path or PathChain and the velocity goes below
    // this value, then end the Path. This is in inches/second.
    // This can be custom set for each Path.
    public static double pathEndVelocityConstraint = 5.0;

    // When the robot is at the end of its current Path or PathChain and the translational error
    // goes below this value, then end the Path. This is in inches.
    // This can be custom set for each Path.
    public static double pathEndTranslationalConstraint = 0.7;

    // When the robot is at the end of its current Path or PathChain and the heading error goes
    // below this value, then end the Path. This is in radians.
    // This can be custom set for each Path.
    public static double pathEndHeadingConstraint = 0.03;

    // When the t-value of the closest point to the robot on the Path is greater than this value,
    // then the Path is considered at its end.
    // This can be custom set for each Path.
    public static double pathEndTValueConstraint = 0.990;

    // When the Path is considered at its end parametrically, then the Follower has this many
    // seconds to further correct by default.
    // This can be custom set for each Path.
    public static double pathEndTimeoutConstraint = 100.0;

    // This is how many steps the BezierCurve class uses to approximate the length of a BezierCurve.
    public static int APPROXIMATION_STEPS = 1000;

    // This is scales the translational error correction power when the Follower is holding a Point.
    public static double holdPointTranslationalScaling = 0.45;

    // This is scales the heading error correction power when the Follower is holding a Point.
    public static double holdPointHeadingScaling = 0.35;

    // This is the number of times the velocity is recorded for averaging when approximating a first
    // and second derivative for on the fly centripetal correction. The velocity is calculated using
    // half of this number of samples, and the acceleration uses all of this number of samples.
    public static int AVERAGED_VELOCITY_SAMPLE_NUMBER = 208;

    // This is the number of steps the binary search for closest point uses. More steps is more
    // accuracy, and this increases at an exponential rate. However, more steps also does take more
    // time.
    public static int BEZIER_CURVE_BINARY_STEP_LIMIT = 10;

}