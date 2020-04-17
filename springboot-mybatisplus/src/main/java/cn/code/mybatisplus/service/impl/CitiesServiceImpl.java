package cn.code.mybatisplus.service.impl;

import cn.code.mybatisplus.entity.Cities;
import cn.code.mybatisplus.mapper.CitiesMapper;
import cn.code.mybatisplus.service.CitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 地级（城市） 服务实现类
 *
 * @author zlh-dev
 * @date 2020/03/27 23:37
 */
@Service
public class CitiesServiceImpl extends ServiceImpl<CitiesMapper, Cities> implements CitiesService {

}
