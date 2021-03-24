package sample;


import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.io.File;
import java.io.IOException;


public class MyTreeView extends TreeView<File> {
    public StackPane rootPane = new StackPane();

    MyTreeView() throws IOException {
        setPrefSize(311, 718);
        setTreeView();
    }

    public void setTreeView() throws IOException {

        MyFlowPane myFlowPane = new MyFlowPane();

        ImageView folderIcon = new ImageView();
        folderIcon.setPreserveRatio(true);
        folderIcon.setFitWidth(16);
        folderIcon.setFitHeight(16);

        String path1 = "/";
        File file = new File(path1);
        File[] items = file.listFiles();

        TreeItem<File> mainTreeItem = new TreeItem<>(file);

        MyTreeViewController myTreeViewController = new MyTreeViewController();

        for (File item : items) {

            if(item.isDirectory()) {
                TreeItem<File> treeItem = new TreeItem<>(item);
                mainTreeItem.getChildren().add(treeItem);
                addItems(treeItem, 0);
            }
        }


        TreeView<File> treeView = new TreeView<>(mainTreeItem);
        rootPane.getChildren().add(treeView);

        treeView.setRoot(mainTreeItem);
        treeView.setShowRoot(false);


        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String path = newValue.getValue().getAbsolutePath();

                myTreeViewController.initEnterFolder(path);
            try {
                addItems(newValue, 0);
                myFlowPane.getPicture(newValue);


            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        treeView.setCellFactory(new Callback<>() {
            @Override
            public TreeCell<File> call(TreeView<File> param) {
                return new TreeCell<>() {
                    @Override
                    protected void updateItem(File item, boolean empty) {

                        if (!empty) {
                            super.updateItem(item, false);
                            HBox hBox = new HBox();
                            Label label = new Label(isListRoots(item));
                            this.setGraphic(hBox);
                            this.setStyle("-fx-border-color: rgb(244,244,244)");
                            hBox.getChildren().add(label);//把label加到hBox面板中

                        } else {
                            this.setGraphic(null);
                        }
                    }
                };
            }
        });



    }

    /*
    注意这里不能将文件夹全部放入到File[],否者内存会爆
     */

    public void addItems(TreeItem<File> in, int flag) throws IOException {
        File[] fileList = in.getValue().listFiles();
        if (fileList != null) {
            if (flag == 0) {
                //remove(from,to) 移除[from,to)之间的元素,from是包含,to是不包含的,注意与remove监听事件返回的from和to都是相同的
                //这里移除是为了之后我们还会将这个节点加进去，否者会重复
                //System.out.println(in.getChildren().size());
                in.getChildren().remove(0, in.getChildren().size());
            }

            if (fileList.length > 0) {
                for (File file : fileList) {
                    if (file.isDirectory() & !file.isHidden()) {
                        TreeItem<File> newItem = new TreeItem<>(file);
                        if (flag < 1) {
                            //flag小与1后我们就一共调用两次addItems函数，就层数只有2
                            addItems(newItem, flag + 1);
                        }
                        in.getChildren().add(newItem);
                    }
                }
            }





        }
    }

    public String isListRoots(File item) {
        File[] rootlist = File.listRoots();
        for (File isListRoots : rootlist) {
            if (item.toString().equals(isListRoots.toString())) {
                return item.toString();
            }
        }
        return item.getName();
    }




}

