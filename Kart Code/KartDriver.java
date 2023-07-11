import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

public class KartDriver {
    double accelConst;
    double limK = 0.01;
    private boolean isAccelerating = false;

    public KartDriver(double accelerationConstant) {
        accelConst = accelerationConstant/100;
    }


    public float accel(float input, float time){

    float output;

    isAccelerating = (input == 0.0);

    if (isAccelerating && time > limK ) {
        output = Range.clip((output + accelConst * input), -1.0, 1.0);
        runtime.reset;
    } if (!isAccelerating){
        output = 0;
    }

    return output;

    }
}