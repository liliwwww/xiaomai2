package androidx.compose.material.icons.outlined;

import androidx.compose.ui.graphics.vector.ImageVector;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MenuKt {

    @Nullable
    private static ImageVector _menu;

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: androidx.compose.ui.graphics.vector.ImageVector.Builder.addPath-oIyEayM$default(androidx.compose.ui.graphics.vector.ImageVector$Builder, java.util.List, int, java.lang.String, androidx.compose.ui.graphics.Brush, float, androidx.compose.ui.graphics.Brush, float, float, int, int, float, float, float, float, int, java.lang.Object):androidx.compose.ui.graphics.vector.ImageVector$Builder
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:79)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1685)
        	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
        	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:141)
        	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:134)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:496)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1122)
        	at jadx.core.utils.BlockUtils.replaceInsn(BlockUtils.java:1131)
        	at jadx.core.dex.visitors.InlineMethods.inlineMethod(InlineMethods.java:118)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:77)
        	... 1 more
        */
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.graphics.vector.ImageVector getMenu(@org.jetbrains.annotations.NotNull androidx.compose.material.icons.Icons$Outlined r29) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.outlined.MenuKt._menu
            if (r0 == 0) goto Lf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        Lf:
            androidx.compose.ui.graphics.vector.ImageVector$Builder r1 = new androidx.compose.ui.graphics.vector.ImageVector$Builder
            r12 = r1
            r0 = 1103101952(0x41c00000, float:24.0)
            float r3 = androidx.compose.ui.unit.Dp.constructor-impl(r0)
            float r4 = androidx.compose.ui.unit.Dp.constructor-impl(r0)
            r5 = 1103101952(0x41c00000, float:24.0)
            r6 = 1103101952(0x41c00000, float:24.0)
            r7 = 0
            r9 = 0
            r10 = 96
            r11 = 0
            java.lang.String r2 = "Outlined.Menu"
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r10, r11)
            r17 = 1065353216(0x3f800000, float:1.0)
            r19 = 1065353216(0x3f800000, float:1.0)
            int r14 = androidx.compose.ui.graphics.vector.VectorKt.getDefaultFillType()
            androidx.compose.ui.graphics.SolidColor r0 = new androidx.compose.ui.graphics.SolidColor
            r16 = r0
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m1074getBlack0d7_KjU()
            r3 = 0
            r0.<init>(r1, r3)
            r18 = 0
            r20 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r21 = r0.m1208getButtKaPHkGw()
            androidx.compose.ui.graphics.StrokeJoin$Companion r0 = androidx.compose.ui.graphics.StrokeJoin.Companion
            int r22 = r0.m1211getBevelLxFBmk8()
            r23 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.ui.graphics.vector.PathBuilder r0 = new androidx.compose.ui.graphics.vector.PathBuilder
            r0.<init>()
            r1 = 1077936128(0x40400000, float:3.0)
            r2 = 1099956224(0x41900000, float:18.0)
            r0.moveTo(r1, r2)
            r0.horizontalLineToRelative(r2)
            r3 = -1073741824(0xffffffffc0000000, float:-2.0)
            r0.verticalLineToRelative(r3)
            r4 = 1098907648(0x41800000, float:16.0)
            r0.lineTo(r1, r4)
            r4 = 1073741824(0x40000000, float:2.0)
            r0.verticalLineToRelative(r4)
            r0.close()
            r5 = 1095761920(0x41500000, float:13.0)
            r0.moveTo(r1, r5)
            r0.horizontalLineToRelative(r2)
            r0.verticalLineToRelative(r3)
            r3 = 1093664768(0x41300000, float:11.0)
            r0.lineTo(r1, r3)
            r0.verticalLineToRelative(r4)
            r0.close()
            r3 = 1086324736(0x40c00000, float:6.0)
            r0.moveTo(r1, r3)
            r0.verticalLineToRelative(r4)
            r0.horizontalLineToRelative(r2)
            r2 = 1101529088(0x41a80000, float:21.0)
            r0.lineTo(r2, r3)
            r0.lineTo(r1, r3)
            r0.close()
            java.util.List r13 = r0.getNodes()
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14336(0x3800, float:2.0089E-41)
            r28 = 0
            java.lang.String r15 = ""
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m1326addPathoIyEayM$default(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.outlined.MenuKt._menu = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.outlined.MenuKt.getMenu(androidx.compose.material.icons.Icons$Outlined):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
