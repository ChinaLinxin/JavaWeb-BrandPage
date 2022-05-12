package com.linxin.service.impl;

import com.linxin.mapper.BrandMapper;
import com.linxin.pojo.Brand;
import com.linxin.pojo.PageBean;
import com.linxin.service.BrandService;
import com.linxin.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 刘林鑫
 * @version 1.0
 */
public class BrandServiceImpl implements BrandService {

    //1、创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4.调用方法
        List<Brand> brands = mapper.selectAll();

        //5、释放资源
        sqlSession.close();

        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.addBrand(brand);
        sqlSession.commit(); // 提交事务

        //5、释放资源
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteById(id);
        sqlSession.commit(); // 提交事务

        //5、释放资源
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        mapper.deleteByIds(ids);
        sqlSession.commit(); // 提交事务
        //5、释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4、计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //5、查询当页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        /*for (Brand row : rows) {
            System.out.println(row);
        }*/
        //6、查询总记录数
        int totalCount = mapper.selectTotalCount();

        //7、封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //8、释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //4、计算开始索引
        int begin = (currentPage - 1) * pageSize;
        //计算查询条目数
        int size = pageSize;

        //处理brand条件，根据模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%"+companyName+"%");
        }
        //5、查询当页数据
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);

        //6、查询总记录数
        int totalCount = mapper.selectTotalCountByCondition(brand);

        //7、封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        //8、释放资源
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void updateBrand(Brand brand) {
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4、调用方法
        mapper.updateBrand(brand);
        sqlSession.commit();//提交事务
        //5、释放资源
        sqlSession.close();
    }
}
