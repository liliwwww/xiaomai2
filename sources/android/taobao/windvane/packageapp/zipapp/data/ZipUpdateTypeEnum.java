package android.taobao.windvane.packageapp.zipapp.data;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public enum ZipUpdateTypeEnum {
    ZIP_UPDATE_TYPE_PASSIVE(0),
    ZIP_APP_TYPE_FORCE(256),
    ZIP_APP_TYPE_ONLINE(512);

    private long value;

    ZipUpdateTypeEnum(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long j) {
        this.value = j;
    }
}
