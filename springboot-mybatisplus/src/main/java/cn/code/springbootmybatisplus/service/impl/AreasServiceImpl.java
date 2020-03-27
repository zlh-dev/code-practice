package cn.code.springbootmybatisplus.service.impl;

import cn.code.springbootmybatisplus.entity.Areas;
import cn.code.springbootmybatisplus.mapper.AreasMapper;
import cn.code.springbootmybatisplus.service.AreasService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 县级（区县） 服务实现类
 *
 * @author 张灵辉
 * @date 2020/03/27 23:36
 */
@Service
public class AreasServiceImpl extends ServiceImpl<AreasMapper, Areas> implements AreasService {

}
