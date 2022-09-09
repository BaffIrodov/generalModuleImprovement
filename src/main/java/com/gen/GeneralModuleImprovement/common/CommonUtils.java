package com.gen.GeneralModuleImprovement.common;

import com.gen.GeneralModuleImprovement.services.ErrorsService;

import java.util.concurrent.TimeUnit;

//This comment
public class CommonUtils {
    static ErrorsService errorsService = new ErrorsService();

    public static void waiter(int timeoutInMS){
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutInMS);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

        public static String standardIdParsingBySlice(String strBeforeId, String processedString) {
        return (processedString.replaceAll(".*" + strBeforeId, "").replaceAll("/.*", ""));
    }

    public static String standardIdParsingByPlace(Integer idPosition, String processedString) {
        String[] splittedString = processedString.split("/");
        return splittedString[idPosition];
    }
}
