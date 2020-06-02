package com.dfq.putao.Service.impl;

import com.dfq.putao.Service.InitService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.stereotype.Service;

import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Mr Duan
 * @create 2020-06-02 16:58
 */
@Service
public class InitServiceImpl  implements InitService {
    @Override
    public void init() {
        try {
            Connection conn =getMySqlConnection();
            ScriptRunner runner = new ScriptRunner(conn);
            Resources.setCharset(Charset.forName("GBK")); //设置字符集,不然中文乱码插入错误
            runner.setLogWriter(null);//设置是否输出日志
            // 绝对路径读取
//          Reader read = new FileReader(new File("f:\\test.sql"));
            // 从class目录下直接读取
            Reader read = Resources.getResourceAsReader("schema.sql");
            runner.runScript(read);
            runner.closeConnection();
            conn.close();
            System.out.println("sql脚本执行完毕");
        } catch (Exception e) {
            System.out.println("sql脚本执行发生异常");
            e.printStackTrace();
        }
    }
    //设置数据库连接信息
    public static Connection getMySqlConnection() throws Exception {
        String uername = "dfq";
        String password = "123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=test";
        return DriverManager.getConnection(url,uername,password);
    }
}

