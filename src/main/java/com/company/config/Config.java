package com.company.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class Config
{
    public Config() {}


   private String url;
   private String user;
   private String password;

  public Config(String url, String user, String password)
  {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl()
    {
        return url;
    }
    public String getUser()
    {
        return user;
    }
    public String getPassword()
    {
        return password;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setUser(String user)
    {
        this.user = user;
    }


}
