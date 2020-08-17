package com.readexecl;

import com.readexecl.util.ExeclRead;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class test {

    @Test
    public void readTest(){
        String sql = "insert into value('name1','name2')";
        String va = "name1,name2";
        File file = new File("C:\\Users\\78114\\Desktop\\test.xlsx");
        List<String> read = ExeclRead.readExcel(file);
        List<String> changeto = ExeclRead.changeto(sql, va, read);
        System.out.println(changeto.get(0));


    }
}
