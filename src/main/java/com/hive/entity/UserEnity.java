package com.hive.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 文件说明：
 * 这是文件说明
 *
 * @author JackLee
 * @version 1.0
 * created  2019/3/7 20:30
 */

@Accessors(chain = true)
@Getter
@Setter
public class UserEnity {
    private int id;
    private String name;
    private int sex;
    @Override
    public String toString() {
        return "UserEnity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
