package androidx.renderscript;

import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScriptIntrinsicLUT extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private final byte[] mCache;
    private boolean mDirty;
    private final Matrix4f mMatrix;
    private Allocation mTables;

    protected ScriptIntrinsicLUT(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mMatrix = new Matrix4f();
        this.mCache = new byte[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];
        this.mDirty = true;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.renderscript.Script, androidx.renderscript.ScriptIntrinsicLUT] */
    public static ScriptIntrinsicLUT create(RenderScript renderScript, Element element) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ?? scriptIntrinsicLUT = new ScriptIntrinsicLUT(renderScript.nScriptIntrinsicCreate(3, element.getID(renderScript), z), renderScript);
        scriptIntrinsicLUT.setIncSupp(z);
        ((ScriptIntrinsicLUT) scriptIntrinsicLUT).mTables = Allocation.createSized(renderScript, Element.U8(renderScript), AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END);
        for (int i = 0; i < 256; i++) {
            byte[] bArr = ((ScriptIntrinsicLUT) scriptIntrinsicLUT).mCache;
            byte b = (byte) i;
            bArr[i] = b;
            bArr[i + 256] = b;
            bArr[i + 512] = b;
            bArr[i + 768] = b;
        }
        scriptIntrinsicLUT.setVar(0, ((ScriptIntrinsicLUT) scriptIntrinsicLUT).mTables);
        return scriptIntrinsicLUT;
    }

    private void validate(int i, int i2) {
        if (i < 0 || i > 255) {
            throw new RSIllegalArgumentException("Index out of range (0-255).");
        }
        if (i2 < 0 || i2 > 255) {
            throw new RSIllegalArgumentException("Value out of range (0-255).");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forEach(Allocation allocation, Allocation allocation2) {
        if (this.mDirty) {
            this.mDirty = false;
            this.mTables.copyFromUnchecked(this.mCache);
        }
        forEach(0, allocation, allocation2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, null, null);
    }

    public void setAlpha(int i, int i2) {
        validate(i, i2);
        this.mCache[i + 768] = (byte) i2;
        this.mDirty = true;
    }

    public void setBlue(int i, int i2) {
        validate(i, i2);
        this.mCache[i + 512] = (byte) i2;
        this.mDirty = true;
    }

    public void setGreen(int i, int i2) {
        validate(i, i2);
        this.mCache[i + 256] = (byte) i2;
        this.mDirty = true;
    }

    public void setRed(int i, int i2) {
        validate(i, i2);
        this.mCache[i] = (byte) i2;
        this.mDirty = true;
    }
}
