package okhttp3.internal;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class NamedRunnable implements Runnable {
    protected final String name;

    public NamedRunnable(String str, Object... objArr) {
        this.name = a.q(str, objArr);
    }

    protected abstract void execute();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.name);
        try {
            execute();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
