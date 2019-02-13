package com.fruit.app.model;

import java.math.BigDecimal;
import java.util.Date;

public class TGoodsLocation {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.longitude
     *
     * @mbg.generated
     */
    private BigDecimal longitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.latitude
     *
     * @mbg.generated
     */
    private BigDecimal latitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.position_name
     *
     * @mbg.generated
     */
    private String positionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_location.location
     *
     * @mbg.generated
     */
    private byte[] location;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.id
     *
     * @return the value of t_goods_location.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.id
     *
     * @param id the value for t_goods_location.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.goods_id
     *
     * @return the value of t_goods_location.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.goods_id
     *
     * @param goodsId the value for t_goods_location.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.goods_name
     *
     * @return the value of t_goods_location.goods_name
     *
     * @mbg.generated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.goods_name
     *
     * @param goodsName the value for t_goods_location.goods_name
     *
     * @mbg.generated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.longitude
     *
     * @return the value of t_goods_location.longitude
     *
     * @mbg.generated
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.longitude
     *
     * @param longitude the value for t_goods_location.longitude
     *
     * @mbg.generated
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.latitude
     *
     * @return the value of t_goods_location.latitude
     *
     * @mbg.generated
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.latitude
     *
     * @param latitude the value for t_goods_location.latitude
     *
     * @mbg.generated
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.position_name
     *
     * @return the value of t_goods_location.position_name
     *
     * @mbg.generated
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.position_name
     *
     * @param positionName the value for t_goods_location.position_name
     *
     * @mbg.generated
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.create_date
     *
     * @return the value of t_goods_location.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.create_date
     *
     * @param createDate the value for t_goods_location.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.update_date
     *
     * @return the value of t_goods_location.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.update_date
     *
     * @param updateDate the value for t_goods_location.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_location.location
     *
     * @return the value of t_goods_location.location
     *
     * @mbg.generated
     */
    public byte[] getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_location.location
     *
     * @param location the value for t_goods_location.location
     *
     * @mbg.generated
     */
    public void setLocation(byte[] location) {
        this.location = location;
    }
}