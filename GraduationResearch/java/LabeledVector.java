package GraduationResearch.java

import java.util.Map;

/** 個々の学習データ（特徴ベクトル＋正解ラベル）を表すクラス */

public class LabeledVector {
    /** 特徴ベクトル */
    public Map<Integer, Double> featureVector;
    /** 正解ラベル */
    public int label;
}
