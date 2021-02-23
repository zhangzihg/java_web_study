package dom4jtest;

import com.pojo.Book;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class Testdom4j {
    @Test
    public void test1() throws Exception{

        SAXReader saxReader = new SAXReader();
        //读取xml数据，返回一个document对象
        Document read = saxReader.read("src/books.xml");
        //先获取根元素
        Element rootElement = read.getRootElement();
        //通过标签名获取book标签,里面的都是Element类型的数据
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
//            将它将当前元素转换成为String 对象book.asXML()
//            System.out.println(book.asXML());

            //获取xml标签中的内容
            Element name = book.element("name");
            String nameXml = name.getText();
            String price = book.element("price").getText();
            String author = book.element("author").getText();

            //获取属性值
            String sn = book.attribute("sn").getText();
            Book book1 = new Book(sn, nameXml, Double.parseDouble(price));
            System.out.println(book1);
        }
    }
}
