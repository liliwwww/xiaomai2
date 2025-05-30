package androidx.compose.p004ui.node;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface DiffCallback {
    boolean areItemsTheSame(int i, int i2);

    void insert(int i, int i2);

    void remove(int i);

    void same(int i, int i2);
}
