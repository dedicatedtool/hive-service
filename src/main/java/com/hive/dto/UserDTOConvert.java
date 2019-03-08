package com.hive.dto;

import com.google.common.base.Converter;
import com.hive.entity.UserEnity;
import org.springframework.beans.BeanUtils;

/**
 *
 *
 * @author JackLee
 * @version 1.0
 * created  2019/3/7 20:42
 */
public class UserDTOConvert extends Converter<UserDTO, UserEnity> {

    @Override
    protected UserEnity doForward(UserDTO userDTO) {
        UserEnity user = new UserEnity();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }

    @Override
    protected UserDTO doBackward(UserEnity userEnity) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userEnity, userDTO);
        return userDTO;
    }
}
