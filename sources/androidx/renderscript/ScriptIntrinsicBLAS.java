package androidx.renderscript;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScriptIntrinsicBLAS extends ScriptIntrinsic {
    public static final int CONJ_TRANSPOSE = 113;
    private static final int INTRINSIC_API_LEVEL = 23;
    public static final int LEFT = 141;
    public static final int LOWER = 122;
    public static final int NON_UNIT = 131;
    public static final int NO_TRANSPOSE = 111;
    public static final int RIGHT = 142;
    private static final int RsBlas_bnnm = 1000;
    private static final int RsBlas_caxpy = 29;
    private static final int RsBlas_ccopy = 28;
    private static final int RsBlas_cdotc_sub = 6;
    private static final int RsBlas_cdotu_sub = 5;
    private static final int RsBlas_cgbmv = 64;
    private static final int RsBlas_cgemm = 125;
    private static final int RsBlas_cgemv = 63;
    private static final int RsBlas_cgerc = 99;
    private static final int RsBlas_cgeru = 98;
    private static final int RsBlas_chbmv = 96;
    private static final int RsBlas_chemm = 137;
    private static final int RsBlas_chemv = 95;
    private static final int RsBlas_cher = 100;
    private static final int RsBlas_cher2 = 102;
    private static final int RsBlas_cher2k = 139;
    private static final int RsBlas_cherk = 138;
    private static final int RsBlas_chpmv = 97;
    private static final int RsBlas_chpr = 101;
    private static final int RsBlas_chpr2 = 103;
    private static final int RsBlas_cscal = 43;
    private static final int RsBlas_csscal = 45;
    private static final int RsBlas_cswap = 27;
    private static final int RsBlas_csymm = 126;
    private static final int RsBlas_csyr2k = 128;
    private static final int RsBlas_csyrk = 127;
    private static final int RsBlas_ctbmv = 66;
    private static final int RsBlas_ctbsv = 69;
    private static final int RsBlas_ctpmv = 67;
    private static final int RsBlas_ctpsv = 70;
    private static final int RsBlas_ctrmm = 129;
    private static final int RsBlas_ctrmv = 65;
    private static final int RsBlas_ctrsm = 130;
    private static final int RsBlas_ctrsv = 68;
    private static final int RsBlas_dasum = 12;
    private static final int RsBlas_daxpy = 26;
    private static final int RsBlas_dcopy = 25;
    private static final int RsBlas_ddot = 4;
    private static final int RsBlas_dgbmv = 56;
    private static final int RsBlas_dgemm = 119;
    private static final int RsBlas_dgemv = 55;
    private static final int RsBlas_dger = 90;
    private static final int RsBlas_dnrm2 = 11;
    private static final int RsBlas_drot = 39;
    private static final int RsBlas_drotg = 37;
    private static final int RsBlas_drotm = 40;
    private static final int RsBlas_drotmg = 38;
    private static final int RsBlas_dsbmv = 88;
    private static final int RsBlas_dscal = 42;
    private static final int RsBlas_dsdot = 2;
    private static final int RsBlas_dspmv = 89;
    private static final int RsBlas_dspr = 92;
    private static final int RsBlas_dspr2 = 94;
    private static final int RsBlas_dswap = 24;
    private static final int RsBlas_dsymm = 120;
    private static final int RsBlas_dsymv = 87;
    private static final int RsBlas_dsyr = 91;
    private static final int RsBlas_dsyr2 = 93;
    private static final int RsBlas_dsyr2k = 122;
    private static final int RsBlas_dsyrk = 121;
    private static final int RsBlas_dtbmv = 58;
    private static final int RsBlas_dtbsv = 61;
    private static final int RsBlas_dtpmv = 59;
    private static final int RsBlas_dtpsv = 62;
    private static final int RsBlas_dtrmm = 123;
    private static final int RsBlas_dtrmv = 57;
    private static final int RsBlas_dtrsm = 124;
    private static final int RsBlas_dtrsv = 60;
    private static final int RsBlas_dzasum = 16;
    private static final int RsBlas_dznrm2 = 15;
    private static final int RsBlas_icamax = 19;
    private static final int RsBlas_idamax = 18;
    private static final int RsBlas_isamax = 17;
    private static final int RsBlas_izamax = 20;
    private static final int RsBlas_sasum = 10;
    private static final int RsBlas_saxpy = 23;
    private static final int RsBlas_scasum = 14;
    private static final int RsBlas_scnrm2 = 13;
    private static final int RsBlas_scopy = 22;
    private static final int RsBlas_sdot = 3;
    private static final int RsBlas_sdsdot = 1;
    private static final int RsBlas_sgbmv = 48;
    private static final int RsBlas_sgemm = 113;
    private static final int RsBlas_sgemv = 47;
    private static final int RsBlas_sger = 82;
    private static final int RsBlas_snrm2 = 9;
    private static final int RsBlas_srot = 35;
    private static final int RsBlas_srotg = 33;
    private static final int RsBlas_srotm = 36;
    private static final int RsBlas_srotmg = 34;
    private static final int RsBlas_ssbmv = 80;
    private static final int RsBlas_sscal = 41;
    private static final int RsBlas_sspmv = 81;
    private static final int RsBlas_sspr = 84;
    private static final int RsBlas_sspr2 = 86;
    private static final int RsBlas_sswap = 21;
    private static final int RsBlas_ssymm = 114;
    private static final int RsBlas_ssymv = 79;
    private static final int RsBlas_ssyr = 83;
    private static final int RsBlas_ssyr2 = 85;
    private static final int RsBlas_ssyr2k = 116;
    private static final int RsBlas_ssyrk = 115;
    private static final int RsBlas_stbmv = 50;
    private static final int RsBlas_stbsv = 53;
    private static final int RsBlas_stpmv = 51;
    private static final int RsBlas_stpsv = 54;
    private static final int RsBlas_strmm = 117;
    private static final int RsBlas_strmv = 49;
    private static final int RsBlas_strsm = 118;
    private static final int RsBlas_strsv = 52;
    private static final int RsBlas_zaxpy = 32;
    private static final int RsBlas_zcopy = 31;
    private static final int RsBlas_zdotc_sub = 8;
    private static final int RsBlas_zdotu_sub = 7;
    private static final int RsBlas_zdscal = 46;
    private static final int RsBlas_zgbmv = 72;
    private static final int RsBlas_zgemm = 131;
    private static final int RsBlas_zgemv = 71;
    private static final int RsBlas_zgerc = 108;
    private static final int RsBlas_zgeru = 107;
    private static final int RsBlas_zhbmv = 105;
    private static final int RsBlas_zhemm = 140;
    private static final int RsBlas_zhemv = 104;
    private static final int RsBlas_zher = 109;
    private static final int RsBlas_zher2 = 111;
    private static final int RsBlas_zher2k = 142;
    private static final int RsBlas_zherk = 141;
    private static final int RsBlas_zhpmv = 106;
    private static final int RsBlas_zhpr = 110;
    private static final int RsBlas_zhpr2 = 112;
    private static final int RsBlas_zscal = 44;
    private static final int RsBlas_zswap = 30;
    private static final int RsBlas_zsymm = 132;
    private static final int RsBlas_zsyr2k = 134;
    private static final int RsBlas_zsyrk = 133;
    private static final int RsBlas_ztbmv = 74;
    private static final int RsBlas_ztbsv = 77;
    private static final int RsBlas_ztpmv = 75;
    private static final int RsBlas_ztpsv = 78;
    private static final int RsBlas_ztrmm = 135;
    private static final int RsBlas_ztrmv = 73;
    private static final int RsBlas_ztrsm = 136;
    private static final int RsBlas_ztrsv = 76;
    public static final int TRANSPOSE = 112;
    public static final int UNIT = 132;
    public static final int UPPER = 121;
    private Allocation mLUT;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Diag {
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transpose {
    }

    private ScriptIntrinsicBLAS(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicBLAS create(RenderScript renderScript) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 23;
        ScriptIntrinsicBLAS scriptIntrinsicBLAS = new ScriptIntrinsicBLAS(renderScript.nScriptIntrinsicCreate(13, Element.U32(renderScript).getID(renderScript), z), renderScript);
        scriptIntrinsicBLAS.setIncSupp(z);
        return scriptIntrinsicBLAS;
    }

    static void validateConjTranspose(int i) {
        if (i != 111 && i != 113) {
            throw new RSRuntimeException("Invalid transpose passed to BLAS");
        }
    }

    static void validateDiag(int i) {
        if (i != 131 && i != 132) {
            throw new RSRuntimeException("Invalid diag passed to BLAS");
        }
    }

    static void validateGEMV(Element element, int i, Allocation allocation, Allocation allocation2, int i2, Allocation allocation3, int i3) {
        int i4;
        int i5;
        validateTranspose(i);
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation2.getType().getY() > 1 || allocation3.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (i == 111) {
            i5 = ((x - 1) * i2) + 1;
            i4 = ((y - 1) * i3) + 1;
        } else {
            int i6 = ((y - 1) * i2) + 1;
            i4 = ((x - 1) * i3) + 1;
            i5 = i6;
        }
        if (allocation2.getType().getX() != i5 || allocation3.getType().getX() != i4) {
            throw new RSRuntimeException("Incorrect vector dimensions for GEMV");
        }
    }

    static void validateGER(Element element, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        if (!allocation3.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation.getType().getY() > 1 || allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        if (x < 1 || y < 1) {
            throw new RSRuntimeException("M and N must be 1 or greater for GER");
        }
        if (i <= 0 || i2 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation.getType().getX() != ((y - 1) * i) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for GER");
        }
        if (allocation2.getType().getX() != ((x - 1) * i2) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for GER");
        }
    }

    static void validateGERU(Element element, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        if (!allocation3.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation.getType().getY() > 1 || allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        if (i <= 0 || i2 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation.getType().getX() != ((y - 1) * i) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for GERU");
        }
        if (allocation2.getType().getX() != ((x - 1) * i2) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for GERU");
        }
    }

    static void validateHEMM(Element element, int i, Allocation allocation, Allocation allocation2, Allocation allocation3) {
        validateSide(i);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        int x = allocation.getType().getX();
        if (x != allocation.getType().getY()) {
            throw new RSRuntimeException("Called HEMM with non-square A");
        }
        if ((i == 141 && x != allocation2.getType().getY()) || (i == 142 && x != allocation2.getType().getX())) {
            throw new RSRuntimeException("Called HEMM with invalid B");
        }
        if (allocation2.getType().getX() != allocation3.getType().getX() || allocation2.getType().getY() != allocation3.getType().getY()) {
            throw new RSRuntimeException("Called HEMM with mismatched B and C");
        }
    }

    static void validateHER2K(Element element, int i, Allocation allocation, Allocation allocation2, Allocation allocation3) {
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        validateConjTranspose(i);
        int x = allocation3.getType().getX();
        if (x != allocation3.getType().getY()) {
            throw new RSRuntimeException("Called HER2K with non-square C");
        }
        if (i == 111) {
            if (allocation.getType().getY() != x) {
                throw new RSRuntimeException("Called HER2K with invalid matrices");
            }
        } else if (allocation.getType().getX() != x) {
            throw new RSRuntimeException("Called HER2K with invalid matrices");
        }
        if (allocation.getType().getX() != allocation2.getType().getX() || allocation.getType().getY() != allocation2.getType().getY()) {
            throw new RSRuntimeException("Called HER2K with invalid A and B matrices");
        }
    }

    static void validateHERK(Element element, int i, Allocation allocation, Allocation allocation2) {
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        validateConjTranspose(i);
        int x = allocation2.getType().getX();
        if (x != allocation2.getType().getY()) {
            throw new RSRuntimeException("Called HERK with non-square C");
        }
        if (i == 111) {
            if (x != allocation.getType().getY()) {
                throw new RSRuntimeException("Called HERK with invalid A");
            }
        } else if (x != allocation.getType().getX()) {
            throw new RSRuntimeException("Called HERK with invalid A");
        }
    }

    static void validateL3(Element element, int i, int i2, int i3, Allocation allocation, Allocation allocation2, Allocation allocation3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((allocation != null && !allocation.getType().getElement().isCompatible(element)) || ((allocation2 != null && !allocation2.getType().getElement().isCompatible(element)) || (allocation3 != null && !allocation3.getType().getElement().isCompatible(element)))) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation3 == null) {
            throw new RSRuntimeException("Allocation C cannot be null");
        }
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        int i10 = -1;
        if (i3 != 142) {
            if (allocation == null) {
                i4 = -1;
                i5 = -1;
            } else if (i == 112 || i == 113) {
                i5 = allocation.getType().getY();
                i4 = allocation.getType().getX();
            } else {
                i4 = allocation.getType().getY();
                i5 = allocation.getType().getX();
            }
            if (allocation2 == null) {
                i6 = i4;
                i10 = i5;
                i7 = -1;
                i8 = -1;
            } else if (i2 == 112 || i2 == 113) {
                int y2 = allocation2.getType().getY();
                i8 = y2;
                i10 = i5;
                i6 = i4;
                i7 = allocation2.getType().getX();
            } else {
                int y3 = allocation2.getType().getY();
                i8 = allocation2.getType().getX();
                i6 = i4;
                i7 = y3;
                i10 = i5;
            }
        } else {
            if ((allocation == null && allocation2 != null) || (allocation != null && allocation2 == null)) {
                throw new RSRuntimeException("Provided Matrix A without Matrix B, or vice versa");
            }
            if (allocation2 != null) {
                i7 = allocation.getType().getY();
                i9 = allocation.getType().getX();
            } else {
                i7 = -1;
                i9 = -1;
            }
            if (allocation != null) {
                int y4 = allocation2.getType().getY();
                i8 = i9;
                i6 = y4;
                i10 = allocation2.getType().getX();
            } else {
                i8 = i9;
                i6 = -1;
            }
        }
        if (allocation != null && allocation2 != null) {
            if (i10 != i7 || i6 != y || i8 != x) {
                throw new RSRuntimeException("Called BLAS with invalid dimensions");
            }
            return;
        }
        if (allocation != null) {
            if (y != x) {
                throw new RSRuntimeException("Matrix C is not symmetric");
            }
            if (i6 != y) {
                throw new RSRuntimeException("Called BLAS with invalid dimensions");
            }
            return;
        }
        if (allocation != null && allocation2 != null && i10 != i7) {
            throw new RSRuntimeException("Called BLAS with invalid dimensions");
        }
    }

    static int validateSPMV(Element element, int i, Allocation allocation, Allocation allocation2, int i2, Allocation allocation3, int i3) {
        validateUplo(i);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation2.getType().getY() > 1 || allocation3.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (allocation.getType().getY() > 1) {
            throw new RSRuntimeException("Ap must have a Y dimension of 0 or 1");
        }
        int sqrt = (int) Math.sqrt(allocation.getType().getX() * 2.0d);
        if (allocation.getType().getX() != ((sqrt + 1) * sqrt) / 2) {
            throw new RSRuntimeException("Invalid dimension for Ap");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        int i4 = sqrt - 1;
        if (allocation2.getType().getX() != (i2 * i4) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for SPMV");
        }
        if (allocation3.getType().getX() == (i4 * i3) + 1) {
            return sqrt;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SPMV");
    }

    static int validateSPR(Element element, int i, Allocation allocation, int i2, Allocation allocation2) {
        validateUplo(i);
        if (!allocation2.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("Ap must have a Y dimension of 0 or 1");
        }
        int sqrt = (int) Math.sqrt(allocation2.getType().getX() * 2.0d);
        if (allocation2.getType().getX() != ((sqrt + 1) * sqrt) / 2) {
            throw new RSRuntimeException("Invalid dimension for Ap");
        }
        if (i2 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation.getType().getX() == ((sqrt - 1) * i2) + 1) {
            return sqrt;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SPR");
    }

    static int validateSPR2(Element element, int i, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        validateUplo(i);
        if (!allocation3.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation.getType().getY() > 1 || allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (allocation3.getType().getY() > 1) {
            throw new RSRuntimeException("Ap must have a Y dimension of 0 or 1");
        }
        int sqrt = (int) Math.sqrt(allocation3.getType().getX() * 2.0d);
        if (allocation3.getType().getX() != ((sqrt + 1) * sqrt) / 2) {
            throw new RSRuntimeException("Invalid dimension for Ap");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        int i4 = sqrt - 1;
        int i5 = (i2 * i4) + 1;
        int i6 = (i4 * i3) + 1;
        if (allocation.getType().getX() == i5 && allocation2.getType().getX() == i6) {
            return sqrt;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SPR2");
    }

    static int validateSYMV(Element element, int i, Allocation allocation, Allocation allocation2, Allocation allocation3, int i2, int i3) {
        validateUplo(i);
        int y = allocation.getType().getY();
        if (allocation.getType().getX() != y) {
            throw new RSRuntimeException("A must be a square matrix for SYMV");
        }
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation2.getType().getY() > 1 || allocation3.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        int i4 = y - 1;
        if (allocation2.getType().getX() != (i2 * i4) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for SYMV");
        }
        if (allocation3.getType().getX() == (i4 * i3) + 1) {
            return y;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SYMV");
    }

    static int validateSYR(Element element, int i, Allocation allocation, int i2, Allocation allocation2) {
        validateUplo(i);
        if (!allocation2.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        int x = allocation2.getType().getX();
        if (allocation.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (x != allocation2.getType().getY()) {
            throw new RSRuntimeException("A must be a symmetric matrix");
        }
        if (i2 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation.getType().getX() == ((x - 1) * i2) + 1) {
            return x;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SYR");
    }

    static int validateSYR2(Element element, int i, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        validateUplo(i);
        if (!allocation3.getType().getElement().isCompatible(element) || !allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation.getType().getY() > 1 || allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        int x = allocation3.getType().getX();
        if (x != allocation3.getType().getY()) {
            throw new RSRuntimeException("A must be a symmetric matrix");
        }
        if (i2 <= 0 || i3 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        int i4 = x - 1;
        int i5 = (i2 * i4) + 1;
        int i6 = (i4 * i3) + 1;
        if (allocation.getType().getX() == i5 && allocation2.getType().getX() == i6) {
            return x;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for SYR");
    }

    static void validateSYR2K(Element element, int i, Allocation allocation, Allocation allocation2, Allocation allocation3) {
        validateTranspose(i);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element) || !allocation3.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        int x = i == 112 ? allocation.getType().getX() : allocation.getType().getY();
        if (allocation3.getType().getX() != x || allocation3.getType().getY() != x) {
            throw new RSRuntimeException("Invalid symmetric matrix in SYR2K");
        }
        if (allocation.getType().getX() != allocation2.getType().getX() || allocation.getType().getY() != allocation2.getType().getY()) {
            throw new RSRuntimeException("Invalid A and B in SYR2K");
        }
    }

    static void validateSide(int i) {
        if (i != 141 && i != 142) {
            throw new RSRuntimeException("Invalid side passed to BLAS");
        }
    }

    static int validateTPMV(Element element, int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTranspose(i2);
        validateUplo(i);
        validateDiag(i3);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (allocation.getType().getY() > 1) {
            throw new RSRuntimeException("Ap must have a Y dimension of 0 or 1");
        }
        int sqrt = (int) Math.sqrt(allocation.getType().getX() * 2.0d);
        if (allocation.getType().getX() != ((sqrt + 1) * sqrt) / 2) {
            throw new RSRuntimeException("Invalid dimension for Ap");
        }
        if (i4 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation2.getType().getX() == ((sqrt - 1) * i4) + 1) {
            return sqrt;
        }
        throw new RSRuntimeException("Incorrect vector dimensions for TPMV");
    }

    static void validateTRMM(Element element, int i, int i2, Allocation allocation, Allocation allocation2) {
        validateSide(i);
        validateTranspose(i2);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        if (y != x) {
            throw new RSRuntimeException("Called TRMM with a non-symmetric matrix A");
        }
        int y2 = allocation2.getType().getY();
        int x2 = allocation2.getType().getX();
        if (i == 141) {
            if (x != y2) {
                throw new RSRuntimeException("Called TRMM with invalid matrices");
            }
        } else if (x2 != y) {
            throw new RSRuntimeException("Called TRMM with invalid matrices");
        }
    }

    static void validateTRMV(Element element, int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTranspose(i2);
        validateUplo(i);
        validateDiag(i3);
        int y = allocation.getType().getY();
        if (allocation.getType().getX() != y) {
            throw new RSRuntimeException("A must be a square matrix for TRMV");
        }
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        if (allocation2.getType().getY() > 1) {
            throw new RSRuntimeException("BLAS vectors must have Y dimension of 0 or 1");
        }
        if (i4 <= 0) {
            throw new RSRuntimeException("Vector increments must be greater than 0");
        }
        if (allocation2.getType().getX() != ((y - 1) * i4) + 1) {
            throw new RSRuntimeException("Incorrect vector dimensions for TRMV");
        }
    }

    static void validateTRSM(Element element, int i, int i2, Allocation allocation, Allocation allocation2) {
        validateSide(i);
        validateTranspose(i2);
        if (!allocation.getType().getElement().isCompatible(element) || !allocation2.getType().getElement().isCompatible(element)) {
            throw new RSRuntimeException("Called BLAS with wrong Element type");
        }
        int x = allocation.getType().getX();
        if (x != allocation.getType().getY()) {
            throw new RSRuntimeException("Called TRSM with a non-symmetric matrix A");
        }
        int y = allocation2.getType().getY();
        int x2 = allocation2.getType().getX();
        if (i == 141) {
            if (x != y) {
                throw new RSRuntimeException("Called TRSM with invalid matrix dimensions");
            }
        } else if (x != x2) {
            throw new RSRuntimeException("Called TRSM with invalid matrix dimensions");
        }
    }

    static void validateTranspose(int i) {
        if (i != 111 && i != 112 && i != 113) {
            throw new RSRuntimeException("Invalid transpose passed to BLAS");
        }
    }

    static void validateUplo(int i) {
        if (i != 121 && i != 122) {
            throw new RSRuntimeException("Invalid uplo passed to BLAS");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void BNNM(Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3, int i3, int i4) {
        long j;
        long j2;
        long j3;
        validateL3(Element.U8(this.mRS), 111, 112, 0, allocation, allocation2, allocation3);
        if (i < 0 || i > 255) {
            throw new RSRuntimeException("Invalid a_offset passed to BNNM");
        }
        if (i2 < 0 || i2 > 255) {
            throw new RSRuntimeException("Invalid b_offset passed to BNNM");
        }
        int y = allocation.getType().getY();
        int y2 = allocation2.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            long dummyAlloc2 = getDummyAlloc(allocation2);
            j3 = getDummyAlloc(allocation3);
            j2 = dummyAlloc2;
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_BNNM(getID(renderScript), y, y2, x, j, i, j2, i2, j3, i3, i4, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CGBMV(int i, int i2, int i3, Float2 float2, Allocation allocation, Allocation allocation2, int i4, Float2 float22, Allocation allocation3, int i5) {
        validateGEMV(Element.F32_2(this.mRS), i, allocation, allocation2, i4, allocation3, i5);
        if (i2 < 0 || i3 < 0) {
            throw new RSRuntimeException("KL and KU must be greater than or equal to 0");
        }
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 64, i, 0, 0, 0, 0, y, x, 0, float2.x, float2.y, id, id2, float22.x, float22.y, id3, i4, i5, i2, i3, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CGEMM(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, Float2 float22, Allocation allocation3) {
        int y;
        int x;
        long j;
        long j2;
        long j3;
        validateTranspose(i);
        validateTranspose(i2);
        validateL3(Element.F32_2(this.mRS), i, i2, 0, allocation, allocation2, allocation3);
        if (i != 111) {
            y = allocation.getType().getX();
            x = allocation.getType().getY();
        } else {
            y = allocation.getType().getY();
            x = allocation.getType().getX();
        }
        int i3 = y;
        int i4 = x;
        int y2 = i2 != 111 ? allocation2.getType().getY() : allocation2.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            j = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 125, i, i2, 0, 0, 0, i3, y2, i4, float2.x, float2.y, j, j2, float22.x, float22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CGEMV(int i, Float2 float2, Allocation allocation, Allocation allocation2, int i2, Float2 float22, Allocation allocation3, int i3) {
        validateGEMV(Element.F32_2(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 63, i, 0, 0, 0, 0, y, x, 0, float2.x, float2.y, id, id2, float22.x, float22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CGERC(Float2 float2, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        validateGERU(Element.F32_2(this.mRS), allocation, i, allocation2, i2, allocation3);
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 99, 0, 0, 0, 0, 0, y, x, 0, float2.x, float2.y, id2, id3, 0.0f, 0.0f, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CGERU(Float2 float2, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        validateGERU(Element.F32_2(this.mRS), allocation, i, allocation2, i2, allocation3);
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 98, 0, 0, 0, 0, 0, y, x, 0, float2.x, float2.y, id2, id3, 0.0f, 0.0f, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHBMV(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, int i3, Float2 float22, Allocation allocation3, int i4) {
        int validateSYR2 = validateSYR2(Element.F32_2(this.mRS), i, allocation2, i3, allocation3, i4, allocation);
        if (i2 < 0) {
            throw new RSRuntimeException("K must be 0 or greater for HBMV");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 96, 0, 0, 0, i, 0, 0, validateSYR2, i2, float2.x, float2.y, id, id2, float22.x, float22.y, id3, i3, i4, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHEMM(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, Float2 float22, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i2);
        validateHEMM(Element.F32_2(this.mRS), i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_chemm, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, float2.x, float2.y, j, j2, float22.x, float22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHEMV(int i, Float2 float2, Allocation allocation, Allocation allocation2, int i2, Float2 float22, Allocation allocation3, int i3) {
        int validateSYR2 = validateSYR2(Element.F32_2(this.mRS), i, allocation2, i2, allocation3, i3, allocation);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 95, 0, 0, 0, i, 0, 0, validateSYR2, 0, float2.x, float2.y, id, id2, float22.x, float22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHER(int i, float f, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSYR = validateSYR(Element.F32_2(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 100, 0, 0, 0, i, 0, 0, validateSYR, 0, f, 0.0f, j2, 0L, 0.0f, 0.0f, j, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHER2(int i, Float2 float2, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSYR2 = validateSYR2(Element.F32_2(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 102, 0, 0, 0, i, 0, 0, validateSYR2, 0, float2.x, float2.y, id2, id3, 0.0f, 0.0f, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHER2K(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, float f, Allocation allocation3) {
        long j;
        long j2;
        validateUplo(i);
        validateHER2K(Element.F32_2(this.mRS), i2, allocation, allocation2, allocation3);
        int x = i2 == 111 ? allocation.getType().getX() : allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        allocation.getID(this.mRS);
        long id = allocation2.getID(this.mRS);
        long id2 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            getDummyAlloc(allocation);
            j = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_cher2k, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), x, float2.x, float2.y, allocation.getID(this.mRS), j, f, 0.0f, j2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHERK(int i, int i2, float f, Allocation allocation, float f2, Allocation allocation2) {
        long j;
        long j2;
        validateUplo(i);
        validateHERK(Element.F32_2(this.mRS), i2, allocation, allocation2);
        int y = i2 == 113 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            j = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_cherk, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, f, 0.0f, j, 0L, f2, 0.0f, j2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHPMV(int i, Float2 float2, Allocation allocation, Allocation allocation2, int i2, Float2 float22, Allocation allocation3, int i3) {
        int validateSPR2 = validateSPR2(Element.F32_2(this.mRS), i, allocation2, i2, allocation3, i3, allocation);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 97, 0, 0, 0, i, 0, 0, validateSPR2, 0, float2.x, float2.y, id, id2, float22.x, float22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHPR(int i, float f, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSPR = validateSPR(Element.F32_2(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 101, 0, 0, 0, i, 0, 0, validateSPR, 0, f, 0.0f, j2, 0L, 0.0f, 0.0f, j, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CHPR2(int i, Float2 float2, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSPR2 = validateSPR2(Element.F32_2(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 103, 0, 0, 0, i, 0, 0, validateSPR2, 0, float2.x, float2.y, id2, id3, 0.0f, 0.0f, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CSYMM(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, Float2 float22, Allocation allocation3) {
        validateSide(i);
        validateUplo(i2);
        if (allocation.getType().getX() != allocation.getType().getY()) {
            throw new RSRuntimeException("Matrix A is not symmetric");
        }
        validateL3(Element.F32_2(this.mRS), 0, 0, i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 126, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, float2.x, float2.y, id, id2, float22.x, float22.y, id3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CSYR2K(int i, int i2, Float2 float2, Allocation allocation, Allocation allocation2, Float2 float22, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i);
        validateSYR2K(Element.F32_2(this.mRS), i2, allocation, allocation2, allocation3);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 128, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), y, float2.x, float2.y, j, j2, float22.x, float22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CSYRK(int i, int i2, Float2 float2, Allocation allocation, Float2 float22, Allocation allocation2) {
        validateTranspose(i2);
        validateUplo(i);
        validateL3(Element.F32_2(this.mRS), i2, 0, 0, allocation, null, allocation2);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_csyrk, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, float2.x, float2.y, id, 0L, float22.x, float22.y, allocation2.getID(this.mRS), 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTBMV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        if (i4 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        validateTRMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 66, i2, 0, 0, i, i3, 0, y, i4, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTBSV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        validateTRMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        if (i4 < 0) {
            throw new RSRuntimeException("Number of diagonals must be positive");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 69, i2, 0, 0, i, i3, 0, y, i4, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTPMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 67, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTPSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 70, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTRMM(int i, int i2, int i3, int i4, Float2 float2, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRMM(Element.F32_2(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_ctrmm, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, float2.x, float2.y, id, j, 0.0f, 0.0f, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTRMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 65, i2, 0, 0, i, i3, 0, y, 0, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTRSM(int i, int i2, int i3, int i4, Float2 float2, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRSM(Element.F32_2(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), RsBlas_ctrsm, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, float2.x, float2.y, id, j, 0.0f, 0.0f, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void CTRSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F32_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Complex(getID(renderScript), 68, i2, 0, 0, i, i3, 0, y, 0, 0.0f, 0.0f, id, id2, 0.0f, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DGBMV(int i, int i2, int i3, double d, Allocation allocation, Allocation allocation2, int i4, double d2, Allocation allocation3, int i5) {
        validateGEMV(Element.F64(this.mRS), i, allocation, allocation2, i4, allocation3, i5);
        if (i2 < 0 || i3 < 0) {
            throw new RSRuntimeException("KL and KU must be greater than or equal to 0");
        }
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 56, i, 0, 0, 0, 0, y, x, 0, d, id, id2, d2, id3, i4, i5, i2, i3, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DGEMM(int i, int i2, double d, Allocation allocation, Allocation allocation2, double d2, Allocation allocation3) {
        int y;
        int x;
        long j;
        long j2;
        long j3;
        validateTranspose(i);
        validateTranspose(i2);
        validateL3(Element.F64(this.mRS), i, i2, 0, allocation, allocation2, allocation3);
        if (i != 111) {
            y = allocation.getType().getX();
            x = allocation.getType().getY();
        } else {
            y = allocation.getType().getY();
            x = allocation.getType().getX();
        }
        int i3 = y;
        int i4 = x;
        int y2 = i2 != 111 ? allocation2.getType().getY() : allocation2.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            j = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 119, i, i2, 0, 0, 0, i3, y2, i4, d, j, j2, d2, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DGEMV(int i, double d, Allocation allocation, Allocation allocation2, int i2, double d2, Allocation allocation3, int i3) {
        validateGEMV(Element.F64(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 55, i, 0, 0, 0, 0, y, x, 0, d, id, id2, d2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DGER(double d, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        validateGER(Element.F64(this.mRS), allocation, i, allocation2, i2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 90, 0, 0, 0, 0, 0, y, x, 0, d, id2, id3, 0.0d, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSBMV(int i, int i2, double d, Allocation allocation, Allocation allocation2, int i3, double d2, Allocation allocation3, int i4) {
        if (i2 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        int validateSYMV = validateSYMV(Element.F64(this.mRS), i, allocation, allocation2, allocation3, i3, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 88, 0, 0, 0, i, 0, 0, validateSYMV, i2, d, id, id2, d2, id3, i3, i4, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSPMV(int i, double d, Allocation allocation, Allocation allocation2, int i2, double d2, Allocation allocation3, int i3) {
        int validateSPMV = validateSPMV(Element.F64(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 89, 0, 0, 0, i, 0, 0, validateSPMV, 0, d, id, id2, d2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSPR(int i, double d, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSPR = validateSPR(Element.F64(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 92, 0, 0, 0, i, 0, 0, validateSPR, 0, d, j2, j, 0.0d, 0L, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSPR2(int i, double d, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSPR2 = validateSPR2(Element.F64(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 94, 0, 0, 0, i, 0, 0, validateSPR2, 0, d, id2, id3, 0.0d, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYMM(int i, int i2, double d, Allocation allocation, Allocation allocation2, double d2, Allocation allocation3) {
        validateSide(i);
        validateUplo(i2);
        if (allocation.getType().getX() != allocation.getType().getY()) {
            throw new RSRuntimeException("Matrix A is not symmetric");
        }
        validateL3(Element.F64(this.mRS), 0, 0, i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 120, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, d, id, id2, d2, id3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYMV(int i, double d, Allocation allocation, Allocation allocation2, int i2, double d2, Allocation allocation3, int i3) {
        int validateSYMV = validateSYMV(Element.F64(this.mRS), i, allocation, allocation2, allocation3, i2, i3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 87, 0, 0, 0, i, 0, 0, validateSYMV, 0, d, id, id2, d2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYR(int i, double d, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSYR = validateSYR(Element.F64(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 91, 0, 0, 0, i, 0, 0, validateSYR, 0, d, j2, j, 0.0d, 0L, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYR2(int i, double d, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSYR2 = validateSYR2(Element.F64(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 93, 0, 0, 0, i, 0, 0, validateSYR2, 0, d, id2, id3, 0.0d, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYR2K(int i, int i2, double d, Allocation allocation, Allocation allocation2, double d2, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i);
        validateSYR2K(Element.F64(this.mRS), i2, allocation, allocation2, allocation3);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 122, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), y, d, j, j2, d2, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DSYRK(int i, int i2, double d, Allocation allocation, double d2, Allocation allocation2) {
        validateTranspose(i2);
        validateUplo(i);
        validateL3(Element.F64(this.mRS), i2, 0, 0, allocation, null, allocation2);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 121, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, d, id, 0L, d2, id2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTBMV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        if (i4 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        validateTRMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 58, i2, 0, 0, i, i3, 0, y, i4, 0.0d, id, id2, 0.0d, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTBSV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        validateTRMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        if (i4 < 0) {
            throw new RSRuntimeException("Number of diagonals must be positive");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 61, i2, 0, 0, i, i3, 0, y, i4, 0.0d, id, id2, 0.0d, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTPMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 59, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0d, id, id2, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTPSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 62, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0d, id, id2, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTRMM(int i, int i2, int i3, int i4, double d, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRMM(Element.F64(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 123, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, d, id, j, 0.0d, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTRMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 57, i2, 0, 0, i, i3, 0, y, 0, 0.0d, id, id2, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTRSM(int i, int i2, int i3, int i4, double d, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRSM(Element.F64(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 124, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, d, id, j, 0.0d, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void DTRSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F64(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Double(getID(renderScript), 60, i2, 0, 0, i, i3, 0, y, 0, 0.0d, id, id2, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SGBMV(int i, int i2, int i3, float f, Allocation allocation, Allocation allocation2, int i4, float f2, Allocation allocation3, int i5) {
        validateGEMV(Element.F32(this.mRS), i, allocation, allocation2, i4, allocation3, i5);
        if (i2 < 0 || i3 < 0) {
            throw new RSRuntimeException("KL and KU must be greater than or equal to 0");
        }
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 48, i, 0, 0, 0, 0, y, x, 0, f, id, id2, f2, id3, i4, i5, i2, i3, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SGEMM(int i, int i2, float f, Allocation allocation, Allocation allocation2, float f2, Allocation allocation3) {
        int y;
        int x;
        long j;
        long j2;
        long j3;
        validateTranspose(i);
        validateTranspose(i2);
        validateL3(Element.F32(this.mRS), i, i2, 0, allocation, allocation2, allocation3);
        if (i != 111) {
            y = allocation.getType().getX();
            x = allocation.getType().getY();
        } else {
            y = allocation.getType().getY();
            x = allocation.getType().getX();
        }
        int i3 = y;
        int i4 = x;
        int y2 = i2 != 111 ? allocation2.getType().getY() : allocation2.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            j3 = getDummyAlloc(allocation);
            j = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation3);
        } else {
            j = id2;
            j2 = id3;
            j3 = id;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 113, i, i2, 0, 0, 0, i3, y2, i4, f, j3, j, f2, j2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SGEMV(int i, float f, Allocation allocation, Allocation allocation2, int i2, float f2, Allocation allocation3, int i3) {
        validateGEMV(Element.F32(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 47, i, 0, 0, 0, 0, y, x, 0, f, id, id2, f2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SGER(float f, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        validateGER(Element.F32(this.mRS), allocation, i, allocation2, i2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 82, 0, 0, 0, 0, 0, y, x, 0, f, id2, id3, 0.0f, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSBMV(int i, int i2, float f, Allocation allocation, Allocation allocation2, int i3, float f2, Allocation allocation3, int i4) {
        if (i2 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        int validateSYMV = validateSYMV(Element.F32(this.mRS), i, allocation, allocation2, allocation3, i3, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 80, 0, 0, 0, i, 0, 0, validateSYMV, i2, f, id, id2, f2, id3, i3, i4, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSPMV(int i, float f, Allocation allocation, Allocation allocation2, int i2, float f2, Allocation allocation3, int i3) {
        int validateSPMV = validateSPMV(Element.F32(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 81, 0, 0, 0, i, 0, 0, validateSPMV, 0, f, id, id2, f2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSPR(int i, float f, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSPR = validateSPR(Element.F32(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 84, 0, 0, 0, i, 0, 0, validateSPR, 0, f, j2, j, 0.0f, 0L, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSPR2(int i, float f, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSPR2 = validateSPR2(Element.F32(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 86, 0, 0, 0, i, 0, 0, validateSPR2, 0, f, id2, id3, 0.0f, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYMM(int i, int i2, float f, Allocation allocation, Allocation allocation2, float f2, Allocation allocation3) {
        validateSide(i);
        validateUplo(i2);
        if (allocation.getType().getX() != allocation.getType().getY()) {
            throw new RSRuntimeException("Matrix A is not symmetric");
        }
        validateL3(Element.F32(this.mRS), 0, 0, i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 114, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, f, id, id2, f2, id3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYMV(int i, float f, Allocation allocation, Allocation allocation2, int i2, float f2, Allocation allocation3, int i3) {
        int validateSYMV = validateSYMV(Element.F32(this.mRS), i, allocation, allocation2, allocation3, i2, i3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 79, 0, 0, 0, i, 0, 0, validateSYMV, 0, f, id, id2, f2, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYR(int i, float f, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSYR = validateSYR(Element.F32(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 83, 0, 0, 0, i, 0, 0, validateSYR, 0, f, j2, j, 0.0f, 0L, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYR2(int i, float f, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSYR2 = validateSYR2(Element.F32(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 85, 0, 0, 0, i, 0, 0, validateSYR2, 0, f, id2, id3, 0.0f, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYR2K(int i, int i2, float f, Allocation allocation, Allocation allocation2, float f2, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i);
        validateSYR2K(Element.F32(this.mRS), i2, allocation, allocation2, allocation3);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 116, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), y, f, j, j2, f2, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void SSYRK(int i, int i2, float f, Allocation allocation, float f2, Allocation allocation2) {
        validateTranspose(i2);
        validateUplo(i);
        validateL3(Element.F32(this.mRS), i2, 0, 0, allocation, null, allocation2);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 115, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, f, id, 0L, f2, id2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STBMV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        if (i4 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        validateTRMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 50, i2, 0, 0, i, i3, 0, y, i4, 0.0f, id, id2, 0.0f, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STBSV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        validateTRMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        if (i4 < 0) {
            throw new RSRuntimeException("Number of diagonals must be positive");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 53, i2, 0, 0, i, i3, 0, y, i4, 0.0f, id, id2, 0.0f, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STPMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 51, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0f, id, id2, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STPSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 54, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0f, id, id2, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STRMM(int i, int i2, int i3, int i4, float f, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRMM(Element.F32(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 117, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, f, id, j, 0.0f, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STRMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 49, i2, 0, 0, i, i3, 0, y, 0, 0.0f, id, id2, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STRSM(int i, int i2, int i3, int i4, float f, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRSM(Element.F32(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 118, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, f, id, j, 0.0f, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void STRSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F32(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Single(getID(renderScript), 52, i2, 0, 0, i, i3, 0, y, 0, 0.0f, id, id2, 0.0f, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZGBMV(int i, int i2, int i3, Double2 double2, Allocation allocation, Allocation allocation2, int i4, Double2 double22, Allocation allocation3, int i5) {
        validateGEMV(Element.F64_2(this.mRS), i, allocation, allocation2, i4, allocation3, i5);
        if (i2 < 0 || i3 < 0) {
            throw new RSRuntimeException("KL and KU must be greater than or equal to 0");
        }
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 72, i, 0, 0, 0, 0, y, x, 0, double2.x, double2.y, id, id2, double22.x, double22.y, id3, i4, i5, i2, i3, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZGEMM(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, Double2 double22, Allocation allocation3) {
        int y;
        int x;
        long j;
        long j2;
        long j3;
        validateTranspose(i);
        validateTranspose(i2);
        validateL3(Element.F64_2(this.mRS), i, i2, 0, allocation, allocation2, allocation3);
        if (i != 111) {
            y = allocation.getType().getX();
            x = allocation.getType().getY();
        } else {
            y = allocation.getType().getY();
            x = allocation.getType().getX();
        }
        int i3 = y;
        int i4 = x;
        int y2 = i2 != 111 ? allocation2.getType().getY() : allocation2.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            j = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 131, i, i2, 0, 0, 0, i3, y2, i4, double2.x, double2.y, j, j2, double22.x, double22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZGEMV(int i, Double2 double2, Allocation allocation, Allocation allocation2, int i2, Double2 double22, Allocation allocation3, int i3) {
        validateGEMV(Element.F64_2(this.mRS), i, allocation, allocation2, i2, allocation3, i3);
        int y = allocation.getType().getY();
        int x = allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 71, i, 0, 0, 0, 0, y, x, 0, double2.x, double2.y, id, id2, double22.x, double22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZGERC(Double2 double2, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        validateGERU(Element.F64_2(this.mRS), allocation, i, allocation2, i2, allocation3);
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 108, 0, 0, 0, 0, 0, y, x, 0, double2.x, double2.y, id2, id3, 0.0d, 0.0d, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZGERU(Double2 double2, Allocation allocation, int i, Allocation allocation2, int i2, Allocation allocation3) {
        validateGERU(Element.F64_2(this.mRS), allocation, i, allocation2, i2, allocation3);
        int y = allocation3.getType().getY();
        int x = allocation3.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 107, 0, 0, 0, 0, 0, y, x, 0, double2.x, double2.y, id2, id3, 0.0d, 0.0d, j, i, i2, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHBMV(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, int i3, Double2 double22, Allocation allocation3, int i4) {
        int validateSYR2 = validateSYR2(Element.F64_2(this.mRS), i, allocation2, i3, allocation3, i4, allocation);
        if (i2 < 0) {
            throw new RSRuntimeException("K must be 0 or greater for HBMV");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 105, 0, 0, 0, i, 0, 0, validateSYR2, i2, double2.x, double2.y, id, id2, double22.x, double22.y, id3, i3, i4, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHEMM(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, Double2 double22, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i2);
        validateHEMM(Element.F64_2(this.mRS), i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), RsBlas_zhemm, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, double2.x, double2.y, j, j2, double22.x, double22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHEMV(int i, Double2 double2, Allocation allocation, Allocation allocation2, int i2, Double2 double22, Allocation allocation3, int i3) {
        int validateSYR2 = validateSYR2(Element.F64_2(this.mRS), i, allocation2, i2, allocation3, i3, allocation);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 104, 0, 0, 0, i, 0, 0, validateSYR2, 0, double2.x, double2.y, id, id2, double22.x, double22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHER(int i, double d, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSYR = validateSYR(Element.F64_2(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 109, 0, 0, 0, i, 0, 0, validateSYR, 0, d, 0.0d, j2, 0L, 0.0d, 0.0d, j, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHER2(int i, Double2 double2, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSYR2 = validateSYR2(Element.F64_2(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 111, 0, 0, 0, i, 0, 0, validateSYR2, 0, double2.x, double2.y, id2, id3, 0.0d, 0.0d, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHER2K(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, double d, Allocation allocation3) {
        long j;
        long j2;
        validateUplo(i);
        validateHER2K(Element.F64_2(this.mRS), i2, allocation, allocation2, allocation3);
        int x = i2 == 111 ? allocation.getType().getX() : allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        allocation.getID(this.mRS);
        long id = allocation2.getID(this.mRS);
        long id2 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            getDummyAlloc(allocation);
            j = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 142, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), x, double2.x, double2.y, allocation.getID(this.mRS), j, d, 0.0d, j2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHERK(int i, int i2, double d, Allocation allocation, double d2, Allocation allocation2) {
        long j;
        long j2;
        validateUplo(i);
        validateHERK(Element.F64_2(this.mRS), i2, allocation, allocation2);
        int y = i2 == 113 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            j = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 141, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, d, 0.0d, j, 0L, d2, 0.0d, j2, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHPMV(int i, Double2 double2, Allocation allocation, Allocation allocation2, int i2, Double2 double22, Allocation allocation3, int i3) {
        int validateSPR2 = validateSPR2(Element.F64_2(this.mRS), i, allocation2, i2, allocation3, i3, allocation);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 106, 0, 0, 0, i, 0, 0, validateSPR2, 0, double2.x, double2.y, id, id2, double22.x, double22.y, id3, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHPR(int i, double d, Allocation allocation, int i2, Allocation allocation2) {
        long j;
        long j2;
        int validateSPR = validateSPR(Element.F64_2(this.mRS), i, allocation, i2, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation2.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation2);
            j2 = getDummyAlloc(allocation);
            j = dummyAlloc;
        } else {
            j = id;
            j2 = id2;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 110, 0, 0, 0, i, 0, 0, validateSPR, 0, d, 0.0d, j2, 0L, 0.0d, 0.0d, j, i2, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZHPR2(int i, Double2 double2, Allocation allocation, int i2, Allocation allocation2, int i3, Allocation allocation3) {
        int validateSPR2 = validateSPR2(Element.F64_2(this.mRS), i, allocation, i2, allocation2, i3, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation3.getID(this.mRS);
        long id2 = allocation.getID(this.mRS);
        long id3 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation3);
            id2 = getDummyAlloc(allocation);
            id3 = getDummyAlloc(allocation2);
        }
        long j = id;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 112, 0, 0, 0, i, 0, 0, validateSPR2, 0, double2.x, double2.y, id2, id3, 0.0d, 0.0d, j, i2, i3, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZSYMM(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, Double2 double22, Allocation allocation3) {
        validateSide(i);
        validateUplo(i2);
        if (allocation.getType().getX() != allocation.getType().getY()) {
            throw new RSRuntimeException("Matrix A is not symmetric");
        }
        validateL3(Element.F64_2(this.mRS), 0, 0, i, allocation, allocation2, allocation3);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
            id3 = getDummyAlloc(allocation3);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 132, 0, 0, i, i2, 0, allocation3.getType().getY(), allocation3.getType().getX(), 0, double2.x, double2.y, id, id2, double22.x, double22.y, id3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZSYR2K(int i, int i2, Double2 double2, Allocation allocation, Allocation allocation2, Double2 double22, Allocation allocation3) {
        long j;
        long j2;
        long j3;
        validateUplo(i);
        validateSYR2K(Element.F64_2(this.mRS), i2, allocation, allocation2, allocation3);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        long id3 = allocation3.getID(this.mRS);
        if (isIncSupp) {
            long dummyAlloc = getDummyAlloc(allocation);
            j2 = getDummyAlloc(allocation2);
            j = dummyAlloc;
            j3 = getDummyAlloc(allocation3);
        } else {
            j = id;
            j2 = id2;
            j3 = id3;
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), RsBlas_zsyr2k, i2, 0, 0, i, 0, 0, allocation3.getType().getX(), y, double2.x, double2.y, j, j2, double22.x, double22.y, j3, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZSYRK(int i, int i2, Double2 double2, Allocation allocation, Double2 double22, Allocation allocation2) {
        validateTranspose(i2);
        validateUplo(i);
        validateL3(Element.F64_2(this.mRS), i2, 0, 0, allocation, null, allocation2);
        int y = i2 != 111 ? allocation.getType().getY() : allocation.getType().getX();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), RsBlas_zsyrk, i2, 0, 0, i, 0, 0, allocation2.getType().getX(), y, double2.x, double2.y, id, 0L, double22.x, double22.y, allocation2.getID(this.mRS), 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTBMV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        if (i4 < 0) {
            throw new RSRuntimeException("K must be greater than or equal to 0");
        }
        validateTRMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 74, i2, 0, 0, i, i3, 0, y, i4, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTBSV(int i, int i2, int i3, int i4, Allocation allocation, Allocation allocation2, int i5) {
        validateTRMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i5);
        int y = allocation.getType().getY();
        if (i4 < 0) {
            throw new RSRuntimeException("Number of diagonals must be positive");
        }
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 77, i2, 0, 0, i, i3, 0, y, i4, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i5, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTPMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 75, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTPSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        int validateTPMV = validateTPMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 78, i2, 0, 0, i, i3, 0, validateTPMV, 0, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTRMM(int i, int i2, int i3, int i4, Double2 double2, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRMM(Element.F64_2(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), RsBlas_ztrmm, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, double2.x, double2.y, id, j, 0.0d, 0.0d, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTRMV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 73, i2, 0, 0, i, i3, 0, y, 0, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTRSM(int i, int i2, int i3, int i4, Double2 double2, Allocation allocation, Allocation allocation2) {
        validateUplo(i2);
        validateDiag(i4);
        validateTRSM(Element.F64_2(this.mRS), i, i3, allocation, allocation2);
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        long j = id2;
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), RsBlas_ztrsm, i3, 0, i, i2, i4, allocation2.getType().getY(), allocation2.getType().getX(), 0, double2.x, double2.y, id, j, 0.0d, 0.0d, 0L, 0, 0, 0, 0, isIncSupp);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ZTRSV(int i, int i2, int i3, Allocation allocation, Allocation allocation2, int i4) {
        validateTRMV(Element.F64_2(this.mRS), i, i2, i3, allocation, allocation2, i4);
        int y = allocation.getType().getY();
        boolean isIncSupp = isIncSupp();
        long id = allocation.getID(this.mRS);
        long id2 = allocation2.getID(this.mRS);
        if (isIncSupp) {
            id = getDummyAlloc(allocation);
            id2 = getDummyAlloc(allocation2);
        }
        RenderScript renderScript = this.mRS;
        renderScript.nScriptIntrinsicBLAS_Z(getID(renderScript), 76, i2, 0, 0, i, i3, 0, y, 0, 0.0d, 0.0d, id, id2, 0.0d, 0.0d, 0L, i4, 0, 0, 0, isIncSupp);
    }
}
