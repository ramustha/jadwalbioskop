package com.ramusthastudio.zodiakbot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
  final
  Environment mEnv;
  @Autowired public Config(Environment mEnv) {this.mEnv = mEnv;}

  @Bean(name = "line.bot.channelSecret")
  public String getChannelSecret() { return mEnv.getProperty("line.bot.channelSecret"); }
  @Bean(name = "line.bot.channelToken")
  public String getChannelAccessToken() { return mEnv.getProperty("line.bot.channelToken"); }

  @Bean(name = "com.bioskop.base_url")
  public String getBioskopBaseUrl() { return mEnv.getProperty("com.bioskop.base_url"); }

  @Bean(name = "com.bioskop.api_key")
  public String getBioskopApiKey() { return mEnv.getProperty("com.bioskop.api_key"); }

  @Bean (name = "com.themoviedb.api_key")
  public String getMovieApiKey() {
    return System.getenv("com.themoviedb.api_key");
  }

  @Bean(name = "com.themoviedb.base_url")
  public String getMovieBaseUrl() {
    return mEnv.getProperty("com.themoviedb.base_url");
  }

  @Bean(name = "com.themoviedb.base_imdb_url")
  public String getMovieBaseImdbUrl() {
    return mEnv.getProperty("com.themoviedb.base_imdb_url");
  }

  @Bean(name = "com.themoviedb.base_video_url")
  public String getMovieBaseVideoUrl() {
    return mEnv.getProperty("com.themoviedb.base_video_url");
  }

  @Bean(name = "com.themoviedb.base_img_url")
  public String getMovieBaseImgUrl() {
    return mEnv.getProperty("com.themoviedb.base_img_url");
  }
}
