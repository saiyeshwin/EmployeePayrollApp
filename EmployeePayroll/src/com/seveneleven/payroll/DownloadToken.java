package com.seveneleven.payroll;

/*
 * UC4: Download token with expiry
 * Prevents unlimited access to download files
 */

public class DownloadToken {

    private long createdTime;
    private long expiryMillis;

    public DownloadToken() {
        createdTime = System.currentTimeMillis();
        expiryMillis = 60 * 1000; // 1 minute validity
    }

    public boolean isExpired() {
        long now = System.currentTimeMillis();
        return (now - createdTime) > expiryMillis;
    }
}
