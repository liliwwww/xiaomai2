package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorResources_androidKt {
    @NotNull
    public static final ImageVectorCache.ImageVectorEntry loadVectorResourceInner(@Nullable Resources.Theme theme, @NotNull Resources resources, @NotNull XmlResourceParser xmlResourceParser, int i) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(xmlResourceParser, "parser");
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        AndroidVectorParser androidVectorParser = new AndroidVectorParser(xmlResourceParser, 0, 2, null);
        Intrinsics.checkNotNullExpressionValue(asAttributeSet, "attrs");
        ImageVector.Builder createVectorImageBuilder = XmlVectorParser_androidKt.createVectorImageBuilder(androidVectorParser, resources, theme, asAttributeSet);
        int i2 = 0;
        while (!XmlVectorParser_androidKt.isAtEnd(xmlResourceParser)) {
            i2 = XmlVectorParser_androidKt.parseCurrentVectorNode(androidVectorParser, resources, asAttributeSet, theme, createVectorImageBuilder, i2);
            xmlResourceParser.next();
        }
        return new ImageVectorCache.ImageVectorEntry(createVectorImageBuilder.build(), i);
    }

    public static /* synthetic */ ImageVectorCache.ImageVectorEntry loadVectorResourceInner$default(Resources.Theme theme, Resources resources, XmlResourceParser xmlResourceParser, int i, int i2, Object obj) throws XmlPullParserException {
        if ((i2 & 1) != 0) {
            theme = null;
        }
        return loadVectorResourceInner(theme, resources, xmlResourceParser, i);
    }

    @Composable
    @NotNull
    public static final ImageVector vectorResource(@NotNull ImageVector.Companion companion, @DrawableRes int i, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(44534090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(44534090, i2, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:47)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Resources resources = Resources_androidKt.resources(composer, 0);
        Resources.Theme theme = context.getTheme();
        Object[] objArr = {Integer.valueOf(i), resources, theme, resources.getConfiguration()};
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (int i3 = 0; i3 < 4; i3++) {
            z |= composer.changed(objArr[i3]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = vectorResource(companion, theme, resources, i);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ImageVector imageVector = (ImageVector) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageVector;
    }

    public static /* synthetic */ ImageVector vectorResource$default(ImageVector.Companion companion, Resources.Theme theme, Resources resources, int i, int i2, Object obj) throws XmlPullParserException {
        if ((i2 & 1) != 0) {
            theme = null;
        }
        return vectorResource(companion, theme, resources, i);
    }

    @NotNull
    public static final ImageVector vectorResource(@NotNull ImageVector.Companion companion, @Nullable Resources.Theme theme, @NotNull Resources resources, int i) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(resources, "res");
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        XmlResourceParser xml = resources.getXml(i);
        Intrinsics.checkNotNullExpressionValue(xml, "vectorResource$lambda$1");
        XmlVectorParser_androidKt.seekToStartTag(xml);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(xml, "res.getXml(resId).apply { seekToStartTag() }");
        return loadVectorResourceInner(theme, resources, xml, typedValue.changingConfigurations).getImageVector();
    }
}
