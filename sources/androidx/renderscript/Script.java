package androidx.renderscript;

import android.renderscript.Script;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs;
    private final SparseArray<InvokeID> mIIDs;
    private final SparseArray<KernelID> mKIDs;
    private boolean mUseIncSupp;

    /* compiled from: Taobao */
    public static final class InvokeID extends BaseObj {
        Script mScript;
        int mSlot;

        InvokeID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    /* compiled from: Taobao */
    public static final class KernelID extends BaseObj {
        Script.KernelID mN;
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(long j, RenderScript renderScript, Script script, int i, int i2) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
            this.mSig = i2;
        }
    }

    /* compiled from: Taobao */
    public static final class LaunchOptions {
        private int strategy;
        private int xstart = 0;
        private int ystart = 0;
        private int xend = 0;
        private int yend = 0;
        private int zstart = 0;
        private int zend = 0;

        public int getXEnd() {
            return this.xend;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getZEnd() {
            return this.zend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public LaunchOptions setX(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = i;
            this.xend = i2;
            return this;
        }

        public LaunchOptions setY(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = i;
            this.yend = i2;
            return this;
        }

        public LaunchOptions setZ(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = i;
            this.zend = i2;
            return this;
        }
    }

    Script(long j, RenderScript renderScript) {
        super(j, renderScript);
        this.mKIDs = new SparseArray<>();
        this.mIIDs = new SparseArray<>();
        this.mFIDs = new SparseArray<>();
        this.mUseIncSupp = false;
    }

    public void bindAllocation(Allocation allocation, int i) {
        ((BaseObj) this).mRS.validate();
        if (allocation != null) {
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptBindAllocation(getID(renderScript), allocation.getID(((BaseObj) this).mRS), i, this.mUseIncSupp);
        } else {
            RenderScript renderScript2 = ((BaseObj) this).mRS;
            renderScript2.nScriptBindAllocation(getID(renderScript2), 0L, i, this.mUseIncSupp);
        }
    }

    protected FieldID createFieldID(int i, Element element) {
        FieldID fieldID = this.mFIDs.get(i);
        if (fieldID != null) {
            return fieldID;
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        long nScriptFieldIDCreate = renderScript.nScriptFieldIDCreate(getID(renderScript), i, this.mUseIncSupp);
        if (nScriptFieldIDCreate == 0) {
            throw new RSDriverException("Failed to create FieldID");
        }
        FieldID fieldID2 = new FieldID(nScriptFieldIDCreate, ((BaseObj) this).mRS, this, i);
        this.mFIDs.put(i, fieldID2);
        return fieldID2;
    }

    protected InvokeID createInvokeID(int i) {
        InvokeID invokeID = this.mIIDs.get(i);
        if (invokeID != null) {
            return invokeID;
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        long nScriptInvokeIDCreate = renderScript.nScriptInvokeIDCreate(getID(renderScript), i);
        if (nScriptInvokeIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        InvokeID invokeID2 = new InvokeID(nScriptInvokeIDCreate, ((BaseObj) this).mRS, this, i);
        this.mIIDs.put(i, invokeID2);
        return invokeID2;
    }

    protected KernelID createKernelID(int i, int i2, Element element, Element element2) {
        KernelID kernelID = this.mKIDs.get(i);
        if (kernelID != null) {
            return kernelID;
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        long nScriptKernelIDCreate = renderScript.nScriptKernelIDCreate(getID(renderScript), i, i2, this.mUseIncSupp);
        if (nScriptKernelIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        KernelID kernelID2 = new KernelID(nScriptKernelIDCreate, ((BaseObj) this).mRS, this, i, i2);
        this.mKIDs.put(i, kernelID2);
        return kernelID2;
    }

    protected void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long id = allocation != null ? allocation.getID(((BaseObj) this).mRS) : 0L;
        long id2 = allocation2 != null ? allocation2.getID(((BaseObj) this).mRS) : 0L;
        byte[] data = fieldPacker != null ? fieldPacker.getData() : null;
        if (!this.mUseIncSupp) {
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptForEach(getID(renderScript), i, id, id2, data, this.mUseIncSupp);
        } else {
            long dummyAlloc = getDummyAlloc(allocation);
            long dummyAlloc2 = getDummyAlloc(allocation2);
            RenderScript renderScript2 = ((BaseObj) this).mRS;
            renderScript2.nScriptForEach(getID(renderScript2), i, dummyAlloc, dummyAlloc2, data, this.mUseIncSupp);
        }
    }

    long getDummyAlloc(Allocation allocation) {
        if (allocation == null) {
            return 0L;
        }
        long dummyType = allocation.getType().getDummyType(((BaseObj) this).mRS, allocation.getType().getElement().getDummyElement(((BaseObj) this).mRS));
        RenderScript renderScript = ((BaseObj) this).mRS;
        long nIncAllocationCreateTyped = renderScript.nIncAllocationCreateTyped(allocation.getID(renderScript), dummyType);
        allocation.setIncAllocID(nIncAllocationCreateTyped);
        return nIncAllocationCreateTyped;
    }

    protected void invoke(int i) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptInvoke(getID(renderScript), i, this.mUseIncSupp);
    }

    protected boolean isIncSupp() {
        return this.mUseIncSupp;
    }

    protected void setIncSupp(boolean z) {
        this.mUseIncSupp = z;
    }

    public void setTimeZone(String str) {
        ((BaseObj) this).mRS.validate();
        try {
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptSetTimeZone(getID(renderScript), str.getBytes("UTF-8"), this.mUseIncSupp);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setVar(int i, float f) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarF(getID(renderScript), i, f, this.mUseIncSupp);
    }

    protected void invoke(int i, FieldPacker fieldPacker) {
        if (fieldPacker != null) {
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptInvokeV(getID(renderScript), i, fieldPacker.getData(), this.mUseIncSupp);
        } else {
            RenderScript renderScript2 = ((BaseObj) this).mRS;
            renderScript2.nScriptInvoke(getID(renderScript2), i, this.mUseIncSupp);
        }
    }

    public void setVar(int i, double d) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarD(getID(renderScript), i, d, this.mUseIncSupp);
    }

    public void setVar(int i, int i2) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, i2, this.mUseIncSupp);
    }

    public void setVar(int i, long j) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarJ(getID(renderScript), i, j, this.mUseIncSupp);
    }

    public void setVar(int i, boolean z) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarI(getID(renderScript), i, z ? 1 : 0, this.mUseIncSupp);
    }

    public void setVar(int i, BaseObj baseObj) {
        if (this.mUseIncSupp) {
            long dummyAlloc = getDummyAlloc((Allocation) baseObj);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptSetVarObj(getID(renderScript), i, baseObj == null ? 0L : dummyAlloc, this.mUseIncSupp);
        } else {
            RenderScript renderScript2 = ((BaseObj) this).mRS;
            renderScript2.nScriptSetVarObj(getID(renderScript2), i, baseObj != null ? baseObj.getID(((BaseObj) this).mRS) : 0L, this.mUseIncSupp);
        }
    }

    protected void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        if (launchOptions == null) {
            forEach(i, allocation, allocation2, fieldPacker);
            return;
        }
        long id = allocation != null ? allocation.getID(((BaseObj) this).mRS) : 0L;
        long id2 = allocation2 != null ? allocation2.getID(((BaseObj) this).mRS) : 0L;
        byte[] data = fieldPacker != null ? fieldPacker.getData() : null;
        if (this.mUseIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            long dummyAlloc2 = getDummyAlloc(allocation2);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptForEachClipped(getID(renderScript), i, dummyAlloc, dummyAlloc2, data, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
            return;
        }
        RenderScript renderScript2 = ((BaseObj) this).mRS;
        renderScript2.nScriptForEachClipped(getID(renderScript2), i, id, id2, data, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
    }

    public void setVar(int i, FieldPacker fieldPacker) {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nScriptSetVarV(getID(renderScript), i, fieldPacker.getData(), this.mUseIncSupp);
    }

    public void setVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        if (this.mUseIncSupp) {
            long dummyElement = element.getDummyElement(((BaseObj) this).mRS);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nScriptSetVarVE(getID(renderScript), i, fieldPacker.getData(), dummyElement, iArr, this.mUseIncSupp);
        } else {
            RenderScript renderScript2 = ((BaseObj) this).mRS;
            renderScript2.nScriptSetVarVE(getID(renderScript2), i, fieldPacker.getData(), element.getID(((BaseObj) this).mRS), iArr, this.mUseIncSupp);
        }
    }
}
