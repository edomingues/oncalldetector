package oncalldetector;

import java.io.IOException;

public class App
{
    private static final long POLL_TIME = 5000; // 5 seconds; expire on server is 10 seconds

    public static void main(String[] args ) throws IOException, InterruptedException {

        if(args.length != 1) {
            printUsage();
            return;
        }

        String userName = args[0];

        MicrophoneDeviceOnCallDetector onCallDetector = new MicrophoneDeviceOnCallDetector();
        OnCallServer onCallServer = new OnCallServer();

        while(true) {
            boolean isOnCall = onCallDetector.isOnCall();

            System.out.println("isOnCall="+isOnCall);

            onCallServer.setUserOnCall(userName, isOnCall);

            Thread.sleep(POLL_TIME);

        }

    }

    private static void printUsage() {
        System.out.println("Usage: java -jar <app.jar> <userName>");
    }


}
