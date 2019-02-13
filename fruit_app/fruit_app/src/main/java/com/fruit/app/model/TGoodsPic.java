package com.fruit.app.model;

import java.util.Date;

public class TGoodsPic {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.goods_id
     *
     * @mbg.generated
     */
    private String goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.pic_url
     *
     * @mbg.generated
     */
    private String picUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.show_order
     *
     * @mbg.generated
     */
    private Byte showOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.is_delete
     *
     * @mbg.generated
     */
    private Boolean isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_goods_pic.data_from
     *
     * @mbg.generated
     */
    private Byte dataFrom;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.id
     *
     * @return the value of t_goods_pic.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.id
     *
     * @param id the value for t_goods_pic.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.goods_id
     *
     * @return the value of t_goods_pic.goods_id
     *
     * @mbg.generated
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.goods_id
     *
     * @param goodsId the value for t_goods_pic.goods_id
     *
     * @mbg.generated
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.pic_url
     *
     * @return the value of t_goods_pic.pic_url
     *
     * @mbg.generated
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.pic_url
     *
     * @param picUrl the value for t_goods_pic.pic_url
     *
     * @mbg.generated
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.show_order
     *
     * @return the value of t_goods_pic.show_order
     *
     * @mbg.generated
     */
    public Byte getShowOrder() {
        return showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.show_order
     *
     * @param showOrder the value for t_goods_pic.show_order
     *
     * @mbg.generated
     */
    public void setShowOrder(Byte showOrder) {
        this.showOrder = showOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.create_date
     *
     * @return the value of t_goods_pic.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.create_date
     *
     * @param createDate the value for t_goods_pic.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.update_date
     *
     * @return the value of t_goods_pic.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.update_date
     *
     * @param updateDate the value for t_goods_pic.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.is_delete
     *
     * @return the value of t_goods_pic.is_delete
     *
     * @mbg.generated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.is_delete
     *
     * @param isDelete the value for t_goods_pic.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_goods_pic.data_from
     *
     * @return the value of t_goods_pic.data_from
     *
     * @mbg.generated
     */
    public Byte getDataFrom() {
        return dataFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_goods_pic.data_from
     *
     * @param dataFrom the value for t_goods_pic.data_from
     *
     * @mbg.generated
     */
    public void setDataFrom(Byte dataFrom) {
        this.dataFrom = dataFrom;
    }
}