package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScriptIntrinsicConvolve5x5 extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues;

    ScriptIntrinsicConvolve5x5(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mValues = new float[25];
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.renderscript.Script, androidx.renderscript.ScriptIntrinsicConvolve5x5] */
    public static ScriptIntrinsicConvolve5x5 create(RenderScript renderScript, Element element) {
        if (!element.isCompatible(Element.U8(renderScript)) && !element.isCompatible(Element.U8_2(renderScript)) && !element.isCompatible(Element.U8_3(renderScript)) && !element.isCompatible(Element.U8_4(renderScript)) && !element.isCompatible(Element.F32(renderScript)) && !element.isCompatible(Element.F32_2(renderScript)) && !element.isCompatible(Element.F32_3(renderScript)) && !element.isCompatible(Element.F32_4(renderScript))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ?? scriptIntrinsicConvolve5x5 = new ScriptIntrinsicConvolve5x5(renderScript.nScriptIntrinsicCreate(4, element.getID(renderScript), z), renderScript);
        scriptIntrinsicConvolve5x5.setIncSupp(z);
        return scriptIntrinsicConvolve5x5;
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
    public void setCoefficients(float[] fArr) {
        FieldPacker fieldPacker = new FieldPacker(100);
        int i = 0;
        while (true) {
            float[] fArr2 = this.mValues;
            if (i >= fArr2.length) {
                setVar(0, fieldPacker);
                return;
            } else {
                fArr2[i] = fArr[i];
                fieldPacker.addF32(fArr2[i]);
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, allocation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forEach(Allocation allocation, Script.LaunchOptions launchOptions) {
        forEach(0, null, allocation, null, launchOptions);
    }
}
