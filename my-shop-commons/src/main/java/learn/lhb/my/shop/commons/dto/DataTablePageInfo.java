package learn.lhb.my.shop.commons.dto;

import learn.lhb.my.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * jQuery 插件 DataTables 返回的 ajax数据封装
 * 分页数据传输对象
 *
 * @author 梁鸿斌
 * @date 2020/2/17.
 * @time 22:03
 */
// TODO 做成工具类的笔记，到时可以照着封装一个类似的
    // TODO 这个类的 DataTablePageInfo<T> 用法做成笔记到java的集合里去，解释： 用于接受不知道类型的List<>集合，泛行
    // TODO 这里描述的是泛行的类型，即必须继承BaseEntity里面的属性，此时传的就一定是实体类了
public class DataTablePageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

