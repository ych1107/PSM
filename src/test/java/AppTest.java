import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-11-26 17:04
 **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {

    @Autowired
    private DruidDataSource druidDataSource;
   /* @Test
    public void test01() throws  Exception{

        Workbook wb = new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("第一个sheet");
        Row row = sheet1.createRow(0);
        Cell cell0 = row.createCell(0);
        Cell cell1 = row.createCell(1);
        Cell cell2 = row.createCell(2);
        Cell cell3 = row.createCell(3);
        cell0.setCellValue("序号");
        cell1.setCellValue("姓名");
        cell2.setCellValue("年纪");
        cell3.setCellValue("性别");
        for (int i = 0; i <2 ; i++) {
            Row row1 = sheet1.createRow(i+1);
            Cell[] cells = new HSSFCell[5];
            for(int j=0;j<5;j++){
                cells[j] = row1.createCell(j);
            }
            cells[0].setCellValue(1);
            cells[1].setCellValue("cy");
            cells[2].setCellValue(18);
            cells[3].setCellValue("nan");
            cells[4].setCellValue("赚钱");
        }
       wb.write(new FileOutputStream(new File("E://a.xls")));

    }*/
    @Test
    public void test2(){
        String s = "2123";
        String substring = s.substring(2);
        System.out.println(substring);
    }
    @Test
    public void test3(){
        int sum = 1;
        Integer aa = new Integer(45);
        System.out.println(Integer.SIZE);

        int n=0;
        for (int i =  1; i < 10; i++) {
            sum=(sum+1)*2;

        }
        System.out.println(sum);
    }
}
