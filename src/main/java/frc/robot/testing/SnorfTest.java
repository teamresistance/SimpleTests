package frc.robot.testing;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.io.hdw_io.IO;
import frc.io.joysticks.JS_IO;

public class SnorfTest {
    /**
     * A Rev Color Match object is used to register and detect known colors.
     * This can be calibrated ahead of time or during operation.
     * 
     * This object uses a simple euclidian distance to estimate the closest match
     * with given confidence range.
     */
    private static final ColorMatch m_colorMatcher = new ColorMatch();

    /**
     * Note: Any example colors should be calibrated as the user needs, these
     * are here as a basic example.
     */
    private static final Color kBlueTarget = new Color(0.143, 0.427, 0.429);
    private static final Color kGreenTarget = new Color(0.197, 0.561, 0.240);
    private static final Color kRedTarget = new Color(0.50, 0.372, 0.164);
    private static final Color kYellowTarget = new Color(0.361, 0.524, 0.113);


    public static void init(){
        // IO.snorfFeed_Mtr.setInverted(false);
        // IO.snorfElv_Mtrs.setInverted(false);

        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);


    }

    public static void update(){

        // IO.snorfFeed_Mtr.set(-JS_IO.axLeftY.get());
        // IO.snorfElv_Mtrs.set(-JS_IO.axRightY.get());

        // IO.snorflerExt_SV.set(JS_IO.btnSnorfle.isDown());

                /**
         * The method GetColor() returns a normalized color value from the sensor and
         * can be
         * useful if outputting the color to an RGB LED or similar. To
         * read the raw color, use GetRawColor().
         * 
         * The color sensor works best when within a few inches from an object in
         * well lit conditions (the built in LED is a big help here!). The farther
         * an object is the more light from the surroundings will bleed into the
         * measurements and make it difficult to accurately determine its color.
         */
        Color detectedColor = IO.ballColorSensor.getColor();

        /**
         * Run the color match algorithm on our detected color
         */
        String colorString;
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

        if (match.color == kBlueTarget) {
            colorString = "Blue";
        } else if (match.color == kRedTarget) {
            colorString = "Red";
        } else if (match.color == kGreenTarget) {
            colorString = "Green";
        } else if (match.color == kYellowTarget) {
            colorString = "Yellow";
        } else {
            colorString = "Unknown";
        }

        /**
         * Open Smart Dashboard or Shuffleboard to see the color detected by the
         * sensor.
         */
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);


    }
    
}
