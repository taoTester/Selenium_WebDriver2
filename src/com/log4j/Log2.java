//package com.log4j;
//
//import java.io.File;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//
//public class Log2 {
//
//    private static Logger logger;
//
//    private static String filePath = "src/log4j_test.properties";
//
//    private static boolean flag = false;
//
//    private static synchronized void getPropertyFile() {
//        logger = Logger.getLogger("TestProject");
//        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
//        flag = true;
//    }
//
//    private static void getFlag() {
//        if (flag == false)
//            Log2.getPropertyFile();
//    }
//
//    public static void logInfo(String message) {
//        Log2.getFlag();
//        logger.info(message);
//    }
//
//    public static void logError(String message) {
//        Log2.getFlag();
//        logger.error(message);
//    }
//
//    public static void logWarn(String message) {
//        Log2.getFlag();
//        logger.warn(message);
//    }
//
//}