import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/5/1 21:33
 */
public class PageHelperTest {


    @Test
    public void test1()
    {
        //加载spring
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");

        //加载bean
        TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);

        TbItemExample example = new TbItemExample();
        PageHelper.startPage(1,10);
        List<TbItem> list = tbItemMapper.selectByExample(example);
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getTitle());
        }

        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.getTotal());
    }
}
