package sample;



import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;


public class ImageMenuItem {
    private final ContextMenu contextMenu = new ContextMenu();//菜单项组


    ImageMenuItem(String path){

        MenuItem delete = new MenuItem("删除");
        MenuItem copy = new MenuItem("复制");
        MenuItem rename = new MenuItem("重命名");

        delete.setStyle("-fx-text-fill:RED");

        delete.setOnAction(actionEvent -> deleteImage(path));

        copy.setOnAction(actionEvent -> copyImage(path));

        rename.setOnAction(actionEvent -> renameImage(path));

        contextMenu.getItems().addAll(copy,rename,delete);
        contextMenu.setStyle("-fx-background-color:rgb(255, 255, 255, .85)");    //透明设置


    }
    public ContextMenu getContextMenu(){
        return contextMenu;
    }

    //图片右键删除功能
    public void deleteImage(String path) {
        File file = new File(path.substring(5));

        if(file.delete()){
            Controller.refreshPane();
            flash();
        }

    }

    //图片右键复制功能
    public void copyImage(String path){
        //源文件地址
        File source=new File(path.substring(5));
        //目的文件地址
        File dest=new File(source.getParentFile().getAbsolutePath()+'/'+getFileNameNoEx(source.getName())
                +"_1"+'.' +source.getAbsolutePath().substring(source.getAbsolutePath().lastIndexOf(".") + 1));
        System.out.println(dest);

        try {
            //读取源地址文件的字节流
            FileInputStream in=new FileInputStream(source);
            FileOutputStream out=new FileOutputStream(dest);
            byte[]bs=new byte[1026];
            int count;
            while ((count=in.read(bs,0,bs.length))!=-1) {
                //把读取到的字节流写入到目的地址的文件里面
                out.write(bs,0,count);

            }
            //刷新下输出流
            out.flush();
            // 关闭输入流和输出流
            out.close();
            out.close();
            System.out.println("复制成功！");

            flash();


            Controller.refreshPane();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //图片右击重命名功能
    public void renameImage(String path){
        File file = new File(path.substring(5));
        TextField textField = new TextField();
        Stage stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setTitle("重命名：");
        stage.setScene(new Scene(textField,250,50));
        stage.show();

        String suffix = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1);

        textField.setOnAction(actionEvent ->
        {
            File nameTo = new File(file.getParentFile().getAbsolutePath()+'/'+textField.getText()+'.'+suffix);
            if(file.renameTo(nameTo)){
                Controller.refreshPane();
                System.out.println("rename success");
            }
            stage.close();

        });

    }

    //Java文件操作 获取不带扩展名的文件名
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }

    public void flash(){

        MyFolderPane myFolderPane = new MyFolderPane();
        myFolderPane.getInformationOfFolder();

    }
}
