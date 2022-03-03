package frc.robot.testing;

import java.security.PublicKey;

import com.playingwithfusion.CANVenom.BrakeCoastMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.io.hdw_io.IO;
import frc.io.joysticks.JS_IO;

public class DriveTest {

    public static void init(){
        // -------- Configure Lead drive motors ---------
        // drvLead_L.configFactoryDefault();    //No equivalent
        IO.drvLead_L.setInverted(true); // Inverts motor direction and encoder if attached
        IO.drvLead_L.setBrakeCoastMode(BrakeCoastMode.Brake);
        // drvLead_L.setSensorPhase(false); // Adjust this to correct phasing with motor

        // drvLead_R.configFactoryDefault();
        IO.drvLead_R.setInverted(true); // Inverts motor direction and encoder if attached
        IO.drvLead_R.setBrakeCoastMode(BrakeCoastMode.Brake);
        // drvLead_R.setSensorPhase(false); // Adjust this to correct phasing with motor

        // ----- Tells left and right second drive motors to follow the Lead -----
        // drvFollower_L.configFactoryDefault();
        IO.drvFollower_L.setInverted(true);
        IO.drvFollower_L.setBrakeCoastMode(BrakeCoastMode.Brake);
        IO.drvFollower_L.follow(IO.drvLead_L);
        // drvFollower_R.configFactoryDefault();
        IO.drvFollower_R.setInverted(false);
        IO.drvFollower_R.setBrakeCoastMode(BrakeCoastMode.Brake);
        IO.drvFollower_R.follow(IO.drvLead_R);

        // drvLead_L.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
        // drvLead_R.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);

    }

    public static void update(){
        // IO.drvLead_L.set(-JS_IO.axLeftY.get());
        // IO.drvLead_R.set(-JS_IO.axRightY.get());
        // IO.drvFollower_L.set(-JS_IO.axLeftY.get());
        // IO.drvFollower_R.set(-JS_IO.axRightY.get());
        IO.diffDrv_M.tankDrive(-JS_IO.axLeftY.get(), -JS_IO.axRightY.get());
        // IO.diffDrv_M.arcadeDrive(-JS_IO.axRightY.get(), JS_IO.axRightX.get());
        sdbUpdate();
    }

    public static void sdbUpdate(){
        SmartDashboard.putNumber("DriveTest/JS Y Left", JS_IO.axLeftY.get());
        SmartDashboard.putNumber("DriveTest/JS Y Right", JS_IO.axRightY.get());
        SmartDashboard.putNumber("DriveTest/Lead Left Cmd", IO.drvLead_L.get());
        SmartDashboard.putNumber("DriveTest/Lead Right Cmd", IO.drvLead_R.get());
        SmartDashboard.putNumber("DriveTest/Foll Left Cmd", IO.drvFollower_L.get());
        SmartDashboard.putNumber("DriveTest/Foll Right Cmd", IO.drvFollower_R.get());
    }
    
}
