package com.tencent.liteav.demo;

import android.content.Context;

import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveBaseListener;


public class TXCSDKService {
    private static final String TAG        = "TXCSDKService";
    // Please refer to the official website guide for how to obtain the
    // license: https://cloud.tencent.com/document/product/454/34750
    // 如何获取License? 请参考官网指引 https://cloud.tencent.com/document/product/454/34750
    private static final String licenceUrl = "https://license.vod2.myqcloud.com/license/v2/1257745764_1/v_cube.license";
    private static final String licenseKey = "8d869400c2dd96835bda7cd137d265ce";


    private TXCSDKService() {
    }

    /**
     * Initialize Tencent Cloud related SDKs.
     * During the SDK initialization process, sensitive information such as the mobile phone model may be read,
     * which needs to be obtained after the user agrees to the privacy policy.
     *
     * 初始化腾讯云相关sdk。
     * SDK 初始化过程中可能会读取手机型号等敏感信息，需要在用户同意隐私政策后，才能获取。
     *
     * @param appContext The application context.
     */
    public static void init(Context appContext) {
        TXLiveBase.getInstance().setLicence(appContext, licenceUrl, licenseKey);
        TXLiveBase.setListener(new TXLiveBaseListener() {
            @Override
            public void onUpdateNetworkTime(int errCode, String errMsg) {
                if (errCode != 0) {
                    TXLiveBase.updateNetworkTime();
                }
            }
        });
        TXLiveBase.updateNetworkTime();
    }
}
