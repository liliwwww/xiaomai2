package androidx.compose.material.icons.sharp;

import androidx.compose.ui.graphics.vector.ImageVector;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CheckCircleKt {

    @Nullable
    private static ImageVector _checkCircle;

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
    public static final androidx.compose.ui.graphics.vector.ImageVector getCheckCircle(@org.jetbrains.annotations.NotNull androidx.compose.material.icons.Icons$Sharp r29) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.graphics.vector.ImageVector r0 = androidx.compose.material.icons.sharp.CheckCircleKt._checkCircle
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
            java.lang.String r2 = "Sharp.CheckCircle"
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
            androidx.compose.ui.graphics.vector.PathBuilder r7 = new androidx.compose.ui.graphics.vector.PathBuilder
            r7.<init>()
            r8 = 1094713344(0x41400000, float:12.0)
            r9 = 1073741824(0x40000000, float:2.0)
            r7.moveTo(r8, r9)
            r1 = 1087331369(0x40cf5c29, float:6.48)
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 1087331369(0x40cf5c29, float:6.48)
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = 1094713344(0x41400000, float:12.0)
            r0 = r7
            r0.curveTo(r1, r2, r3, r4, r5, r6)
            r0 = 1083137065(0x408f5c29, float:4.48)
            r1 = 1092616192(0x41200000, float:10.0)
            r7.reflectiveCurveToRelative(r0, r1, r1, r1)
            r0 = -1064346583(0xffffffffc08f5c29, float:-4.48)
            r2 = -1054867456(0xffffffffc1200000, float:-10.0)
            r7.reflectiveCurveToRelative(r1, r0, r1, r2)
            r0 = 1099704566(0x418c28f6, float:17.52)
            r7.reflectiveCurveTo(r0, r9, r8, r9)
            r7.close()
            r0 = 1099431936(0x41880000, float:17.0)
            r7.moveTo(r1, r0)
            r0 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r7.lineToRelative(r0, r0)
            r0 = 1068792545(0x3fb47ae1, float:1.41)
            r2 = -1078691103(0xffffffffbfb47ae1, float:-1.41)
            r7.lineToRelative(r0, r2)
            r0 = 1096988754(0x4162b852, float:14.17)
            r7.lineTo(r1, r0)
            r0 = 1089659208(0x40f2e148, float:7.59)
            r1 = -1057824440(0xffffffffc0f2e148, float:-7.59)
            r7.lineToRelative(r0, r1)
            r0 = 1100480512(0x41980000, float:19.0)
            r1 = 1090519040(0x41000000, float:8.0)
            r7.lineTo(r0, r1)
            r0 = -1055916032(0xffffffffc1100000, float:-9.0)
            r1 = 1091567616(0x41100000, float:9.0)
            r7.lineToRelative(r0, r1)
            r7.close()
            java.util.List r13 = r7.getNodes()
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 14336(0x3800, float:2.0089E-41)
            r28 = 0
            java.lang.String r15 = ""
            androidx.compose.ui.graphics.vector.ImageVector$Builder r0 = androidx.compose.ui.graphics.vector.ImageVector.Builder.m1326addPathoIyEayM$default(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            androidx.compose.ui.graphics.vector.ImageVector r0 = r0.build()
            androidx.compose.material.icons.sharp.CheckCircleKt._checkCircle = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.icons.sharp.CheckCircleKt.getCheckCircle(androidx.compose.material.icons.Icons$Sharp):androidx.compose.ui.graphics.vector.ImageVector");
    }
}
