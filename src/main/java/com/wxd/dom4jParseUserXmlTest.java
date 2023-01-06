package com.wxd;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @Author:rof
 * @Date:2023/1/6 - 01 - 06 - 18:21
 * @Description:com.wxd
 * @version: 1.0
 */
public class dom4jParseUserXmlTest {
    public static void main(String[] args) {
        //创建解析器对象
        SAXReader saxReader = new SAXReader();
        //使用解析器对象获取XML文档生成doucument对象
        try {
            Document document = saxReader.read(dom4jParseUserXmlTest.class.getClassLoader().getResource("user.xml"));
            Element rootElement = document.getRootElement();
            System.out.println("1.-------->user.xml文件的根节点的名字是"+rootElement.getName());

            System.out.println("2.-------->获取根标签的子标签列表");
            List<Element> usersSubElement = rootElement.elements();
            for (Element userElement : usersSubElement) {
                System.out.println("users标签的子标签的名字是"+userElement.getName());
                System.out.println("users标签的子标签的id属性值是"+userElement.attributeValue("id"));
                System.out.println("users标签的子标签的id属性值是"+userElement.attributeValue("country"));

                System.out.println("3.-------->获取user的子标签列表");
                List<Element> userSubElementList = userElement.elements();
                for (Element userSubElement : userSubElementList){
                    System.out.println("user标签下的子标签名字是"+userSubElement.getName());
                    System.out.println("user标签下的子标签文本是"+userSubElement.getText());
                }
            }

            //获取users标签的第一个user标签
            Element firstUserElement = rootElement.element("user");
            //第一个user标签的子标签password的文本
            String password = firstUserElement.elementText("password");
            System.out.println("第一个user标签的子标签password的文本"+password);


        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}
