package com.linxin.service;

import com.linxin.pojo.Brand;
import com.linxin.pojo.PageBean;

import java.util.List;

/**
 * @author 刘林鑫
 * @version 1.0
 */
public interface BrandService {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 删除品牌
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize,Brand brand);
    /**
     * 修改品牌数据
     * @param brand
     */
    void updateBrand(Brand brand);
}
