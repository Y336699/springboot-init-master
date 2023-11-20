package com.yupi.springbootinit.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.support.ExcelTypeEnum;
import javafx.beans.binding.MapExpression;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
public class ExcelUtils {
    public static String excelToCsv(MultipartFile multipartFile){

        /**
         * 读取数据
         */

        List<Map<Integer,String>> list = null;

        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("表格处理错误",e);
        }

        if(CollUtil.isEmpty(list)) {
            return "";
        }

        /**
         * 转换csv
         */

        StringBuilder stringBuilder = new StringBuilder();

        /**
         *读取表头
         */

        LinkedHashMap<Integer,String> headerMap = (LinkedHashMap) list.get(0);

        List<String> headerList = headerMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());

        stringBuilder.append(StringUtils .join(headerList,"")).append("\n");

        /**
         * 读取表中数据
         */
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer,String> dataMap = (LinkedHashMap) list.get(i);
            List<String> dataList = headerMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuilder.append(StringUtils.join(dataList,",")).append("\n");
        }

       return stringBuilder.toString();

    }

}
