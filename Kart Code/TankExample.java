//THIS IS NOT REAL TELEOP CODE. IT IS JUST DEMONSTRATION OF THE KARTDRIVER ACCELERATION FUNCTION

public class TankExample{
    accelConst = 2;
    KartDriver driver = new KartDriver(accelConst);
    ElapsedTime time = new ElapsedTime();

    public void loop() {

        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        yInput = gamepad1.right_trigger - gamepad1.left_trigger;
        rotInput = gamepad1.right_stick_x;

        leftMotor.setPower(Range.clip(driver.accel(yInput, time) + rotInput), -1.0, 1.0);
        rightMotor.setPower(Range.clip(driver.accel(yInput, time) - rotInput), -1.0, 1.0);

    }
}
