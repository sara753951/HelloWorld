package program.utils;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.CellStyle;
import program.domain.Person;

import java.util.*;

/**
 * Created by yanxinming on 2020/3/11
 */
public class ExcelUtils {

    private static final Integer MAX_ROW_CNT_XLS = (1048576 - 1);


    public static void writeExcel(String filePath, List dataList, Map<String, String> aliasMap) {
        BigExcelWriter writer = ExcelUtil.getBigWriter(filePath, "第1页");
        int sheetNum = (0 == dataList.size() % MAX_ROW_CNT_XLS) ? (dataList.size() / MAX_ROW_CNT_XLS) : (dataList.size() / MAX_ROW_CNT_XLS + 1);

        if (dataList.size() > MAX_ROW_CNT_XLS) {
            for (int i = 0, start = 0, end = MAX_ROW_CNT_XLS; i < sheetNum; i++) {
                List sheetDataList = dataList.subList(start, end);
                String sheetName = (i + 1 < sheetNum) ? "第" + (i + 2) + "页" : null;
                System.out.println("start:" + start + "\tend:" + end + "\tsheetName:" + sheetName);
                start += MAX_ROW_CNT_XLS;
                start = start > dataList.size() ? dataList.size() : start;
                end += MAX_ROW_CNT_XLS;
                end = end > dataList.size() ? dataList.size() : end;
                dealWriter(writer, sheetDataList, sheetName, aliasMap);
            }
        } else {
            dealWriter(writer, dataList, null, aliasMap);
        }

        writer.close();
    }

    private static void dealWriter(BigExcelWriter writer, List sheetDataList, String sheetName, Map<String, String> aliasMap) {

        Iterator<Map.Entry<String, String>> entries = aliasMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            writer.addHeaderAlias(entry.getKey(), entry.getValue());
        }
        writer.setOnlyAlias(true);
        writer.write(sheetDataList, true);
        StyleSet style = writer.getStyleSet();
//        writer.setStyle(style.getCellStyleForNumber(), 2,50);
//        writer.setStyle(style.getCellStyleForNumber(), 3,5);
        CellStyle cellStyle = style.getCellStyle();
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        writer.setStyle(cellStyle, 1,1);
//        writer.setStyle(cellStyle, 3,50);

        if (StringUtils.isNotBlank(sheetName)){
            writer.setSheet(sheetName);
            System.out.println(sheetName);
        }
    }



    public static void main(String[] args) {
        String path = "/Users/yanxinming/Downloads/test_export.xlsx";
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            personList.add(new Person(i, "name-" + i,  i + "%"));
        }

        Map<String, String> aliasMap = new LinkedHashMap<>();
        aliasMap.put("className", "ccc");
        aliasMap.put("idx", "序号");
        aliasMap.put("name", "姓名");

        writeExcel(path, personList, aliasMap);
    }
}



