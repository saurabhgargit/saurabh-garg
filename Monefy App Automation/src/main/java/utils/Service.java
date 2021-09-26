package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    public static Path logFilePath;
    public static AppiumDriverLocalService service;


    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    static List<String> getAttachedAndroidDevices() {
        String[] lines = executeCommand("adb devices").split("\\R");
        Pattern entryPattern = Pattern.compile("(?<entry>(?<serial>.+)\\s+device)");
        ArrayList<String> mDevices = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            if (!(lines[i].equals(""))) {
                Matcher matcher = entryPattern.matcher(lines[i]);
                if (matcher.matches())
                    mDevices.add(matcher.group("serial"));
            }
        }
        return mDevices;
    }

    static Map<String, String> getDeviceInfo(String deviceSerial) {
        Map<String, String> properties = new HashMap<>();
        properties.put("model", executeCommand(String.format("adb -s %s shell getprop ro.product.model", deviceSerial)).trim());
        properties.put("version", executeCommand(String.format("adb -s %s shell getprop ro.build.version.release", deviceSerial)).trim());
        return properties;
    }

    /**
     * Description :- This method will start appium server and  will create a log file and write all the error logs into that file
     * */
    public static AppiumDriverLocalService startAppiumServer() {
        final int[] availablePorts;
        try {
            File logFile = new File(System.getProperty("user.dir")+"//appiumLogs//"+ Instant.now().toString() + ".log");
            logFilePath = logFile.toPath();
            availablePorts = Service.getFreePorts(2);
            final String serverIP = "127.0.0.1";
            AppiumServiceBuilder builder =
                    new AppiumServiceBuilder()
                            .withArgument(GeneralServerFlag.LOG_LEVEL, "error")
                            .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER,
                                    Integer.toString(availablePorts[0]))
                            .withIPAddress(serverIP)
                            .withLogFile(logFile)
                            .withArgument(AndroidServerFlag.SUPPRESS_ADB_KILL_SERVER)
                            .usingPort(availablePorts[1]);
            service = builder.build();
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return service;
    }

    public static int[] getFreePorts(int numberOfPorts) throws IOException {
        int[] result = new int[numberOfPorts];
        List<ServerSocket> servers =  new ArrayList<>(numberOfPorts);
        ServerSocket tempServer;
        for (int i = 0; i < numberOfPorts; i++) {
            try {
                tempServer = new ServerSocket(0);
                servers.add(tempServer);
                result[i] = tempServer.getLocalPort();
            } finally {
                for (ServerSocket server : servers) {
                    try {
                        server.close();
                    } catch (IOException ignored) {
                        // Continue closing servers.
                    }
                }
            }
        }
        return result;
    }

    public static void stopAppiumServer(){
        service.stop();
    }

}
