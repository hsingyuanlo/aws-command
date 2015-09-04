package com.hsingyuanlo.awsproject.service.s3;

import com.hsingyuanlo.awsproject.service.AwsManager;
import com.hsingyuanlo.awsproject.service.s3.action.S3Action;
import com.hsingyuanlo.awsproject.service.s3.action.S3DownloadAction;

public class S3Manager extends AwsManager {
    
    final static public String ACTION_DOWNLOAD = "download";
    public S3Action mAction = null;
    
    @Override
    protected void doSetAction(String action) {
        if (ACTION_DOWNLOAD.equals(action)) {
            mAction = new S3DownloadAction();
        } else {
            showUsage();
        }
    }

    @Override
    protected void doRunAction(String[] args) {
        mAction.exec(args);
    }
    
    @Override
    protected void showUsage() {
        System.out.println();
        System.out.println(" s3 Command : ");
        System.out.println(" 1. download [options]");
        System.out.println();
    }
}