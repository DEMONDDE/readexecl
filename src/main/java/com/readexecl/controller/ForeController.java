package com.readexecl.controller;

import com.readexecl.util.ExeclRead;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 胡建德
 */
@Controller
public class ForeController {

    @GetMapping("/")
    public String returnto(){
        return "main";
    }
    @GetMapping("/test")
    public String returntotest(){
        return "test";
    }

    @PostMapping("/read")
    @ResponseBody
    public Object readExecl(MultipartFile file,String sql,String variable) throws IOException {
//        File execl = new File("/usr/local/execlfile"+file.getOriginalFilename());
        File execl = new File("C:\\Users\\78114\\Desktop\\test\\",file.getOriginalFilename());
        System.out.println(execl);
        file.transferTo(execl);
        List<String> value = ExeclRead.readExcel(execl);
        List<String> result = ExeclRead.changeto(sql,variable,value);
        return result;
    }
}
