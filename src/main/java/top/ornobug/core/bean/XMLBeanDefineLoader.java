package top.ornobug.core.bean;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import top.ornobug.common.ClassUtil;
import top.ornobug.common.ReflectionUtil;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XMLBeanDefineLoader extends DefaultHandler {

    public static void init() {
        XMLBeanDefineLoader spus = new XMLBeanDefineLoader();
        //实例化一个SAX解析工厂
        SAXParserFactory spf = SAXParserFactory.newInstance();
        //通过工厂生成一个SAX解析器SAXParser
        SAXParser saxParser = null;
        try {
            saxParser = spf.newSAXParser();
            //解析xml文件
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            saxParser.parse(new InputSource(path + AutumnConfig.getBeanDefineLocation()), spus);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        // TODO Auto-generated method stub
        //系统自动调用，当开始解析xml文件时(遇到树节点)，就会被自动调用
        //System.out.println("准备开始解析对象....");
    }

    @Override
    public void endDocument() {
        // TODO Auto-generated method stub
        //系统自动调用，当结束解析xml文件时(遇到树结束节点)，就会被自动调用
        //System.out.println("对象解析结束....");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) {
        if ("bean".equals(qName)) {
            System.out.println(attributes.getValue("id") + ":" + attributes.getValue("class"));
            String beanName = attributes.getValue("id");
            Class<?> cls = ClassUtil.loadClass(attributes.getValue("class"), true);
            if (!BeanHolder.getClassBeanMap().containsKey(cls)) {
                // class容器中不存在，就放入容器
                Object bean = ReflectionUtil.newInstance(cls);
                BeanHolder.putClassBeanMap(cls, bean);
                BeanHolder.putNameBeanMap(beanName, bean);
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // TODO Auto-generated method stub
        //系统自动调用
        //System.out.println(uri+"--- "+localName+" --- "+qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        // TODO Auto-generated method stub
        //系统自动调用
        //System.out.println(new String(ch));
    }

}
