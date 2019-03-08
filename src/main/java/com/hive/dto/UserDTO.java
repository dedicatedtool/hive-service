package com.hive.dto;

import com.hive.entity.UserEnity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 数据传输
 *
 * @author JackLee
 * @version 1.0
 * created  2019/3/7 20:30
 */
@Accessors(chain = true)
@Getter
@Setter
public class UserDTO {
    private Integer id;
    @NotNull
    private String name;
    private Integer sex;
    private Date birthday;
    public UserEnity convertToUser() {
        UserDTOConvert userDTOConvert = new UserDTOConvert();
        return userDTOConvert.convert(this);
    }
}

