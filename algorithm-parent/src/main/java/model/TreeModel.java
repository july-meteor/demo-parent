package model;

/**
 * Created  meteor on 2020/8/25
 *  树模型
 **/
public class TreeModel {

    private Integer id;

    private  Integer parentId;

    private  String lable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
