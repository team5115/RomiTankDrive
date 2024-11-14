public interface DriveIO {
    @AutoLog
    public static class DriveIOInputs {
        
        public double frontRightVelocityRPM = 0.0;
        public double frontRightAppliedVolts = 0.0;
        public double frontRightCurrentAmps = 0.0;
        public double frontRightdistanceRadians = 0.0;

        public double frontLeftVelocityRPM = 0.0;
        public double frontLeftAppliedVolts = 0.0;
        public double frontLeftCurrentAmps = 0.0;
        public double frontLeftdistanceRadians = 0.0;

        public double backRightVelocityRPM = 0.0;
        public double backRightAppliedVolts = 0.0;
        public double backRightCurrentAmps = 0.0;
        public double backRightdistanceRadians = 0.0;

        public double backLeftVelocityRPM = 0.0;
        public double backLeftAppliedVolts = 0.0;
        public double backLeftCurrentAmps = 0.0;
        public double backLeftdistanceRadians = 0.0;

    
    }
    public default void updateInputs(DriveIOInputs inputs) {}

    public default void setLeftVoltage(double volts) {}
    
    public default void setRightVoltage(double volts) {}

}
