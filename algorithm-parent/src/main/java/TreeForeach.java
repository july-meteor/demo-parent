import model.TreeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  meteor on 2020/8/25
 **/
public class TreeForeach {

    public static void main(String[] args) {

        List<TreeModel> treeList = new ArrayList<>();

        TreeModel rootNode = new TreeModel();
        rootNode.setId(0);
        rootNode.setLable("根");
        rootNode.setParentId(-1);
        treeList.add(rootNode);

        TreeModel oneNode = new TreeModel();
        oneNode.setParentId(0);
        oneNode.setId(1);
        oneNode.setLable("第一个节点");

        TreeModel twoNode = new TreeModel();
        twoNode.setId(2);
        twoNode.setLable("第二个节点");
        twoNode.setParentId(0);

        TreeModel threeNode = new TreeModel();
        threeNode.setId(3);
        threeNode.setLable("第三个节点");
        threeNode.setParentId(1);
    }








}
