package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SharedPreferencesCompat$EditorCompat {
    private static SharedPreferencesCompat$EditorCompat sInstance;
    private final Helper mHelper = new Helper();

    /* compiled from: Taobao */
    private static class Helper {
        Helper() {
        }

        public void apply(@NonNull SharedPreferences.Editor editor) {
            try {
                editor.apply();
            } catch (AbstractMethodError unused) {
                editor.commit();
            }
        }
    }

    private SharedPreferencesCompat$EditorCompat() {
    }

    @Deprecated
    public static SharedPreferencesCompat$EditorCompat getInstance() {
        if (sInstance == null) {
            sInstance = new SharedPreferencesCompat$EditorCompat();
        }
        return sInstance;
    }

    @Deprecated
    public void apply(@NonNull SharedPreferences.Editor editor) {
        this.mHelper.apply(editor);
    }
}
