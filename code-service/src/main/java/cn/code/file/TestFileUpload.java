package cn.code.file;

import cn.code.entity.Areas;
import cn.code.temp.bean.FileContent;
import cn.code.temp.enums.TempType;
import cn.code.temp.proce.AbstractProcession;
import cn.hutool.core.collection.ListUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * 测试文件上传
 *
 * @author wyx
 * @date 2020/04/15 22:48
 */
@Component
@Slf4j
public class TestFileUpload extends AbstractProcession {

    @Override
    public FileContent customize(InputStream templateInputStream, HttpServletRequest request) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ExcelWriter build = EasyExcel.write(out, Areas.builder().getClass()).needHead(Boolean.FALSE).withTemplate(templateInputStream).build();
        WriteSheet build1 = EasyExcel.writerSheet().build();
        Areas areas = Areas.builder().build();
        areas.setCode(1L);
        ArrayList<Areas> areas1 = ListUtil.toList(areas);
        build.write(areas1, build1).finish();

        //不指定文件名，使用默认文件名
        return new FileContent(out.toByteArray(), null);

    }

    @Override
    public TempType getFileType() {
        return TempType.ADMINISTRATIVE_OFFICE;
    }
}
