package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    // Time formatter (e.g. 14:25:08)
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    // Static constructor for initial logger welcome text
    static {
        System.out.println("======================================================================================");
        System.out.println("__        __ _               __                                   _____  ____\n" +
                "\\ \\      / /(_) _ __   ___  / _| _ __   __ _  _ __ ___    ___    |___ / |  _ \\\n" +
                " \\ \\ /\\ / / | || '__| / _ \\| |_ | '__| / _` || '_ ` _ \\  / _ \\     |_ \\ | | | |\n" +
                "  \\ V  V /  | || |   |  __/|  _|| |   | (_| || | | | | ||  __/    ___) || |_| |\n" +
                "   \\_/\\_/   |_||_|    \\___||_|  |_|    \\__,_||_| |_| |_| \\___|   |____/ |____/\n");
        System.out.println("======================================================================================");
    }

    //Private constructor instead of static class like in CSharp
    private Logger(){
    }

    // Helper method for getting timestamp in right format
    private static String getTimestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static void info(String message) {
        System.out.println("[" + getTimestamp() + "] [INFO] " + message);
    }

    public static void warning(String message) {
        System.out.println("[" + getTimestamp() + "] [WARNING] " + message);
    }

    public static void error(String message) {
        System.err.println("[" + getTimestamp() + "] [ERROR] " + message);
    }
}
