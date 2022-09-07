package com.example.ffmpegkitslim;

import com.arthenica.ffmpegkit.FFmpegKit;
import com.arthenica.ffmpegkit.FFmpegKitConfig;
import com.arthenica.ffmpegkit.FFmpegSession;
import com.arthenica.ffmpegkit.ReturnCode;
import com.arthenica.ffmpegkit.Signal;

public class FFmpegKitHelper {
    public static void Execute(String arguments) throws Exception {
        FFmpegKitConfig.ignoreSignal(Signal.SIGXCPU);
        FFmpegSession session = FFmpegKit.execute(arguments);
        if (ReturnCode.isSuccess(session.getReturnCode())) {

        } else if (ReturnCode.isCancel(session.getReturnCode())) {
            throw new Exception("Cancelled");

        } else {
            String msg = String.format("Command failed with state %s and rc %s.%s", session.getState(), session.getReturnCode(), session.getFailStackTrace());
            throw new Exception(msg);
        }
    }

    public static void Execute(String[] arguments) throws Exception {
        FFmpegKitConfig.ignoreSignal(Signal.SIGXCPU);
        FFmpegSession session = FFmpegKit.executeWithArguments(arguments);
        if (ReturnCode.isSuccess(session.getReturnCode())) {

        } else if (ReturnCode.isCancel(session.getReturnCode())) {
            throw new Exception("Cancelled");

        } else {
            String msg = String.format("Command failed with state %s and rc %s.%s", session.getState(), session.getReturnCode(), session.getFailStackTrace());
            throw new Exception(msg);
        }
    }
}