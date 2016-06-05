package cn.edu.zucc.form;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by zxy on 6/5/2016.
 */
public class BeanuserFileForm {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
