package com.laowen.common.utils;

import java.util.Random;
import java.util.UUID;

public class CommonUtil {

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return
     */
    public static String getLenStr(int length) {
        String base = "ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    //获取32位UUID
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
