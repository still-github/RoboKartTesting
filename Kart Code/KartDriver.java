import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class KartDriver {
    double accelConst;
    private boolean isAccelerating = false;

    public KartDriver(double accelerationConstant) {
        accelConst = accelerationConstant/10000000;
    }

    public float output;

    public void accel(float input, ElapsedTime runtime){

    isAccelerating = (input == 0.0);

    if (isAccelerating) {
        output = (output + runtime.seconds() * accelConst * input);
    } else {
        runtime.reset();
        }
    }
}