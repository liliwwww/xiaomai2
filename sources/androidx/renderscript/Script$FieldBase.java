package androidx.renderscript;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Script$FieldBase {
    protected Allocation mAllocation;
    protected Element mElement;

    protected Script$FieldBase() {
    }

    public Allocation getAllocation() {
        return this.mAllocation;
    }

    public Element getElement() {
        return this.mElement;
    }

    public Type getType() {
        return this.mAllocation.getType();
    }

    protected void init(RenderScript renderScript, int i) {
        this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, 1);
    }

    public void updateAllocation() {
    }

    protected void init(RenderScript renderScript, int i, int i2) {
        this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, i2 | 1);
    }
}
