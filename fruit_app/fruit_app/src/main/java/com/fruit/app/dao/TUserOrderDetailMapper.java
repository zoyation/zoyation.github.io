package com.fruit.app.dao;

import com.fruit.app.model.TUserOrderDetail;
import com.fruit.app.model.TUserOrderDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserOrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    long countByExample(TUserOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    int deleteByExample(TUserOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    int insert(TUserOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    int insertSelective(TUserOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    List<TUserOrderDetail> selectByExample(TUserOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TUserOrderDetail record, @Param("example") TUserOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_order_detail
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TUserOrderDetail record, @Param("example") TUserOrderDetailExample example);
}