package frc.robot.testing;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.io.hdw_io.IO;
import frc.io.joysticks.JS_IO;

public class ClimbTest {
    public static void init(){
        IO.climbMotor.restoreFactoryDefaults();
        IO.climbMotor.setInverted(false);
        IO.climbMotor.setSmartCurrentLimit(40);
        IO.climbMotor.setIdleMode(IdleMode.kCoast);

        IO.climbMotorFollow.restoreFactoryDefaults();
        IO.climbMotorFollow.setInverted(false);
        IO.climbMotorFollow.setIdleMode(IdleMode.kCoast);
        // IO.climbMotorFollow.follow(IO.climbMotor);
    }

    public static void update(){

        IO.climbMotor.set(-JS_IO.axLeftY.get());            IO.climbMotorFollow.set(-JS_IO.axRightY.get());
        IO.climbMotorFollow.set(-JS_IO.axRightY.get());


        // if(Math.abs(JS_IO.axLeftY.get()) < 0.1){
        //     IO.climbMotor.stopMotor();
        // } else {
        //     IO.climbMotor.set(-JS_IO.axLeftY.get());
        // }

        //    if(Math.abs(JS_IO.axRightY.get()) < 0.1){
        //     IO.climbMotorFollow.stopMotor();
        //    } else {
        //     IO.climbMotorFollow.set(-JS_IO.axRightY.get());
        //    }
        //         //IO.climbMotorFollow.set(-JS_IO.axRightY.get()); //Disable follower for 1st test

        // IO.climbBrakeRel_SV.set(JS_IO.btnFire.isDown());
        // IO.lockPinAExt_SV.set(JS_IO.btnFire.isDown());
        // IO.lockPinARet_SV.set(JS_IO.btnFire.isDown());
        // IO.lockPinBExt_SV.set(JS_IO.btnFire.isDown());
        // IO.sliderExt_SV.set(JS_IO.btnFire.isDown());
        sdbUpdate();
        // System.out.println("Climb Test 1");
    }

    public static void sdbUpdate(){
        // SmartDashboard.putBoolean("Test/Climb/AExt_L_FB", IO.lockPinAExt_L_FB.get());
        // SmartDashboard.putBoolean("Test/Climb/AExt_R_FB", IO.lockPinAExt_R_FB.get());
        // SmartDashboard.putBoolean("Test/Climb/BExt_L_FB", IO.lockPinBExt_L_FB.get());
        // SmartDashboard.putBoolean("Test/Climb/BRet_R_FB", IO.lockPinBExt_B_FB.get());
        // SmartDashboard.putBoolean("Test/Climb/SExt_L_FB", IO.sliderExt_L_FB.get());
        // SmartDashboard.putBoolean("Test/Climb/SExt_R_FB", IO.sliderExt_L_FB.get());
        // SmartDashboard.putNumber("Test/Climb/Lead_cmd 6", IO.climbMotor.get());
        // SmartDashboard.putNumber("Test/Climb/Lead_volt 6", IO.climbMotor.getBusVoltage());
        SmartDashboard.putNumber("Test/Climb/Foll_cmd 7", IO.climbMotorFollow.get());
        SmartDashboard.putNumber("Test/Climb/Foll_volt 7", IO.climbMotorFollow.getBusVoltage());

    }
    
}
