package androidx.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.Surface;
import androidx.renderscript.Element;
import androidx.renderscript.Type;
import java.lang.reflect.Array;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Allocation extends BaseObj {
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    public static final int USAGE_SHARED = 128;
    static BitmapFactory.Options mBitmapOptions;
    Allocation mAdaptedAllocation;
    boolean mAutoPadding;
    Bitmap mBitmap;
    boolean mConstrainedFace;
    boolean mConstrainedLOD;
    boolean mConstrainedY;
    boolean mConstrainedZ;
    int mCurrentCount;
    int mCurrentDimX;
    int mCurrentDimY;
    int mCurrentDimZ;
    boolean mIncAllocDestroyed;
    long mIncCompatAllocation;
    boolean mReadAllowed;
    Type$CubemapFace mSelectedFace;
    int mSelectedLOD;
    int mSelectedY;
    int mSelectedZ;
    int mSize;
    Type mType;
    int mUsage;
    boolean mWriteAllowed;

    /* compiled from: Taobao */
    /* renamed from: androidx.renderscript.Allocation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);

        int mID;

        MipmapControl(int i) {
            this.mID = i;
        }
    }

    static {
        BitmapFactory.Options options = new BitmapFactory.Options();
        mBitmapOptions = options;
        options.inScaled = false;
    }

    Allocation(long j, RenderScript renderScript, Type type, int i) {
        super(j, renderScript);
        this.mReadAllowed = true;
        this.mWriteAllowed = true;
        this.mAutoPadding = false;
        this.mSelectedFace = Type$CubemapFace.POSITIVE_X;
        if ((i & (-228)) != 0) {
            throw new RSIllegalArgumentException("Unknown usage specified.");
        }
        if ((i & 32) != 0) {
            this.mWriteAllowed = false;
            if ((i & (-36)) != 0) {
                throw new RSIllegalArgumentException("Invalid usage combination.");
            }
        }
        this.mType = type;
        this.mUsage = i;
        this.mIncCompatAllocation = 0L;
        this.mIncAllocDestroyed = false;
        if (type != null) {
            this.mSize = type.getCount() * this.mType.getElement().getBytesSize();
            updateCacheInfo(type);
        }
        if (RenderScript.sUseGCHooks) {
            try {
                RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
            } catch (Exception e) {
                Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + e);
                throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + e);
            }
        }
    }

    private void copy1DRangeFromUnchecked(int i, int i2, Object obj, Element$DataType element$DataType, int i3) {
        Element$DataType element$DataType2;
        boolean z;
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            element$DataType2 = element$DataType;
            z = true;
        } else {
            element$DataType2 = element$DataType;
            z = false;
        }
        data1DChecks(i, i2, i3 * element$DataType2.mSize, bytesSize, z);
        ((BaseObj) this).mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, obj, bytesSize, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    private void copy1DRangeToUnchecked(int i, int i2, Object obj, Element$DataType element$DataType, int i3) {
        Element$DataType element$DataType2;
        boolean z;
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            element$DataType2 = element$DataType;
            z = true;
        } else {
            element$DataType2 = element$DataType;
            z = false;
        }
        data1DChecks(i, i2, i3 * element$DataType2.mSize, bytesSize, z);
        ((BaseObj) this).mRS.nAllocationRead1D(getIDSafe(), i, this.mSelectedLOD, i2, obj, bytesSize, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    private void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, Object obj, Element$DataType element$DataType, int i7) {
        int i8;
        boolean z;
        ((BaseObj) this).mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        int bytesSize = this.mType.mElement.getBytesSize() * i4 * i5 * i6;
        int i9 = element$DataType.mSize * i7;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i9) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i8 = bytesSize;
            z = true;
        } else {
            if (bytesSize > i9) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i8 = i9;
            z = false;
        }
        ((BaseObj) this).mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, obj, i8, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    private void copyFromUnchecked(Object obj, Element$DataType element$DataType, int i) {
        ((BaseObj) this).mRS.validate();
        int i2 = this.mCurrentDimZ;
        if (i2 > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, i2, obj, element$DataType, i);
            return;
        }
        int i3 = this.mCurrentDimY;
        if (i3 > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, i3, obj, element$DataType, i);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, obj, element$DataType, i);
        }
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (width % 6 != 0) {
            throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
        }
        if (width / 6 != height) {
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        }
        if (!(((height + (-1)) & height) == 0)) {
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        }
        Element elementFromBitmap = elementFromBitmap(renderScript, bitmap);
        Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap);
        builder.setX(height);
        builder.setY(height);
        builder.setFaces(true);
        builder.setMipmaps(mipmapControl == MipmapControl.MIPMAP_FULL);
        Type create = builder.create();
        long nAllocationCubeCreateFromBitmap = renderScript.nAllocationCubeCreateFromBitmap(create.getID(renderScript), mipmapControl.mID, bitmap, i);
        if (nAllocationCubeCreateFromBitmap != 0) {
            return new Allocation(nAllocationCubeCreateFromBitmap, renderScript, create, i);
        }
        throw new RSRuntimeException("Load failed for bitmap " + bitmap + " element " + elementFromBitmap);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        return createCubemapFromCubeFaces(renderScript, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, MipmapControl mipmapControl, int i) {
        return null;
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        if (bitmap.getConfig() == null) {
            if ((i & 128) != 0) {
                throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            return createFromBitmap(renderScript, createBitmap, mipmapControl, i);
        }
        Type typeFromBitmap = typeFromBitmap(renderScript, bitmap, mipmapControl);
        if (mipmapControl != MipmapControl.MIPMAP_NONE || !typeFromBitmap.getElement().isCompatible(Element.RGBA_8888(renderScript)) || i != 131) {
            long nAllocationCreateFromBitmap = renderScript.nAllocationCreateFromBitmap(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
            if (nAllocationCreateFromBitmap != 0) {
                return new Allocation(nAllocationCreateFromBitmap, renderScript, typeFromBitmap, i);
            }
            throw new RSRuntimeException("Load failed.");
        }
        long nAllocationCreateBitmapBackedAllocation = renderScript.nAllocationCreateBitmapBackedAllocation(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
        if (nAllocationCreateBitmapBackedAllocation == 0) {
            throw new RSRuntimeException("Load failed.");
        }
        Allocation allocation = new Allocation(nAllocationCreateBitmapBackedAllocation, renderScript, typeFromBitmap, i);
        allocation.setBitmap(bitmap);
        return allocation;
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i, MipmapControl mipmapControl, int i2) {
        renderScript.validate();
        if ((i2 & 224) != 0) {
            throw new RSIllegalArgumentException("Unsupported usage specified.");
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        Allocation createFromBitmap = createFromBitmap(renderScript, decodeResource, mipmapControl, i2);
        decodeResource.recycle();
        return createFromBitmap;
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i) {
        renderScript.validate();
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Allocation createSized = createSized(renderScript, Element.U8(renderScript), bytes.length, i);
            createSized.copyFrom(bytes);
            return createSized;
        } catch (Exception unused) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i, int i2) {
        renderScript.validate();
        Type.Builder builder = new Type.Builder(renderScript, element);
        builder.setX(i);
        Type create = builder.create();
        long nAllocationCreateTyped = renderScript.nAllocationCreateTyped(create.getID(renderScript), MipmapControl.MIPMAP_NONE.mID, i2, 0L);
        if (nAllocationCreateTyped != 0) {
            return new Allocation(nAllocationCreateTyped, renderScript, create, i2);
        }
        throw new RSRuntimeException("Allocation creation failed.");
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        if (type.getID(renderScript) == 0) {
            throw new RSInvalidStateException("Bad Type");
        }
        if (!renderScript.usingIO() && (i & 32) != 0) {
            throw new RSRuntimeException("USAGE_IO not supported, Allocation creation failed.");
        }
        long nAllocationCreateTyped = renderScript.nAllocationCreateTyped(type.getID(renderScript), mipmapControl.mID, i, 0L);
        if (nAllocationCreateTyped != 0) {
            return new Allocation(nAllocationCreateTyped, renderScript, type, i);
        }
        throw new RSRuntimeException("Allocation creation failed.");
    }

    private void data1DChecks(int i, int i2, int i3, int i4, boolean z) {
        ((BaseObj) this).mRS.validate();
        if (i < 0) {
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        }
        if (i2 < 1) {
            throw new RSIllegalArgumentException("Count must be >= 1.");
        }
        if (i + i2 <= this.mCurrentCount) {
            if (z) {
                if (i3 < (i4 / 4) * 3) {
                    throw new RSIllegalArgumentException("Array too small for allocation type.");
                }
                return;
            } else {
                if (i3 < i4) {
                    throw new RSIllegalArgumentException("Array too small for allocation type.");
                }
                return;
            }
        }
        throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + i2 + " at offset " + i + ".");
    }

    static Element elementFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == Bitmap.Config.ALPHA_8) {
            return Element.A_8(renderScript);
        }
        if (config == Bitmap.Config.ARGB_4444) {
            return Element.RGBA_4444(renderScript);
        }
        if (config == Bitmap.Config.ARGB_8888) {
            return Element.RGBA_8888(renderScript);
        }
        if (config == Bitmap.Config.RGB_565) {
            return Element.RGB_565(renderScript);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + config);
    }

    private long getIDSafe() {
        Allocation allocation = this.mAdaptedAllocation;
        return allocation != null ? allocation.getID(((BaseObj) this).mRS) : getID(((BaseObj) this).mRS);
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    static Type typeFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl) {
        Type.Builder builder = new Type.Builder(renderScript, elementFromBitmap(renderScript, bitmap));
        builder.setX(bitmap.getWidth());
        builder.setY(bitmap.getHeight());
        builder.setMipmaps(mipmapControl == MipmapControl.MIPMAP_FULL);
        return builder.create();
    }

    private void updateCacheInfo(Type type) {
        this.mCurrentDimX = type.getX();
        this.mCurrentDimY = type.getY();
        int z = type.getZ();
        this.mCurrentDimZ = z;
        int i = this.mCurrentDimX;
        this.mCurrentCount = i;
        int i2 = this.mCurrentDimY;
        if (i2 > 1) {
            this.mCurrentCount = i * i2;
        }
        if (z > 1) {
            this.mCurrentCount *= z;
        }
    }

    private void validate2DRange(int i, int i2, int i3, int i4) {
        if (this.mAdaptedAllocation != null) {
            return;
        }
        if (i < 0 || i2 < 0) {
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
        if (i4 < 0 || i3 < 0) {
            throw new RSIllegalArgumentException("Height or width cannot be negative.");
        }
        if (i + i3 > this.mCurrentDimX || i2 + i4 > this.mCurrentDimY) {
            throw new RSIllegalArgumentException("Updated region larger than allocation.");
        }
    }

    private void validate3DRange(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mAdaptedAllocation != null) {
            return;
        }
        if (i < 0 || i2 < 0 || i3 < 0) {
            throw new RSIllegalArgumentException("Offset cannot be negative.");
        }
        if (i5 < 0 || i4 < 0 || i6 < 0) {
            throw new RSIllegalArgumentException("Height or width cannot be negative.");
        }
        if (i + i4 > this.mCurrentDimX || i2 + i5 > this.mCurrentDimY || i3 + i6 > this.mCurrentDimZ) {
            throw new RSIllegalArgumentException("Updated region larger than allocation.");
        }
    }

    private void validateBitmapFormat(Bitmap bitmap) {
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
        }
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            if (this.mType.getElement().mKind == Element.DataKind.PIXEL_A) {
                return;
            }
            throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
        }
        if (i == 2) {
            if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA && this.mType.getElement().getBytesSize() == 4) {
                return;
            }
            throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
        }
        if (i == 3) {
            if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGB && this.mType.getElement().getBytesSize() == 2) {
                return;
            }
            throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
        }
        if (i != 4) {
            return;
        }
        if (this.mType.getElement().mKind == Element.DataKind.PIXEL_RGBA && this.mType.getElement().getBytesSize() == 2) {
            return;
        }
        throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
    }

    private void validateBitmapSize(Bitmap bitmap) {
        if (this.mCurrentDimX != bitmap.getWidth() || this.mCurrentDimY != bitmap.getHeight()) {
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    private void validateIsFloat32() {
        if (this.mType.mElement.mType == Element$DataType.FLOAT_32) {
            return;
        }
        throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsFloat64() {
        if (this.mType.mElement.mType == Element$DataType.FLOAT_64) {
            return;
        }
        throw new RSIllegalArgumentException("64 bit float source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsInt16() {
        Element$DataType element$DataType = this.mType.mElement.mType;
        if (element$DataType == Element$DataType.SIGNED_16 || element$DataType == Element$DataType.UNSIGNED_16) {
            return;
        }
        throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsInt32() {
        Element$DataType element$DataType = this.mType.mElement.mType;
        if (element$DataType == Element$DataType.SIGNED_32 || element$DataType == Element$DataType.UNSIGNED_32) {
            return;
        }
        throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsInt64() {
        Element$DataType element$DataType = this.mType.mElement.mType;
        if (element$DataType == Element$DataType.SIGNED_64 || element$DataType == Element$DataType.UNSIGNED_64) {
            return;
        }
        throw new RSIllegalArgumentException("64 bit integer source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsInt8() {
        Element$DataType element$DataType = this.mType.mElement.mType;
        if (element$DataType == Element$DataType.SIGNED_8 || element$DataType == Element$DataType.UNSIGNED_8) {
            return;
        }
        throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
    }

    private void validateIsObject() {
        Element$DataType element$DataType = this.mType.mElement.mType;
        if (element$DataType == Element$DataType.RS_ELEMENT || element$DataType == Element$DataType.RS_TYPE || element$DataType == Element$DataType.RS_ALLOCATION || element$DataType == Element$DataType.RS_SAMPLER || element$DataType == Element$DataType.RS_SCRIPT) {
            return;
        }
        throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
    }

    private Element$DataType validateObjectIsPrimitiveArray(Object obj, boolean z) {
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new RSIllegalArgumentException("Object passed is not an array of primitives.");
        }
        Class<?> componentType = cls.getComponentType();
        if (!componentType.isPrimitive()) {
            throw new RSIllegalArgumentException("Object passed is not an Array of primitives.");
        }
        if (componentType == Long.TYPE) {
            if (!z) {
                return Element$DataType.SIGNED_64;
            }
            validateIsInt64();
            return this.mType.mElement.mType;
        }
        if (componentType == Integer.TYPE) {
            if (!z) {
                return Element$DataType.SIGNED_32;
            }
            validateIsInt32();
            return this.mType.mElement.mType;
        }
        if (componentType == Short.TYPE) {
            if (!z) {
                return Element$DataType.SIGNED_16;
            }
            validateIsInt16();
            return this.mType.mElement.mType;
        }
        if (componentType == Byte.TYPE) {
            if (!z) {
                return Element$DataType.SIGNED_8;
            }
            validateIsInt8();
            return this.mType.mElement.mType;
        }
        if (componentType == Float.TYPE) {
            if (z) {
                validateIsFloat32();
            }
            return Element$DataType.FLOAT_32;
        }
        if (componentType != Double.TYPE) {
            return null;
        }
        if (z) {
            validateIsFloat64();
        }
        return Element$DataType.FLOAT_64;
    }

    public void copy1DRangeFrom(int i, int i2, Object obj) {
        copy1DRangeFromUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy1DRangeTo(int i, int i2, Object obj) {
        copy1DRangeToUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Object obj) {
        copy2DRangeFromUnchecked(i, i2, i3, i4, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, Object obj, Element$DataType element$DataType, int i5) {
        int i6;
        boolean z;
        ((BaseObj) this).mRS.validate();
        validate2DRange(i, i2, i3, i4);
        int bytesSize = this.mType.mElement.getBytesSize() * i3 * i4;
        int i7 = element$DataType.mSize * i5;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i7) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i6 = bytesSize;
            z = true;
        } else {
            if (bytesSize > i7) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i6 = i7;
            z = false;
        }
        ((BaseObj) this).mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, obj, i6, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, Object obj) {
        copy2DRangeToUnchecked(i, i2, i3, i4, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    void copy2DRangeToUnchecked(int i, int i2, int i3, int i4, Object obj, Element$DataType element$DataType, int i5) {
        int i6;
        boolean z;
        ((BaseObj) this).mRS.validate();
        validate2DRange(i, i2, i3, i4);
        int bytesSize = this.mType.mElement.getBytesSize() * i3 * i4;
        int i7 = element$DataType.mSize * i5;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i7) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i6 = bytesSize;
            z = true;
        } else {
            if (bytesSize > i7) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            i6 = i7;
            z = false;
        }
        ((BaseObj) this).mRS.nAllocationRead2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, obj, i6, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copyFrom(BaseObj[] baseObjArr) {
        ((BaseObj) this).mRS.validate();
        validateIsObject();
        if (baseObjArr.length != this.mCurrentCount) {
            throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + baseObjArr.length);
        }
        if (RenderScript.sPointerSize == 8) {
            long[] jArr = new long[baseObjArr.length * 4];
            for (int i = 0; i < baseObjArr.length; i++) {
                jArr[i * 4] = baseObjArr[i].getID(((BaseObj) this).mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, (Object) jArr);
            return;
        }
        int[] iArr = new int[baseObjArr.length];
        for (int i2 = 0; i2 < baseObjArr.length; i2++) {
            iArr[i2] = (int) baseObjArr[i2].getID(((BaseObj) this).mRS);
        }
        copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
    }

    public void copyTo(Bitmap bitmap) {
        ((BaseObj) this).mRS.validate();
        validateBitmapFormat(bitmap);
        validateBitmapSize(bitmap);
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationCopyToBitmap(getID(renderScript), bitmap);
    }

    public void destroy() {
        if (this.mIncCompatAllocation != 0) {
            boolean z = false;
            synchronized (this) {
                if (!this.mIncAllocDestroyed) {
                    this.mIncAllocDestroyed = true;
                    z = true;
                }
            }
            if (z) {
                ReentrantReadWriteLock.ReadLock readLock = ((BaseObj) this).mRS.mRWLock.readLock();
                readLock.lock();
                if (((BaseObj) this).mRS.isAlive()) {
                    ((BaseObj) this).mRS.nIncObjDestroy(this.mIncCompatAllocation);
                }
                readLock.unlock();
                this.mIncCompatAllocation = 0L;
            }
        }
        if ((this.mUsage & 96) != 0) {
            setSurface(null);
        }
        super.destroy();
    }

    protected void finalize() throws Throwable {
        if (RenderScript.sUseGCHooks) {
            RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, Integer.valueOf(this.mSize));
        }
        super.finalize();
    }

    public void generateMipmaps() {
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationGenerateMipmaps(getID(renderScript));
    }

    public int getBytesSize() {
        Type type = this.mType;
        return type.mDimYuv != 0 ? (int) Math.ceil(type.getCount() * this.mType.getElement().getBytesSize() * 1.5d) : type.getCount() * this.mType.getElement().getBytesSize();
    }

    public Element getElement() {
        return this.mType.getElement();
    }

    public long getIncAllocID() {
        return this.mIncCompatAllocation;
    }

    public Type getType() {
        return this.mType;
    }

    public int getUsage() {
        return this.mUsage;
    }

    public void ioReceive() {
        if ((this.mUsage & 32) == 0) {
            throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
        }
        ((BaseObj) this).mRS.validate();
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationIoReceive(getID(renderScript));
    }

    public void ioSend() {
        if ((this.mUsage & 64) == 0) {
            throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
        }
        ((BaseObj) this).mRS.validate();
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationIoSend(getID(renderScript));
    }

    public void ioSendOutput() {
        ioSend();
    }

    public void setAutoPadding(boolean z) {
        this.mAutoPadding = z;
    }

    public void setFromFieldPacker(int i, FieldPacker fieldPacker) {
        ((BaseObj) this).mRS.validate();
        int bytesSize = this.mType.mElement.getBytesSize();
        byte[] data = fieldPacker.getData();
        int pos = fieldPacker.getPos();
        int i2 = pos / bytesSize;
        if (bytesSize * i2 == pos) {
            copy1DRangeFromUnchecked(i, i2, data);
            return;
        }
        throw new RSIllegalArgumentException("Field packer length " + pos + " not divisible by element size " + bytesSize + ".");
    }

    public void setIncAllocID(long j) {
        this.mIncCompatAllocation = j;
    }

    public void setSurface(Surface surface) {
        ((BaseObj) this).mRS.validate();
        if ((this.mUsage & 64) == 0) {
            throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationSetSurface(getID(renderScript), surface);
    }

    public void syncAll(int i) {
        if (i != 1 && i != 2) {
            throw new RSIllegalArgumentException("Source must be exactly one usage type.");
        }
        ((BaseObj) this).mRS.validate();
        ((BaseObj) this).mRS.nAllocationSyncAll(getIDSafe(), i);
    }

    public void copy1DRangeFrom(int i, int i2, int[] iArr) {
        validateIsInt32();
        copy1DRangeFromUnchecked(i, i2, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeTo(int i, int i2, int[] iArr) {
        validateIsInt32();
        copy1DRangeToUnchecked(i, i2, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, byte[] bArr) {
        validateIsInt8();
        copy2DRangeFromUnchecked(i, i2, i3, i4, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, byte[] bArr) {
        validateIsInt8();
        copy2DRangeToUnchecked(i, i2, i3, i4, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, Allocation allocation, int i7, int i8, int i9) {
        ((BaseObj) this).mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        ((BaseObj) this).mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, allocation.getID(((BaseObj) this).mRS), i7, i8, i9, allocation.mSelectedLOD);
    }

    public void copy1DRangeFrom(int i, int i2, short[] sArr) {
        validateIsInt16();
        copy1DRangeFromUnchecked(i, i2, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeTo(int i, int i2, short[] sArr) {
        validateIsInt16();
        copy1DRangeToUnchecked(i, i2, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, short[] sArr) {
        validateIsInt16();
        copy2DRangeFromUnchecked(i, i2, i3, i4, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, short[] sArr) {
        validateIsInt16();
        copy2DRangeToUnchecked(i, i2, i3, i4, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    private void copyTo(Object obj, Element$DataType element$DataType, int i) {
        ((BaseObj) this).mRS.validate();
        boolean z = this.mAutoPadding && this.mType.getElement().getVectorSize() == 3;
        if (z) {
            if (element$DataType.mSize * i < (this.mSize / 4) * 3) {
                throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
            }
        } else if (element$DataType.mSize * i < this.mSize) {
            throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
        }
        RenderScript renderScript = ((BaseObj) this).mRS;
        renderScript.nAllocationRead(getID(renderScript), obj, element$DataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, Object obj) {
        copy1DRangeFromUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public void copy1DRangeToUnchecked(int i, int i2, Object obj) {
        copy1DRangeToUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i) {
        return createFromBitmapResource(renderScript, resources, i, MipmapControl.MIPMAP_NONE, 3);
    }

    public void copy1DRangeFrom(int i, int i2, byte[] bArr) {
        validateIsInt8();
        copy1DRangeFromUnchecked(i, i2, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, int[] iArr) {
        copy1DRangeFromUnchecked(i, i2, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeTo(int i, int i2, byte[] bArr) {
        validateIsInt8();
        copy1DRangeToUnchecked(i, i2, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, int[] iArr) {
        copy1DRangeToUnchecked(i, i2, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, int[] iArr) {
        validateIsInt32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, int[] iArr) {
        validateIsInt32();
        copy2DRangeToUnchecked(i, i2, i3, i4, iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, short[] sArr) {
        copy1DRangeFromUnchecked(i, i2, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, short[] sArr) {
        copy1DRangeToUnchecked(i, i2, sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copyFromUnchecked(Object obj) {
        copyFromUnchecked(obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i) {
        return createSized(renderScript, element, i, 1);
    }

    public void copy1DRangeFrom(int i, int i2, float[] fArr) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(i, i2, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, byte[] bArr) {
        copy1DRangeFromUnchecked(i, i2, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeTo(int i, int i2, float[] fArr) {
        validateIsFloat32();
        copy1DRangeToUnchecked(i, i2, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, byte[] bArr) {
        copy1DRangeToUnchecked(i, i2, bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, float[] fArr) {
        validateIsFloat32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, float[] fArr) {
        validateIsFloat32();
        copy2DRangeToUnchecked(i, i2, i3, i4, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copyFromUnchecked(int[] iArr) {
        copyFromUnchecked(iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void setFromFieldPacker(int i, int i2, FieldPacker fieldPacker) {
        ((BaseObj) this).mRS.validate();
        if (i2 >= this.mType.mElement.mElements.length) {
            throw new RSIllegalArgumentException("Component_number " + i2 + " out of range.");
        }
        if (i >= 0) {
            byte[] data = fieldPacker.getData();
            int pos = fieldPacker.getPos();
            int bytesSize = this.mType.mElement.mElements[i2].getBytesSize() * this.mType.mElement.mArraySizes[i2];
            if (pos == bytesSize) {
                ((BaseObj) this).mRS.nAllocationElementData1D(getIDSafe(), i, this.mSelectedLOD, i2, data, pos);
                return;
            }
            throw new RSIllegalArgumentException("Field packer sizelength " + pos + " does not match component size " + bytesSize + ".");
        }
        throw new RSIllegalArgumentException("Offset must be >= 0.");
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, int i) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, i);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, float[] fArr) {
        copy1DRangeFromUnchecked(i, i2, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, float[] fArr) {
        copy1DRangeToUnchecked(i, i2, fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copyFromUnchecked(short[] sArr) {
        copyFromUnchecked(sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public void copy1DRangeFrom(int i, int i2, Allocation allocation, int i3) {
        ((BaseObj) this).mRS.nAllocationData2D(getIDSafe(), i, 0, this.mSelectedLOD, this.mSelectedFace.mID, i2, 1, allocation.getID(((BaseObj) this).mRS), i3, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Allocation allocation, int i5, int i6) {
        ((BaseObj) this).mRS.validate();
        validate2DRange(i, i2, i3, i4);
        ((BaseObj) this).mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, allocation.getID(((BaseObj) this).mRS), i5, i6, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copyFromUnchecked(byte[] bArr) {
        copyFromUnchecked(bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copyFromUnchecked(float[] fArr) {
        copyFromUnchecked(fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copyTo(Object obj) {
        copyTo(obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy2DRangeFrom(int i, int i2, Bitmap bitmap) {
        ((BaseObj) this).mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copy2DRangeFrom(i, i2, createBitmap);
        } else {
            validateBitmapFormat(bitmap);
            validate2DRange(i, i2, bitmap.getWidth(), bitmap.getHeight());
            ((BaseObj) this).mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, bitmap);
        }
    }

    public void copyTo(byte[] bArr) {
        validateIsInt8();
        copyTo(bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copyFrom(Object obj) {
        copyFromUnchecked(obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copyFrom(int[] iArr) {
        validateIsInt32();
        copyFromUnchecked(iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public void copyTo(short[] sArr) {
        validateIsInt16();
        copyTo(sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 131);
    }

    public void copyFrom(short[] sArr) {
        validateIsInt16();
        copyFromUnchecked(sArr, Element$DataType.SIGNED_16, sArr.length);
    }

    public void copyTo(int[] iArr) {
        validateIsInt32();
        copyTo(iArr, Element$DataType.SIGNED_32, iArr.length);
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createCubemapFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public void copyFrom(byte[] bArr) {
        validateIsInt8();
        copyFromUnchecked(bArr, Element$DataType.SIGNED_8, bArr.length);
    }

    public void copyTo(float[] fArr) {
        validateIsFloat32();
        copyTo(fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copyFrom(float[] fArr) {
        validateIsFloat32();
        copyFromUnchecked(fArr, Element$DataType.FLOAT_32, fArr.length);
    }

    public void copyFrom(Bitmap bitmap) {
        ((BaseObj) this).mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            copyFrom(createBitmap);
        } else {
            validateBitmapSize(bitmap);
            validateBitmapFormat(bitmap);
            RenderScript renderScript = ((BaseObj) this).mRS;
            renderScript.nAllocationCopyFromBitmap(getID(renderScript), bitmap);
        }
    }

    public void copyFrom(Allocation allocation) {
        ((BaseObj) this).mRS.validate();
        if (this.mType.equals(allocation.getType())) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, allocation, 0, 0);
            return;
        }
        throw new RSIllegalArgumentException("Types of allocations must match.");
    }
}
