package androidx.compose.ui.tooling;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PreviewActivity extends ComponentActivity {
    public static final int $stable = 0;

    @NotNull
    private final String TAG = "PreviewActivity";

    /* JADX WARN: Multi-variable type inference failed */
    private final void setComposableContent(String str) {
        Log.d(this.TAG, "PreviewActivity has composable " + str);
        final String substringBeforeLast$default = StringsKt.substringBeforeLast$default(str, '.', (String) null, 2, (Object) null);
        final String substringAfterLast$default = StringsKt.substringAfterLast$default(str, '.', (String) null, 2, (Object) null);
        String stringExtra = getIntent().getStringExtra("parameterProviderClassName");
        if (stringExtra != null) {
            setParameterizedContent(substringBeforeLast$default, substringAfterLast$default, stringExtra);
            return;
        }
        Log.d(this.TAG, "Previewing '" + substringAfterLast$default + "' without a parameter provider.");
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-161032931, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.tooling.PreviewActivity$setComposableContent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer, int i) {
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-161032931, i, -1, "androidx.compose.ui.tooling.PreviewActivity.setComposableContent.<anonymous> (PreviewActivity.kt:72)");
                }
                ComposableInvoker.INSTANCE.invokeComposable(substringBeforeLast$default, substringAfterLast$default, composer, new Object[0]);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setParameterizedContent(String str, String str2, String str3) {
        Log.d(this.TAG, "Previewing '" + str2 + "' with parameter provider: '" + str3 + '\'');
        Object[] previewProviderParameters = PreviewUtilsKt.getPreviewProviderParameters(PreviewUtilsKt.asPreviewProviderClass(str3), getIntent().getIntExtra("parameterProviderIndex", -1));
        if (previewProviderParameters.length > 1) {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1735847170, true, new setParameterizedContent.1(previewProviderParameters, str, str2)), 1, null);
        } else {
            ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(1507674311, true, new setParameterizedContent.2(str, str2, previewProviderParameters)), 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        if ((getApplicationInfo().flags & 2) == 0) {
            Log.d(this.TAG, "Application is not debuggable. Compose Preview not allowed.");
            finish();
            return;
        }
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("composable")) == null) {
            return;
        }
        setComposableContent(stringExtra);
    }
}
