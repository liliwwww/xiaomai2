package android.taobao.windvane.embed;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVEVManager$WVEmbedViewInfo {
    private ClassLoader classLoader;
    private String className;

    WVEVManager$WVEmbedViewInfo(String str) {
        this.className = str;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    WVEVManager$WVEmbedViewInfo(String str, ClassLoader classLoader) {
        this.className = str;
        this.classLoader = classLoader;
    }
}
