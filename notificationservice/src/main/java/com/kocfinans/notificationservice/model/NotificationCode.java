package com.kocfinans.notificationservice.model;

public enum NotificationCode {

    SMS_LOAN_APPLICATION_APPROVE("SMS_LOAN_APPLICATION_APPROVE"),
    SMS_LOAN_APPLICATION_DISAPPROVE("SMS_LOAN_APPLICATION_DISAPPROVE"),
    EMAIL_LOAN_APPLICATION_APPROVE("EMAIL_LOAN_APPLICATION_APPROVE"),
    EMAIL_LOAN_APPLICATION_DISAPPROVE("EMAIL_LOAN_APPLICATION_DISAPPROVE");

    NotificationCode(String code) {
        setTemplateCode(code);
    }

    private String templateCode;

    public String getTemplateCode() {
        return this.templateCode;
    }

    private void setTemplateCode(String code) {
        this.templateCode = code;
    }

}
