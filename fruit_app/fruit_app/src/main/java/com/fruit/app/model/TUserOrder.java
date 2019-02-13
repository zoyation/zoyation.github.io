package com.fruit.app.model;

import java.math.BigDecimal;
import java.util.Date;

public class TUserOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.mobile_phone
     *
     * @mbg.generated
     */
    private String mobilePhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.order_no
     *
     * @mbg.generated
     */
    private String orderNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.order_category
     *
     * @mbg.generated
     */
    private Byte orderCategory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.order_type
     *
     * @mbg.generated
     */
    private Byte orderType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.order_status
     *
     * @mbg.generated
     */
    private Byte orderStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.total_pay
     *
     * @mbg.generated
     */
    private BigDecimal totalPay;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.is_delete
     *
     * @mbg.generated
     */
    private Boolean isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.expire_date
     *
     * @mbg.generated
     */
    private Date expireDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_order.data_from
     *
     * @mbg.generated
     */
    private Byte dataFrom;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.id
     *
     * @return the value of t_user_order.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.id
     *
     * @param id the value for t_user_order.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.mobile_phone
     *
     * @return the value of t_user_order.mobile_phone
     *
     * @mbg.generated
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.mobile_phone
     *
     * @param mobilePhone the value for t_user_order.mobile_phone
     *
     * @mbg.generated
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.user_id
     *
     * @return the value of t_user_order.user_id
     *
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.user_id
     *
     * @param userId the value for t_user_order.user_id
     *
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.order_no
     *
     * @return the value of t_user_order.order_no
     *
     * @mbg.generated
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.order_no
     *
     * @param orderNo the value for t_user_order.order_no
     *
     * @mbg.generated
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.order_category
     *
     * @return the value of t_user_order.order_category
     *
     * @mbg.generated
     */
    public Byte getOrderCategory() {
        return orderCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.order_category
     *
     * @param orderCategory the value for t_user_order.order_category
     *
     * @mbg.generated
     */
    public void setOrderCategory(Byte orderCategory) {
        this.orderCategory = orderCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.order_type
     *
     * @return the value of t_user_order.order_type
     *
     * @mbg.generated
     */
    public Byte getOrderType() {
        return orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.order_type
     *
     * @param orderType the value for t_user_order.order_type
     *
     * @mbg.generated
     */
    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.order_status
     *
     * @return the value of t_user_order.order_status
     *
     * @mbg.generated
     */
    public Byte getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.order_status
     *
     * @param orderStatus the value for t_user_order.order_status
     *
     * @mbg.generated
     */
    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.total_pay
     *
     * @return the value of t_user_order.total_pay
     *
     * @mbg.generated
     */
    public BigDecimal getTotalPay() {
        return totalPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.total_pay
     *
     * @param totalPay the value for t_user_order.total_pay
     *
     * @mbg.generated
     */
    public void setTotalPay(BigDecimal totalPay) {
        this.totalPay = totalPay;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.is_delete
     *
     * @return the value of t_user_order.is_delete
     *
     * @mbg.generated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.is_delete
     *
     * @param isDelete the value for t_user_order.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.create_date
     *
     * @return the value of t_user_order.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.create_date
     *
     * @param createDate the value for t_user_order.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.expire_date
     *
     * @return the value of t_user_order.expire_date
     *
     * @mbg.generated
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.expire_date
     *
     * @param expireDate the value for t_user_order.expire_date
     *
     * @mbg.generated
     */
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.update_date
     *
     * @return the value of t_user_order.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.update_date
     *
     * @param updateDate the value for t_user_order.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_order.data_from
     *
     * @return the value of t_user_order.data_from
     *
     * @mbg.generated
     */
    public Byte getDataFrom() {
        return dataFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_order.data_from
     *
     * @param dataFrom the value for t_user_order.data_from
     *
     * @mbg.generated
     */
    public void setDataFrom(Byte dataFrom) {
        this.dataFrom = dataFrom;
    }
}