package sample;

import javafx.scene.control.Label;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImagePreviewInformation {
    private final String imagePath;
    private final String imageName;
    private final String sizeOfImage;
    private final Label imageInformationLabel = new Label();
    private String lastAccessTime;
    private String lastModifiedTime;
    private UserPrincipal owner;
    private int widthOfImage;
    private int heightOfImage;


    public String getImagePath() {
        return imagePath;
    }

    public String getImageName() {
        return imageName;
    }

    public Label getImageInformationLabel() {
        return imageInformationLabel;
    }

    public String getSizeOfImage() {
        return sizeOfImage;
    }


    ImagePreviewInformation(String imagePath, String imageName) throws IOException {


        this.imagePath = imagePath.substring(5);

        Image image = new Image(imagePath);
        this.imageName = imageName;

        File file = new File(this.imagePath);
        this.sizeOfImage = String.format("%.2f",file.length()/1024.0);


        BufferedImage sourceImg = ImageIO.read(new FileInputStream(file));
        this.widthOfImage = sourceImg.getWidth();
        this.heightOfImage = sourceImg.getHeight();



        //设置时间格式
        Path testPath = Paths.get(file.getPath());
        BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
        BasicFileAttributes basicFileAttributes = basicView.readAttributes();
        //df.format（）是将获取的时间转换成设置的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        this.lastAccessTime = df.format(new Date(basicFileAttributes.lastAccessTime().toMillis()));
        this.lastModifiedTime = df.format(new Date(basicFileAttributes.lastModifiedTime().toMillis()));
        FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
        this.owner = ownerView.getOwner();

        setInformationOfImageOnLabel();

    }

    private void setInformationOfImageOnLabel(){
        imageInformationLabel.setText("图片名："+imageName+"\n"
                +"位置："+imagePath+"\n"
                +"图片大小："+sizeOfImage +"KB"+"\n"
                +"图片宽度："+widthOfImage+"\n"
                +"图片高度："+heightOfImage+"\n"
                +"最后访问时间：" + lastAccessTime+"\n"
                +"最后修改时间：" + lastModifiedTime+"\n"
                +"文件所有者："+owner);

    }

    public void addInformationOfImageOnPane(Label label){
        MyPane.imagePane.getChildren().add(label);
    }



}
