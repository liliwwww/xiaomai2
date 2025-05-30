package com.ali.mobisecenhance.p009ld;

import com.j2c.enhance.SoLoad992979061;

/* loaded from: classes.dex */
public class StubApplication extends BridgeAppMini {
    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", StubApplication.class);
    }

    @Override // com.ali.mobisecenhance.p009ld.BridgeAppMini
    protected native String getConfig();

    @Override // com.ali.mobisecenhance.p009ld.BridgeAppMini
    protected native String getDigestHash();

    @Override // com.ali.mobisecenhance.p009ld.BridgeAppMini
    protected native String getProviders();
}
