public class DriveIORomi implements DriveIO {
    
    private static final double kCountsPerRevolution = 1440.0;
    private static final double kWheelDiameterInch = 2.75591; // 70 mm
  
    // The Romi has the left and right motors set to
    // PWM channels 0 and 1 respectively
    private final Spark m_leftMotor = new Spark(0);
    private final Spark m_rightMotor = new Spark(1);
  
    // The Romi has onboard encoders that are hardcoded
    // to use DIO pins 4/5 and 6/7 for the left and right
    private final Encoder m_leftEncoder = new Encoder(4, 5);
    private final Encoder m_rightEncoder = new Encoder(6, 7);
    public DriveIORomi(){
        m_rightMotor.setInverted(true);
        m_leftMotor.setInverted(false);
    }
    @override
    public void updateInputs (DriveIOInputs inputs) {
        inputs.frontRightVelocityRPM = m_rightEncoder.getVelocity();
        inputs.frontLeftVelocityRPM = m_leftEncoder.getVelocity();

        inputs.frontRightAppliedVolts = m_rightMotor.getVolts();
        inputs.frontLeftAppliedVolts = m_leftMotor.getVolts();

        inputs.frontRightCurrentAmps = m_rightMotor.getAmps();
        inputs.frontLefttCurrentAmps = m_leftMotor.getAmps();

        inputs.frontRightdistanceRadians = m_rightEncoder.getDistance();
        inputs.frontLeftdistanceRadians = m_leftEncoder.getDistance();

    }

    public void setLeftVoltage(double volts) {
        m_leftMotor.setVoltage(volts);
    }
    
    public void setRightVoltage(double volts) {
        m_rightMotor.setVoltage(volts);
    }

}
