package com.company.DataBase;

import java.sql.*;

public class ConnectDB
{
    private String url;
    private String user;
    private String password;
    public ConnectDB(String url,String user,String password)
    {
        this.url=url;
        this.user=user;
        this.password=password;
    }

    public Connection connect() throws Exception
    {
        Connection connection = DriverManager.getConnection(url, user, password);
       return connection;
    }


}
