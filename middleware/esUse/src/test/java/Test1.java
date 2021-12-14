import com.es.ESApplication;
import com.es.dao.ESBaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ESApplication.class)
public class Test1 {

    @Autowired
    private ESBaseDao esBaseDao;

    @Test
    public void test(){
        String result = esBaseDao.getByJsonString("POST", "url",null);
        System.out.println(result);
    }


}
