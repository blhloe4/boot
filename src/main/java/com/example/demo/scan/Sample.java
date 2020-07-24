package com.example.demo.scan;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "21550136";
    public static final String API_KEY = "47O3TApxbPNS9aSv5KuonTS8";
    public static final String SECRET_KEY = "BfN9NksSOXlbLqwXopsYdQH4KlsMEqHs";
    private static ArrayList<Object> scanFiles = new ArrayList<Object>();
    public static void main(String[] args) throws IOException{
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 调用接口
        String path = "C:/Users/loe4/Desktop/png/1/";
        ArrayList<Object> objects = scanFilesWithRecursion(path);
        List<Map<String, String>> list = new ArrayList<>();
        for (Object pathobj:
             objects) {
            String pathh = pathobj.toString();
            JSONObject res = client.basicGeneral(pathh, new HashMap<String, String>());
            if (!res.has("words_result")){
                System.out.println(res.toString());
            }
            JSONArray wordsSesult = res.getJSONArray("words_result");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < wordsSesult.length(); i++) {
                JSONObject jsonObject = (JSONObject) wordsSesult.get(i);
                if(jsonObject.getString("words").contains("秀财")){
                    continue;
                }
                sb.append(jsonObject.get("words")).append("\n");
            }

            Map<String, String> map = new HashMap<>();
            map.put("text", sb.toString());
            map.put("image", pathh);
            list.add(map);
        }
        WordTestDemo wordTestDemo = new WordTestDemo();
        wordTestDemo.exportDoc(path+"loe4.doc",list);
    }

    public static ArrayList<Object> scanFilesWithRecursion(String folderPath) {
        ArrayList<String> dirctorys = new ArrayList<String>();
        File directory = new File(folderPath);
        if(directory.isDirectory()){
            File [] filelist = directory.listFiles();
            for(int i = 0; i < filelist.length; i ++){
                /**如果当前是文件夹，进入递归扫描文件夹**/
                if(filelist[i].isDirectory()){
                    dirctorys.add(filelist[i].getAbsolutePath());
                    /**递归扫描下面的文件夹**/
                    scanFilesWithRecursion(filelist[i].getAbsolutePath());
                }
                /**非文件夹**/
                else{
                    scanFiles.add(filelist[i].getAbsolutePath());
                }
            }
        }
        return scanFiles;
    }
}
