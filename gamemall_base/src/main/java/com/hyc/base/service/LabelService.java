package com.hyc.base.service;

import com.hyc.base.dao.LabelDao;
import com.hyc.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.SnowflakeIdWorker;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;

    public List<Label> findAll(){
        return  labelDao.findAll();
    }
/*分两步*/
    public Label findById(String id){
        return labelDao.findById(id).get();
    }
    public void save(Label label){
        label.setId(snowflakeIdWorker.nextId()+"");
        labelDao.save(label);
    }
    public void update(Label label){
        labelDao.save(label);
    }
    public void deleteById(String id){

        labelDao.deleteById(id);
    }
    public List<Label> findSearch(Label label){
       return labelDao.findAll(new Specification<Label>() {
           /*
           * root 根对象，也就是把条件封装到哪个对象
           * query 封装的都是查询关键字，比如group 不要order by
           *cb      用来封装条件对象
           *    如果直接返回null，表示不需要任何条件
           * */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /*模糊查询
                * SQL=“%小明%”
                * */
                //new一个List集合。来存放所有的条件
                List<Predicate> list =new ArrayList<>();
//                查询label名字
                if (label.getLabelname()!=null&&!"".equals(label.getLabelname())) {
                  Predicate predicate=  criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
//                查询状态 state=1,
                if (label.getState()!=null&&!"".equals(label.getState())) {
                    Predicate predicate=  criteriaBuilder.like(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                //new一个数组作为最终返回值条件
                Predicate[] parr =new Predicate[list.size()];
                //把List直接转成数组，因为Predicate[]需要一个数组
                parr=list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        });
    }
}
