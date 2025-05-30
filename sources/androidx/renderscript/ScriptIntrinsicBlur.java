package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScriptIntrinsicBlur extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues;

    protected ScriptIntrinsicBlur(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mValues = new float[9];
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.renderscript.Script, androidx.renderscript.ScriptIntrinsicBlur] */
    public static ScriptIntrinsicBlur create(RenderScript renderScript, Element element) {
        if (!element.isCompatible(Element.U8_4(renderScript)) && !element.isCompatible(Element.U8(renderScript))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ?? scriptIntrinsicBlur = new ScriptIntrinsicBlur(renderScript.nScriptIntrinsicCreate(5, element.getID(renderScript), z), renderScript);
        scriptIntrinsicBlur.setIncSupp(z);
        scriptIntrinsicBlur.setRadius(5.0f);
        return scriptIntrinsicBlur;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forEach(Allocation allocation) {
        forEach(0, null, allocation, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Script.FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRadius(float f) {
        if (f <= 0.0f || f > 25.0f) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        }
        setVar(0, f);
    }
}
