package com.linxin.mapper;

import com.linxin.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     *
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * 新增品牌
     */
    @Insert("insert into tb_brand(id, brand_name, company_name, ordered, description, status) " +
            "values(null,#{brandName},#{companyName},#{ordered}," +
            "#{description},#{status})")
    void addBrand(Brand brand);

    /**
     * 删除品牌
     *
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id};")
    void deleteById(int id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     *
     * @param begin 当前页码
     * @param size  每页显示条数
     * @return
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     *
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * 修改品牌数据
     * @param brand
     */
    @Update("update tb_brand set id = #{id},brand_name=#{brandName}," +
            "company_name=#{companyName}, ordered=#{ordered}, description=#{description}," +
            "status=#{status} where id = #{id} ;")
    @ResultMap("brandResultMap")
    void updateBrand(Brand brand);


    /**
     * 分页条件查询
     *
     * @param begin 当前页码
     * @param size  每页显示条数
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size,
                                         @Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     *
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

}
