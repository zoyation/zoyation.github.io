package com.fruit.app.dao;

import com.fruit.app.model.TGoodsInventory;
import com.fruit.app.model.TGoodsInventoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TGoodsInventoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    long countByExample(TGoodsInventoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    int deleteByExample(TGoodsInventoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    int insert(TGoodsInventory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    int insertSelective(TGoodsInventory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    List<TGoodsInventory> selectByExample(TGoodsInventoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TGoodsInventory record, @Param("example") TGoodsInventoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_goods_inventory
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TGoodsInventory record, @Param("example") TGoodsInventoryExample example);
}