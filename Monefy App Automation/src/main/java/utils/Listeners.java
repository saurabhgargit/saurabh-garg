package utils;

import org.testng.IExecutionListener;

public class Listeners implements IExecutionListener {



    @Override
    public void onExecutionStart() {
        Service.startAppiumServer();
    }

    @Override
    public void onExecutionFinish() {
        Service.stopAppiumServer();
    }


}
