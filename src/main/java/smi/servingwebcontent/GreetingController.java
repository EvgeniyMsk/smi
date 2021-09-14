package smi.servingwebcontent;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class GreetingController {

    @GetMapping("/upload")
    public String getup(Model model) {
        String rootPath = "/Users/qsymond/Desktop/uploads/loadFiles";
        List<String> list = new ArrayList<String>();
        for (File file : new File(rootPath).listFiles())
            list.add(file.getName());
        model.addAttribute("list", list);
        return "upload";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String name = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                String rootPath = "/Users/qsymond/Desktop/uploads";
                File dir = new File(rootPath + File.separator + "loadFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();
                return "Успешно загружен файл" + name;
            } catch (Exception e) {
                return "Ошибка загрузки " + name + " => " + e.getMessage();
            }
        } else {
            return "Ошибка загрузки " + name + " так как файл пустой.";
        }
    }

}
