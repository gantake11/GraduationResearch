package GraduationResearch.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 教師あり学習用データセット */

public class LearningDataSet {
    /** データセット本体 */
    public List<LabeledVector> labeledVectorList;

    /** ファイルからデータセットを読み込む */
    public static LearningDataSet readFromFile(String fileName) {
        LearningDataSet dataSet = new LearningDataSet();
        dataSet.labeledVectorList = new ArrayList<LabeledVector>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int label = Integer.parseInt(br.readLine());
            int number = 0;
            String line;
            while (true) {
                LabeledVector lv = new LabeledVector();
                //読み取った特徴があるか探すメソッドを別のクラスに作り、それを呼ぶ
                //String型のArrayListにレビュー全文入れて、それを引数にする
                ArrayList<String> reviewLine = new ArrayList<String>;
                while(true){
                    lv.label = number;
                    line =  br.readLine();
                    try {
                        number = Integer.parseInt(line);
                        continue;
                    } catch (NumberFormatException e) {
                        reviewLine.add(line);
                    }
                }
                
                lv.featureVector = extractFeatures(reviewLine);
                
                //可能であればmapを返して直接lvのmapに入れる
                //エラーが出たらこの中で特徴量を測る
                dataSet.labeledVectorList.add(lv);
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return dataSet;
    }
}
