package cn.code.springbootmybatisplus.service.impl;

import cn.code.springbootmybatisplus.entity.Cities;
import cn.code.springbootmybatisplus.mapper.CitiesMapper;
import cn.code.springbootmybatisplus.service.CitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 地级（城市） 服务实现类
 *
 * @author 张灵辉
 * @date 2020/03/27 23:37
 */
@Service
public class CitiesServiceImpl extends ServiceImpl<CitiesMapper, Cities> implements CitiesService {

}
