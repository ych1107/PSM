package com.ujiuye.usual.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.usual.bean.Baoxiao;
import com.ujiuye.usual.bean.BaoxiaoExample;
import com.ujiuye.usual.dao.BaoxiaoMapper;
import com.ujiuye.usual.service.BaoxiaoService;
import com.ujiuye.utils.PageUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: PSM
 * @description:
 * @author: Mr.C
 * @create: 2019-12-03 16:32
 **/
@Service
public class BaoxiaoServiceImpl implements BaoxiaoService {

    @Resource
    private BaoxiaoMapper baoxiaoMapper;
    @Override
    public void saveInfo(Baoxiao baoxiao) {
        baoxiao.setBxid(UUID.randomUUID().toString().replaceAll("-", ""));
        baoxiaoMapper.insert(baoxiao);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PageInfo<Baoxiao> getAll(Map<String, Object> map1,String pageNum) {
        int pageNo = 1;
        if (pageNum!=null){
            try {
                pageNo = Integer.parseInt(pageNum);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        BaoxiaoExample example = new BaoxiaoExample();
        BaoxiaoExample.Criteria criteria = example.createCriteria();
        String s =(String) map1.get("cid");
        if(s!=null){
            int cid = Integer.parseInt(s);

            criteria.andBxstatusEqualTo(cid);
        }
        PageHelper.startPage(pageNo, PageUtils.PAGE_SIZE);
        List<Baoxiao> baoxiaos = baoxiaoMapper.selectByExample(example);
        PageInfo<Baoxiao> pageInfo = new PageInfo<Baoxiao>(baoxiaos,PageUtils.NAVIGATE_PAGES);
        return pageInfo;
    }
}
