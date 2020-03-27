package cn.code.springbootmybatisplus.service.impl;

import cn.code.springbootmybatisplus.entity.Provinces;
import cn.code.springbootmybatisplus.mapper.ProvincesMapper;
import cn.code.springbootmybatisplus.service.ProvincesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 省级（省份直辖市自治区） 服务实现类
 *
 * @author 张灵辉
 * @date 2020/03/27 23:37
 */
@Service
public class ProvincesServiceImpl extends ServiceImpl<ProvincesMapper, Provinces> implements ProvincesService {

}
