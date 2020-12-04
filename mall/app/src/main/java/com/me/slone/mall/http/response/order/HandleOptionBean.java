package com.me.slone.mall.http.response.order;

/**
 * Author：diankun
 * Time：20-12-4 下午5:19
 * Description:
 */
public class HandleOptionBean {

    /**
     * "handleOption": {
     * "cancel": false,
     * "delete": true,
     * "pay": false,
     * "comment": false,
     * "confirm": false,
     * "refund": false,
     * "rebuy": false,
     * "aftersale": false
     * }
     */
    private boolean cancel;
    private boolean delete;
    private boolean pay;
    private boolean comment;
    private boolean confirm;
    private boolean refund;
    private boolean rebuy;
    private boolean aftersale;

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public void setRebuy(boolean rebuy) {
        this.rebuy = rebuy;
    }

    public void setAftersale(boolean aftersale) {
        this.aftersale = aftersale;
    }

    public boolean isCancel() {
        return cancel;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean isPay() {
        return pay;
    }

    public boolean isComment() {
        return comment;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public boolean isRefund() {
        return refund;
    }

    public boolean isRebuy() {
        return rebuy;
    }

    public boolean isAftersale() {
        return aftersale;
    }
}
