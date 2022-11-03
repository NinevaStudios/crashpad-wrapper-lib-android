package com.ninevastudios.bugsplatunitylib;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.util.Log;

public class BugSplatBridge {
    static {
        System.loadLibrary("native-lib");
    }

    public static void initBugSplat(Activity activity, String database, String application, String version) {
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        Log.d("BugSplat", "init result: " +
                jniInitBugSplat(applicationInfo.dataDir, applicationInfo.nativeLibraryDir, database, application, version));
    }

    public static void crash() {
        jniCrash();
    }

    static native boolean jniInitBugSplat(String dataDir, String libDir, String database, String application, String version);
    static native void jniCrash();
}