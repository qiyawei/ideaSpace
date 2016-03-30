import com.sun.org.apache.xpath.internal.SourceTree;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student(1,"tom",54F));
        list.add(new Student(2,"jim",87F));

//        String[] names = new String[]{"tom","jim","rose"};
       JSONArray jsonArray = JSONArray.fromObject(list);
        String json = jsonArray.toString();
        System.out.println(json);












        //Student stu = new Student(1,"tom",52F);
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("name","tom");
//        map.put("age",25);

//        JSONObject jsonObject = JSONObject.fromObject(map);
//        String result = jsonObject.toString();
//        System.out.println(result);
    }

}
