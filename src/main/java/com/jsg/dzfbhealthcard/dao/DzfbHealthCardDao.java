package com.jsg.dzfbhealthcard.dao;


import java.util.Map;

public interface DzfbHealthCardDao {

    Map<String,Object> queryHealthCardByBrid(String brid, String yljgbm);

}
