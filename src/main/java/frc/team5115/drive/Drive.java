public class Drive extends SubsystemBase {
    

    private final DriveIOInputsAutoLogged inputs = new DriveIOInputsAutoLogged();
    private final DriveIO io;

    public Drive(DriveIO io){
        this.io = io;  
    }
    private tankDrive(double lateral, double rotational) {
        double l_Speed = lateral + rotational;
        double r_Speed = lateral - rotational;
        if (Math.abs(l_Speed) > 1) {
            r_Speed = r_Speed/l_Speed * Math.sign(l_Speed);
            l_Speed = 1;
        } 
        if (Math.abs(r_Speed) > 1) {
            l_Speed = l_Speed/r_Speed * Math.sign(r_Speed);
            r_Speed = 1;
        }
        io.setLeftVoltage(5*l_Speed);
        io.setRightVoltage(5*r_Speed);
    }
    public Command drive(DoubleSupplier lateralSupplier, DoubleSupplier rotationalSupplier) {
        Commands.run(() -> {
            tankDrive(lateralSupplier.get(), rotationalSupplier.get());
        }, this);
    }
    

    @Override
    public void periodic() {
        
    }

}
