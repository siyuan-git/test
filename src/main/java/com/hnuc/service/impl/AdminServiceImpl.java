package com.hnuc.service.impl;

import com.hnuc.mapper.AdminMapper;
import com.hnuc.pojo.Admin;
import com.hnuc.pojo.AdminExample;
import com.hnuc.service.AdminService;
import com.hnuc.utile.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //在业务逻辑层中，一定会有数据服务层的对象
  @Resource
    private AdminMapper adminMapper;

//    public void setAdminMapper(AdminMapper adminMapper) {
//        this.adminMapper = adminMapper;
//    }

    @Override
    public Admin login(String name, String pwd) {
        //1 根据传入的用户或到DB中查询相应用户对象

         /* 用户输入的账户要与数据库做比对，所有必须有条件判断，而如果有
         *     条件的判断，就一定要创建AdminExample的对象，用来封装条件的
         */
        AdminExample example = new AdminExample();
        /*如何添加条件
        * select * from admin where a_name='name'
        * */
        //拿到用户输入的name
        example.createCriteria().andANameEqualTo(name);
        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size()>0){
            Admin admin = list.get(0);
            //2 如果查询到用户对象，在进行密码比对,注意密码是密文
            /*
            * 数据库中存的是密文
            * 用户输入的是真实密码
            * 所以先将用户的密码加密成密文在做比对
            * */
            String miPwd = MD5Util.getMD5(pwd);
            if(miPwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
