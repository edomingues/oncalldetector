package oncalldetector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MicrophoneDeviceOnCallDetector implements OnCallDetector {
    private String micDevice;

    public MicrophoneDeviceOnCallDetector(String micDevice){
        this.micDevice = micDevice != null? micDevice : "/dev/snd/pcmC0D0c";
    }

    public boolean isOnCall() throws IOException {
        String[] commands = {"fuser", micDevice};

        Process process = Runtime.getRuntime().exec(commands);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(process.getInputStream()));

        boolean isMicBeingUsed = false;

        if(stdInput.readLine() != null) {
            isMicBeingUsed = true;
        }

        return isMicBeingUsed;
    }
}
