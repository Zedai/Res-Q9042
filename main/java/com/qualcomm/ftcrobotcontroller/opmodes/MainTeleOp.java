package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class MainTeleOp extends OpMode {

    DcMotor motorRight1,
            motorRight2;
    DcMotor motorLeft1,
            motorLeft2;

    /**
     * Constructor
     */

    public MainTeleOp(){

    }

    @Override
    public void init() {

        motorRight1 = hardwareMap.dcMotor.get("r1");
        motorRight2 = hardwareMap.dcMotor.get("r2");

        motorLeft1 = hardwareMap.dcMotor.get("l1");
        motorLeft2 = hardwareMap.dcMotor.get("l2");

        motorLeft1.setDirection(DcMotor.Direction.REVERSE);
        motorLeft2.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        telemetry.addData("Right1 Encoder: ", motorRight1.getCurrentPosition());
        telemetry.addData("Right2 Encoder: ", motorRight2.getCurrentPosition());
        telemetry.addData("Left1 Encoder: ", +motorLeft1.getCurrentPosition());
        telemetry.addData("Left2 Encoder: ", motorLeft2.getCurrentPosition());

        if (!gamepad1.a) {

            //get the controller values from the controller
            float leftStick = gamepad1.left_stick_y;
            float rightStick = gamepad1.right_stick_y;

            if (gamepad1.x) { //pivot turn
                //setLeftPower(-.5);
                //setRightPower(.5);
            
            } else if (gamepad1.y) { //arc turn
               
                //setLeftPower(.5);
            } else { //normal tank drive
                if(leftStick > 0 && rightStick > 0) {
//                    setLeftPower(leftStick + .3);
//                    setRightPower(rightStick + .3);
                } else {
                    setLeftPower(leftStick);
                    setRightPower(rightStick);
                }

            }
        } else {
            setLeftPower(0);
            setRightPower(0);
        }


    }
    public void setLeftPower(float power){
        motorLeft1.setPower(scaleInput(power));
        motorLeft2.setPower(scaleInput(power));
    }

    public void setRightPower(float power){
        motorRight1.setPower(scaleInput(power));
        motorRight2.setPower(scaleInput(power));
    }

    @Override
    public void stop() {

    }

    double scaleInput(double dVal) {
        double[] scaleArray = {0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00};


        int index = (int) (dVal * 16.0);
        if (index < 0) {
            index = -index;
        } else if (index > 16) {
            index = 16;
        }
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        return dScale;
    }
}
