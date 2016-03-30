package com.kaishengit.test;


import com.kaishengit.util.CodeUtil;
import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.font.FontFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by qiyawei on 2016/3/21.
 */
public class Test {
    public static void main(String[] args) throws Exception {
       // CodeUtil codeUtil = new CodeUtil();
       // int i = CodeUtil.get("code");
        //System.out.println(i);
//        ConfigurableCaptchaService service = new ConfigurableCaptchaService();
//        service.setColorFactory(new SingleColorFactory(new Color(47,85,65)));
//        RandomWordFactory wordFactory = new RandomWordFactory();
//        wordFactory.setCharacters("0123456789zd快捷键few减肥few平均分配文件发给几个文件苹果");
//        wordFactory.setMaxLength(4);
//        wordFactory.setMinLength(4);
//        service.setWordFactory(wordFactory);
//        FontFactory fontFactory = new FontFactory() {
//            @Override
//            public Font getFont(int i) {
//                Font font = new Font("微软雅黑",Font.ITALIC,14);
//                return font;
//            }
//        };
//        service.setFontFactory(fontFactory);
//        service.setFilterFactory(new CurvesRippleFilterFactory(service.getColorFactory()));
//        FileOutputStream outputStream = new FileOutputStream("d:/q.png");
//        EncoderHelper.getChallangeAndWriteImage(service,"png",outputStream);
//        outputStream.flush();
//        outputStream.close();
    }
}
