package program.NLP;

import program.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by yanxinming on 2018/12/26
 * 计算文档后缀的idf
 */
public class TFIDF {

    private static String corpusPath1 = "/Users/yanxinming/learning/一些语料/position_51_clean.txt";
//    private static String corpusPath2 = "/Users/yanxinming/learning/一些语料/Company-Names-Corpus/Organization-Names-Corpus（110W）.txt";
    private static String outputPath = "/Users/yanxinming/learning/一些语料/position_51_clean-suffix-2.csv";
    private static int endWordLen = 2;
    private static HashSet<String> docs = new HashSet<String>();
    private static int docCount = 0;
    private static HashMap<String, Integer> suffixsFrequency = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {


        load();
        computeIDFtoWrite();

    }

    private static void computeIDFtoWrite() throws IOException {
        OutputStream outputStream = FileUtil.openFiletoWrite(outputPath);
        FileUtil.writeStringToFile(outputStream, "后缀,频率,idf\n", "gb2312");
        Iterator iterator = suffixsFrequency.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String suffix = entry.getKey().toString();
            int fre = suffixsFrequency.get(suffix);
            double idf = Math.log10((double) docCount / (fre + 1));
            FileUtil.writeStringToFile(outputStream, suffix + "," + fre + "," + idf + "\n", "gb2312");
        }
        FileUtil.closeFile(outputStream);
    }

    private static void load() {
        ArrayList<String> corpusList = FileUtil.readLines(new File(corpusPath1), "utf-8");
//        corpusList.addAll(FileUtil.readLines(new File(corpusPath2), "utf-8"));
        for (String str : corpusList) {
            if (str.length() < endWordLen) {
                continue;
            }
            String suffix = str.substring(str.length() - endWordLen);
            suffixsFrequency.put(suffix, suffixsFrequency.keySet().contains(suffix) ? suffixsFrequency.get(suffix) + 1 : 1);
            docs.add(str);
        }
        docCount = docs.size();
        System.out.println(docCount);
    }
}
