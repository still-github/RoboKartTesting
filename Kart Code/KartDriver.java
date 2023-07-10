import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class KartDriver {
    double accelConst;
    private boolean isAccelerating = false;

    public KartDriver(double accelerationConstant) {
        accelConst = accelerationConstant/10000000;
    }


    public float accel(float input, ElapsedTime runtime){

    float output;

    isAccelerating = (input == 0.0);

    if (isAccelerating) {
        output = Range.clip((output + runtime.seconds() * accelConst * input), -1.0, 1.0);
    } else {
        runtime.reset();
    }

    return output;

    }
}