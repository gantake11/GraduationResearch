package GraduationResearch.java

/** レビューから特徴量を求める */

public class FeatureExtractor{
    //前半5つポジティブな言葉、後半5つネガティブな言葉
    ArrayList<String> positiveNegativeWords = new ArrayList<>(Arrays.asList("好き", "最高", "面白かった", "良い", "感動", "面白くなかった", "残念", "つまらない", "無理", "無駄")); 

    LabeledVector lv = new LabeledVector();

    public static Map<Integer, Double> extractFeatures(ArrayList<String> als){
        ArrayList<String> al = als;
        boolean[] flags = new boolean[10];
        for(String line : al){
            for(int i=0;i<10;i++){
                if(!(flags[i])){
                    if(line.contains(positiveNegativeWords.get(i))){
                        lv.featureVector.put(i, 1);
                    }
                }
            }
        }
        return lv.featureVector;
    }
}