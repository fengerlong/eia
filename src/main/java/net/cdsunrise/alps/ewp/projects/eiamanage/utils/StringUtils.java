package net.cdsunrise.alps.ewp.projects.eiamanage.utils;

import java.util.UUID;

public class StringUtils {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
