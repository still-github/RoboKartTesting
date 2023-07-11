//THIS IS NOT REAL TELEOP CODE. IT IS JUST DEMONSTRATION OF THE KARTDRIVER ACCELERATION FUNCTION

public class TankExample{
    accelConst = 2;
    ElapsedTime accelTime = new ElapsedTime();
    ElapsedTime teleOpTime = new ElapsedTime(); //separate elapsedtime for teleop if needed
    KartDriver driver = new KartDriver(accelConst, accelTime);

    public void loop() {

        DcMotor leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        DcMotor rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        leftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        rightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        yInput = gamepad1.right_trigger - gamepad1.left_trigger;
        rotInput = gamepad1.right_stick_x;

        leftMotor.setPower(Range.clip(driver.accel(yInput) + rotInput), -0.4, 0.8);
        rightMotor.setPower(Range.clip(driver.accel(yInput) - rotInput), -0.4, 0.8);

    }
}
