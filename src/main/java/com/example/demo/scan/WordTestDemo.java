package com.example.demo.scan;


import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WordTestDemo {

    public String exportDoc(String path, List<Map<String,String>>list) throws DocumentException, IOException {

        // 设置纸张大小

        Document document = new Document(PageSize.A4);

        // 建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
        // ByteArrayOutputStream baos = new ByteArrayOutputStream();

        File file = new File(path);

        RtfWriter2.getInstance(document, new FileOutputStream(file));

        document.open();

        // 设置中文字体

        BaseFont bfChinese = BaseFont.createFont(BaseFont.HELVETICA,
                BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        for (Map<String,String> map : list) {
            Image img = Image.getInstance(map.get("image"));

            img.setAbsolutePosition(0, 0);

            img.setAlignment(Image.LEFT);// 设置图片显示位置

            //
            // img.scaleAbsolute(60, 60);// 直接设定显示尺寸
            //
            img.scalePercent(25);//表示显示的大小为原尺寸的50%
            //
            // // img.scalePercent(25, 12);//图像高宽的显示比例
            //
            // // img.setRotation(30);//图像旋转一定角度
            //
            document.add(img);
            System.out.println("完成第图片插入");

            String contextString = map.get("text");

            Paragraph context = new Paragraph(contextString);

            // 正文格式左对齐

            context.setAlignment(Element.ALIGN_LEFT);

            // context.setFont(contextFont);

            // 离上一段落（标题）空的行数

            context.setSpacingBefore(5);

            // 设置第一行空的列数

            context.setFirstLineIndent(20);

            document.add(context);
            System.out.println("完成文字插入");
            //
            // // 利用类FontFactory结合Font和Color可以设置各种各样字体样式
            //
            // Paragraph underline = new Paragraph("下划线的实现", FontFactory.getFont(
            // FontFactory.HELVETICA_BOLDOBLIQUE, 18, Font.UNDERLINE,
            // new Color(0, 0, 255)));
            //
            // document.add(underline);
            //

            // // 添加图片 Image.getInstance即可以放路径又可以放二进制字节流
            //



        }
        document.close();

        // 得到输入流
        // wordFile = new ByteArrayInputStream(baos.toByteArray());
        // baos.close();
        return "";

    }
}