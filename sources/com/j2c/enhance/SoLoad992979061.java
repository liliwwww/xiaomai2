package com.j2c.enhance;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SoLoad.java */
/* loaded from: classes.dex */
public class SoLoad992979061 {
    private static Context mContext = null;
    private static boolean soLoadedInThisClassLoader = false;
    private static boolean needforceCopySo = false;
    private static Vector<ClassLoader> m_all_loaders = new Vector<>();
    private static int Max_So_Number = 10;
    private static List<String> loadedSoName = new ArrayList();
    private static AtomicBoolean isLoadLibrary = new AtomicBoolean(false);

    public static void init(Application context) {
        try {
            Log.v("soload", "enter Init Context context " + context);
            mContext = context;
            setContextPrivate(context);
        } catch (Exception e) {
            e.printStackTrace();
            Log.v("soload", "init context failed.");
        }
    }

    private static void setContextPrivate(Application context) {
        try {
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadm = activityThread.getDeclaredMethod("currentActivityThread", new Class[0]);
            Object currentActivityThreado = currentActivityThreadm.invoke(null, new Object[0]);
            Field initApplication = activityThread.getDeclaredField("mInitialApplication");
            initApplication.setAccessible(true);
            initApplication.set(currentActivityThreado, context);
            Log.v("soload", "set application successfull");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static Context getContextPrivate() {
        try {
            Class<?> activityThread = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadm = activityThread.getDeclaredMethod("currentActivityThread", new Class[0]);
            Object currentActivityThreado = currentActivityThreadm.invoke(null, new Object[0]);
            Method getApplication_m = activityThread.getDeclaredMethod("getApplication", new Class[0]);
            return (Context) getApplication_m.invoke(currentActivityThreado, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void copyFileUsingFileStreams(File source, File dest) {
        String info = String.format("copy from %s to %s", source.getAbsolutePath(), dest.getAbsolutePath());
        Log.v("soload", info);
        try {
            InputStream input = new FileInputStream(source);
            OutputStream output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            while (true) {
                int bytesRead = input.read(buf);
                if (bytesRead > 0) {
                    output.write(buf, 0, bytesRead);
                } else {
                    input.close();
                    output.close();
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void soLoadInFile(String oriSoName, Class<?> currentCls) {
        if (mContext == null) {
            mContext = getContextPrivate();
        }
        if (mContext == null) {
            String out = String.format("class [%s] run too early before get android Context,you'd better to skip this class if meet crash ...", currentCls.getName());
            Log.v("soload", out);
            return;
        }
        String path = new File(mContext.getFilesDir(), "ali-s").getAbsolutePath();
        if (!new File(path).exists()) {
            new File(path).mkdirs();
        }
        String soName = "lib" + oriSoName + ".so";
        File src = new File(mContext.getApplicationInfo().nativeLibraryDir, soName);
        for (int i = 0; i < Max_So_Number; i++) {
            String loadSoName = soName + "." + i + ".so";
            File dest = new File(path, loadSoName);
            if (dest.exists()) {
                try {
                    System.load(dest.getAbsolutePath());
                    soLoadedInThisClassLoader = true;
                    return;
                } catch (UnsatisfiedLinkError e) {
                    Log.v("soload", "[soLoadInFile-1] UnsatisfiedLinkError " + e);
                }
            }
            if (!dest.exists()) {
                copyFileUsingFileStreams(src, dest);
                try {
                    System.load(dest.getAbsolutePath());
                    soLoadedInThisClassLoader = true;
                    return;
                } catch (UnsatisfiedLinkError e2) {
                    Log.v("soload", "[soLoadInFile-2] UnsatisfiedLinkError " + e2);
                }
            }
        }
    }

    public static void loadJ2CSo(String soName, Class<?> currentCls) {
        if (!m_all_loaders.contains(currentCls.getClassLoader())) {
            m_all_loaders.add(currentCls.getClassLoader());
            Log.v("soload", "enter loadJ2cSo .... soLoadedInThisClassLoader is " + soLoadedInThisClassLoader);
            Log.v("soload", "enter loadJ2cSo .... current class is " + currentCls.getName());
            Log.v("soload", "enter loadJ2cSo .... current classloader is " + currentCls.getClassLoader().toString());
            if (soLoadedInThisClassLoader) {
                soLoadedInThisClassLoader = false;
            }
            needforceCopySo = true;
            loadedSoName.add(soName);
        } else if (!loadedSoName.contains(soName)) {
            if (soLoadedInThisClassLoader) {
                soLoadedInThisClassLoader = false;
            }
            needforceCopySo = true;
            loadedSoName.add(soName);
        }
        if (!soLoadedInThisClassLoader && needforceCopySo) {
            try {
                Log.v("soload", "loadLibrary so " + soName);
                if (isLoadLibrary.compareAndSet(false, true)) {
                    System.loadLibrary(soName);
                    isLoadLibrary.set(false);
                }
                soLoadedInThisClassLoader = true;
            } catch (UnsatisfiedLinkError e) {
                Log.v("soload", "loadJ2CSo UnsatisfiedLinkError " + e);
                soLoadInFile(soName, currentCls);
            }
        }
    }
}
